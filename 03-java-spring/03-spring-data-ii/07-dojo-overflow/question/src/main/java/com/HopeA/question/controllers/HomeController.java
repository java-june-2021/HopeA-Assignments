package com.HopeA.question.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.HopeA.question.models.Answer;
import com.HopeA.question.models.Question;
import com.HopeA.question.services.DiscussionService;
import com.HopeA.question.validator.TagValidator;

@Controller

public class HomeController {
	
	@Autowired
	private DiscussionService dService;
	@Autowired
	private TagValidator validator;
	
	//Root Route 
	
	@GetMapping("/")
	public String index(Model viewModel) {
		viewModel.addAttribute("allquest", this.dService.allQuestions());
		return "index.jsp";
		
	}
	
	//New Questions page
	
	@GetMapping("/new")
	public String newQuest(@ModelAttribute("quest") Question question) {
		return "new.jsp";
	}
	
	@PostMapping("/newQuest")
	public String addQuest(@Valid @ModelAttribute("quest") Question question, BindingResult result) {
		validator.validate(question, result);
		if(result.hasErrors()) {
			return "new.jsp";
		}
		this.dService.createQuestion(question);
		return "redirect:/";
		
	}
	
	//SHOW PAGE
	
	@GetMapping("/show/{id}")
	public String showQuest(@PathVariable("id") Long id, Model viewModel, @ModelAttribute("answer") Answer answer) {
		viewModel.addAttribute("quest", this.dService.findQuestion(id));
		return "show.jsp";
	}
	
	@PostMapping("/addAnswer")
	public String addAnswer(@Valid @ModelAttribute("answer") Answer answer, BindingResult result, Model viewModel) {
		//validator.validate(question, result);
		if(result.hasErrors()) {
			viewModel.addAttribute("quest", this.dService.findQuestion(answer.getQuestion().getId()));
			return "show.jsp";			
		}
		this.dService.createAnswer(answer);
		return "redirect:/show/" + answer.getQuestion().getId();
	}
	
	

}
