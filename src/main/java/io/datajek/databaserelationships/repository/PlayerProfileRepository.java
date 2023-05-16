package io.datajek.databaserelationships.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.datajek.databaserelationships.entity.PlayerProfile;

public interface PlayerProfileRepository extends JpaRepository<PlayerProfile, Integer> {

}
