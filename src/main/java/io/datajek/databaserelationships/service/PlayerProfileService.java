package io.datajek.databaserelationships.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.datajek.databaserelationships.entity.PlayerProfile;
import io.datajek.databaserelationships.repository.PlayerProfileRepository;

@Service
public class PlayerProfileService {
	@Autowired
	private PlayerProfileRepository playerProfileRepository;

	public List<PlayerProfile> allPlayerProfiles() {
		return playerProfileRepository.findAll();
	}

	public PlayerProfile getPlayerProfile(int id) {
		return playerProfileRepository.findById(id).get();
	}

	public PlayerProfile addPlayerProfile(PlayerProfile profile) {
		profile.setId(0);
		// check if profile contains nested player
		if (profile.getPlayer() != null) {
			profile.getPlayer().setPlayerProfile(profile);
		}
		return playerProfileRepository.save(profile);
	}

	public void deletePlayerProfile(int id) {
		PlayerProfile tempPlayerProfile = playerProfileRepository.findById(id).get();
		tempPlayerProfile.getPlayer().setPlayerProfile(null);
		tempPlayerProfile.setPlayer(null);
		playerProfileRepository.save(tempPlayerProfile);
		playerProfileRepository.delete(tempPlayerProfile);
	}
}
