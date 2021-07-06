package com.HopeA.languages.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.HopeA.languages.models.Language;
import com.HopeA.languages.services.LanguageService;

@Controller
public class LanguageController {
	private final LanguageService lService;
	private Long id;
	public LanguageController(LanguageService service) {
		this.lService = service;
	}
	
	@GetMapping("/")
	public String index(Model viewModel, @ModelAttribute("language") Language language) {
		viewModel.addAttribute("allLanguages", this.lService.allLanguages());
		return "indx.jsp";
	}
	
	@PostMapping("/")
	public String addLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result, Model viewModel) {
		if(result.hasErrors()) {
			viewModel.addAttribute("allLanguages", this.lService.allLanguages());
			return "indx.jsp";
		}
		this.lService.createLanguage(language);
		return "redirect:/";
	}
	
	@GetMapping("/show/{id}")
	public String showLang(Model viewModel, @PathVariable("id") Long id) {
		viewModel.addAttribute("thisLang", this.lService.findLanguage(id));
		return "show.jsp";
	}
	
	@GetMapping("/edit/{id}")
	public String editLang(@ModelAttribute("language") Language lang, Model viewModel, @PathVariable("id") Long id) {
		viewModel.addAttribute("language", this.lService.findLanguage(id));
		return "edit.jsp";
	}
	
	@PutMapping("/edit/{id}")
	public String editLang(@Valid @ModelAttribute("language") Language lang, BindingResult result, Model viewModel, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			viewModel.addAttribute("language", this.lService.findLanguage(id));
			return "edit.jsp";			
		}
		this.lService.updateLanguage(lang);
	return "redirect:/show/{id}";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteLang(@PathVariable("id") Long id) {
		this.lService.deleteLanguage(id);
		return "redirect:/";
	}

}
