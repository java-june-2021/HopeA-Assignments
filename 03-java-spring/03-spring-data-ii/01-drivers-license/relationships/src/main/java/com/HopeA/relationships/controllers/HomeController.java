package com.HopeA.relationships.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.HopeA.relationships.models.License;
import com.HopeA.relationships.models.Person;
import com.HopeA.relationships.services.DriverService;

@Controller
public class HomeController {
	@Autowired
	private DriverService dService;
	
	@RequestMapping ("/")
	public String index(Model viewModel) {
		viewModel.addAttribute("persons", this.dService.allPersons());
		return "index.jsp";
	}
	
	//Create New Person
	
	@RequestMapping("/persons/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "new.jsp";
	}
	
	@RequestMapping (value="/new", method=RequestMethod.POST)
	public String addedPerson(@Valid @ModelAttribute("person") Person person, BindingResult result, Model viewModel) {
		if(result.hasErrors()) {
			return "new.jsp";
		}
		this.dService.createPerson(person);
		return "redirect:/";
	}
	
	//Create New License
	
	@RequestMapping("licenses/create")
	public String createLicense(Model viewModel, @ModelAttribute("licence") License license) {
		viewModel.addAttribute("people", this.dService.getUnlicensedPeople());
		return "newlicense.jsp";
	}
	
	@RequestMapping(value="/newlicense", method=RequestMethod.POST)
	public String addLicense(@Valid @ModelAttribute("license") License license, BindingResult result, Model viewModel) {
		if(result.hasErrors()) {
			viewModel.addAttribute("people", this.dService.getUnlicensedPeople());
			return "newlicense";
		}
		this.dService.createLicense(license);
		return "redirect:/";
	}
	
	//Show one Person 
	
	@RequestMapping("/{id}")
	public String show(Model viewModel, @PathVariable("id") Long id) {
		viewModel.addAttribute("person", this.dService.findPerson(id));
		return "show.jsp";
	}
	
	
	

}
