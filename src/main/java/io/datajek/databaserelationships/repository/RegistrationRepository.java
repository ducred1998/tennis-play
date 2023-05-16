package io.datajek.databaserelationships.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.datajek.databaserelationships.entity.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Integer>{

}
