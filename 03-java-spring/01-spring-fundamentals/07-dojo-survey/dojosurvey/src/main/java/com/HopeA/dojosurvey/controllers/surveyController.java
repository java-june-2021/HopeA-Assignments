package com.HopeA.dojosurvey.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.HopeA.dojosurvey.models.Survey;

@Controller
public class surveyController {
	
	@RequestMapping("/")
	public String index(Model viewModel) {
		viewModel.addAttribute("locations", new String[] {"San Jose", "Los Angeles", "San Diego"});
		viewModel.addAttribute("favorites", new String[] {"Python", "Java", "Ruby"});
		return "index.jsp";
	}
	
	@RequestMapping(value="/result", method=RequestMethod.POST) 
		public String result(@RequestParam("name") String name, @RequestParam("location") String location, 		@RequestParam("favorite") String favorite, @RequestParam("comment") String comment, Model viewModel) {
		viewModel.addAttribute("result", new Survey(name, location, favorite, comment));
		return "result.jsp";
	}
	

}
