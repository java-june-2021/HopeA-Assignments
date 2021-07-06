package com.HopeA.languages.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.HopeA.languages.models.Language;
import com.HopeA.languages.repositories.LanguageRepository;

@Service 
public class LanguageService {
	private LanguageRepository lRepo;
	public LanguageService(LanguageRepository repo) {
		this.lRepo = repo;
	}
	
	//display all
	public List<Language> allLanguages(){
		return this.lRepo.findAll();
	}
	
	//find one
	public Language findLanguage(Long id) {
		return this.lRepo.findById(id).orElse(null);
	}
	
	//create
	public Language createLanguage(Language newLang) {
		return this.lRepo.save(newLang);
	}
	
	//update
	public Language updateLanguage(Language updateLang) {
		return this.lRepo.save(updateLang);
	}
	
	//delete
	public void deleteLanguage(Long id) {
		this.lRepo.deleteById(id);
	}
}
