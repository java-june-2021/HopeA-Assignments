package com.HopeA.relationships.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HopeA.relationships.models.License;
import com.HopeA.relationships.models.Person;
import com.HopeA.relationships.repositories.LicenseRepository;
import com.HopeA.relationships.repositories.PersonRepository;

@Service
public class DriverService {
	@Autowired
	private PersonRepository pRepo;
	@Autowired
	private LicenseRepository lRepo;
	
//	private final PersonRepository pRepo;
//	private final LicenseRepository lRepo;
//	public DriverService(PersonRepository pRepo, LicenseRepository lRepo) {
//		this.pRepo = pRepo;
//		this.lRepo = lRepo;
//	}
	
	//Create Person
	
	public Person createPerson(Person newPerson) {
		return this.pRepo.save(newPerson);
	}
	
	//Find Person
	
	public Person findPerson(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	
	//Find All
	
	public List<Person> allPersons() {
		return this.pRepo.findAll();
	}
	
	//Find License
	
	public List<Person> getUnlicensedPeople() {
		return this.pRepo.findByLicenseIdIsNull();
	}
	
	//Return License Number
	
	public License createLicense(License license) {
		license.setNumber(this.generateLicenseNumber());
		return this.lRepo.save(license);
	}
	
	public int generateLicenseNumber() {
		License l = this.lRepo.findTopByOrderByNumberDesc();
		if(l == null) {
			return 1;
		}
		int previousLicenseNumber = l.getNumber();
		previousLicenseNumber++;
		return (previousLicenseNumber);
	}

}
