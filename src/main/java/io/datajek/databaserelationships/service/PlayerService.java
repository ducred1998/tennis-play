package io.datajek.databaserelationships.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.datajek.databaserelationships.entity.Player;
import io.datajek.databaserelationships.entity.PlayerProfile;
import io.datajek.databaserelationships.entity.Registration;
import io.datajek.databaserelationships.repository.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository playerRepository;

	public List<Player> allPlayers() {
		return playerRepository.findAll();
	}

	public Player getPlayer(int id) {
		return playerRepository.findById(id).get();
	}

	public Player addPlayer(Player player) {
		player.setId(0);
		// check if player contains nested profile
		if (player.getPlayerProfile() != null) {
			player.getPlayerProfile().setPlayer(player);
		}
		return playerRepository.save(player);
	}

	public void deletePlayer(int id) {
		playerRepository.deleteById(id);
	}

	public Player assignProfile(int id, PlayerProfile profile) {
		Player player = playerRepository.findById(id).get();
		player.setPlayerProfile(profile);
		// bidirectional
		player.getPlayerProfile().setPlayer(player);
		return playerRepository.save(player);
	}

	public Player assignRegistration(int id, Registration registration) {
		Player player = playerRepository.findById(id).get();
		player.registerPlayer(registration);
		return playerRepository.save(player);
	}

	public Player removeRegistration(int id, Registration registration) {
		Player player = playerRepository.findById(id).get();
		player.removeRegistration(registration);
		return playerRepository.save(player);
	}
}