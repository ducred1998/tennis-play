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

import io.datajek.databaserelationships.entity.Player;
import io.datajek.databaserelationships.entity.PlayerProfile;
import io.datajek.databaserelationships.entity.Registration;
import io.datajek.databaserelationships.service.PlayerProfileService;
import io.datajek.databaserelationships.service.PlayerService;
import io.datajek.databaserelationships.service.RegistrationService;

@RestController
@RequestMapping("/players")
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	@Autowired
	private PlayerProfileService profileService;

	@Autowired
	private RegistrationService registrationService;

	@GetMapping
	public List<Player> allPlayers() {
		return playerService.allPlayers();
	}

	@GetMapping("/{id}")
	public Player getPlayer(@PathVariable int id) {
		return playerService.getPlayer(id);
	}

	@PostMapping
	public Player addPlayer(@RequestBody Player player) {
		return playerService.addPlayer(player);
	}

	@DeleteMapping("/{id}")
	public void deletePlayer(@PathVariable int id) {
		playerService.deletePlayer(id);
	}

	@PutMapping("/{id}/profiles/{profile_id}")
	public Player assignDetail(@PathVariable int id, @PathVariable int profile_id) {
		PlayerProfile profile = profileService.getPlayerProfile(profile_id);
		System.out.println(profile);
		return playerService.assignProfile(id, profile);
	}

	@PutMapping("/{id}/registrations/{registration_id}")
	public Player assignRegistration(@PathVariable int id, @PathVariable int registration_id) {
		Registration registration = registrationService.getRegistration(registration_id);
		return playerService.assignRegistration(id, registration);
	}
}
