package com.HopeA.dojonin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HopeA.dojonin.models.Dojo;
import com.HopeA.dojonin.models.Ninja;
import com.HopeA.dojonin.repositories.DojoRepository;
import com.HopeA.dojonin.repositories.NinjaRepository;

@Service
public class SchoolService {

	@Autowired
	private DojoRepository dRepo;
	@Autowired 
	private NinjaRepository nRepo;
	
	//Create Dojo
	
	public Dojo createDojo(Dojo newDojo) {
		return this.dRepo.save(newDojo);
	
	}
	
	//Create Ninja
	
	public Ninja createNinja(Ninja newNinja) {
		return this.nRepo.save(newNinja);
	}
	
	//Find All Dojos
	
	public List<Dojo> allDojos() {
		return this.dRepo.findAll();
	}
	
	//Find All Ninjas
	
//	public List<Ninja> allNinjas() {
//		return this.nRepo.findAll();
//		
//	}
	
	//Find One Dojo
	
	public Dojo findDojo(Long id) {
		return this.dRepo.findById(id).orElse(null);
	}

	public List<Ninja> findByDojo(Long id) {
		System.out.println(findDojo(id).getName());
		return this.nRepo.findByDojo(findDojo(id));
		
	}
}
