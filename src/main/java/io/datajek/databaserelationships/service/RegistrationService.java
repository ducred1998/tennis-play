package io.datajek.databaserelationships.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.datajek.databaserelationships.entity.Registration;
import io.datajek.databaserelationships.repository.RegistrationRepository;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepository;

	public List<Registration> allRegistrations() {
		return registrationRepository.findAll();
	}

	public Registration getRegistration(int id) {
		return registrationRepository.findById(id).get();
	}

	public Registration addRegistration(Registration registration) {
		registration.setId(0);
		return registrationRepository.save(registration);
	}

	public void deleteRegistration(int id) {
		registrationRepository.deleteById(id);
	}
}
