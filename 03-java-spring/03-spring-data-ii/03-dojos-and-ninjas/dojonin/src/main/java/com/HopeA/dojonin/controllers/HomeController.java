package com.HopeA.dojonin.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.HopeA.dojonin.models.Dojo;
import com.HopeA.dojonin.models.Ninja;
import com.HopeA.dojonin.services.SchoolService;

@Controller
public class HomeController {
	@Autowired
	private SchoolService sService;
	
	@RequestMapping("/")
	public String index(Model viewModel) {
		viewModel.addAttribute("dojos", this.sService.allDojos());
		return "index.jsp";
	}
	
	//Adding a new Dojo
	
	@RequestMapping("/dojo/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "new.jsp";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String addDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model viewModel) {
		if(result.hasErrors()) {
			return "new.jsp";
			
		}
		this.sService.createDojo(dojo);
		return "redirect:/";
	}
	
	//Adding Ninja
	
	@RequestMapping("ninja/create")
	public String createNinja(Model viewModel, @ModelAttribute("ninja") Ninja ninja) {
		viewModel.addAttribute("dojos", this.sService.allDojos());
		return "newninja.jsp";
	}
	
	@RequestMapping(value="/newninja", method=RequestMethod.POST)
	public String addninja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dojos", this.sService.allDojos());
			return "newninja";
		}
		this.sService.createNinja(ninja);
		return "redirect:/";
	}
	
	//Show One Dojo
	
	@RequestMapping("/{id}")
	public String show(Model viewModel, @PathVariable("id") Long id) {
		viewModel.addAttribute("ninjas", this.sService.findByDojo(id));
		System.out.println(this.sService.findByDojo(id));
		return "show.jsp";
	}

}
