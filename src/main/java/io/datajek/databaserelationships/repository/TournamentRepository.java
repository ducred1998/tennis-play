package io.datajek.databaserelationships.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.datajek.databaserelationships.entity.Tournament;

public interface TournamentRepository extends JpaRepository<Tournament, Integer>{

}
