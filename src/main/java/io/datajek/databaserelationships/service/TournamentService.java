package io.datajek.databaserelationships.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.datajek.databaserelationships.entity.Category;
import io.datajek.databaserelationships.entity.Registration;
import io.datajek.databaserelationships.entity.Tournament;
import io.datajek.databaserelationships.repository.TournamentRepository;

@Service
public class TournamentService {

	@Autowired
	private TournamentRepository tournamentRepository;

	public List<Tournament> allTournaments() {
		return tournamentRepository.findAll();
	}

	public Tournament getTournament(int id) {
		return tournamentRepository.findById(id).get();
	}

	public Tournament addTournament(Tournament tournament) {
		tournament.setId(0);
		return tournamentRepository.save(tournament);
	}

	public void deleteTournament(int id) {
		tournamentRepository.deleteById(id);
	}

	public Tournament addRegistration(int id, Registration registration) {
		Tournament tournament = tournamentRepository.findById(id).get();
		tournament.addRegistration(registration);
		return tournamentRepository.save(tournament);
	}

	public Tournament removeRegistration(int id, Registration registration) {
		Tournament tournament = tournamentRepository.findById(id).get();
		tournament.removeRegistration(registration);
		return tournamentRepository.save(tournament);
	}

	public Tournament addCategory(int id, Category category) {
		Tournament tournament = tournamentRepository.findById(id).get();
		tournament.addCategory(category);
		return tournamentRepository.save(tournament);
	}
	
	public Tournament removeCategory(int id, Category category) {
		Tournament tournament = tournamentRepository.findById(id).get();
		tournament.removeCategory(category);
		return tournamentRepository.save(tournament);
	}
}
