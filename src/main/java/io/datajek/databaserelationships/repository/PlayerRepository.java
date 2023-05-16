package io.datajek.databaserelationships.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.datajek.databaserelationships.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
