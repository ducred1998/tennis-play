package io.datajek.databaserelationships.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.datajek.databaserelationships.entity.Category;
import io.datajek.databaserelationships.entity.Registration;
import io.datajek.databaserelationships.entity.Tournament;
import io.datajek.databaserelationships.service.CategoryService;
import io.datajek.databaserelationships.service.RegistrationService;
import io.datajek.databaserelationships.service.TournamentService;

@RestController
@RequestMapping("/tournaments")
public class TournamentController {

	@Autowired
	private TournamentService tournamentService;

	@Autowired
	private RegistrationService registrationService;

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public List<Tournament> allTournaments() {
		return tournamentService.allTournaments();
	}

	@GetMapping("/{id}")
	public Tournament getTournament(@PathVariable int id) {
		return tournamentService.getTournament(id);
	}

	@PostMapping
	public Tournament addTournament(@RequestBody Tournament tournament) {
		return tournamentService.addTournament(tournament);
	}

	@PutMapping("/{id}/registrations/{registration_id}")
	public Tournament addRegistration(@PathVariable int id, @PathVariable int registration_id) {
		Registration registration = registrationService.getRegistration(registration_id);
		System.out.println(registration);
		return tournamentService.addRegistration(id, registration);
	}

	@PutMapping("/{id}/remove_registrations/{registration_id}")
	public Tournament removeRegistration(@PathVariable int id, @PathVariable int registration_id) {
		Registration registration = registrationService.getRegistration(registration_id);
		System.out.println(registration);
		return tournamentService.removeRegistration(id, registration);
	}

	@DeleteMapping("/{id}")
	public void deleteTournament(@PathVariable int id) {
		tournamentService.deleteTournament(id);
	}

	@PutMapping("/{id}/categories/{category_id}")
	public Tournament addCategory(@PathVariable int id, @PathVariable int category_id) {
		Category category = categoryService.getCategory(category_id);
		return tournamentService.addCategory(id, category);
	}

	@PutMapping("/{id}/remove_categories/{category_id}")
	public Tournament removeCategory(@PathVariable int id, @PathVariable int category_id) {
		Category category = categoryService.getCategory(category_id);
		System.out.println(category);
		return tournamentService.removeCategory(id, category);
	}
}
