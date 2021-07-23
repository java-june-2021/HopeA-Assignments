package com.HopeA.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.HopeA.authentication.models.User;
import com.HopeA.authentication.services.UserService;
import com.HopeA.authentication.validators.UserValidator;

@Controller
public class UserController {
	
	@Autowired
	private UserValidator validator;
	@Autowired
	private UserService userService;
	

	@RequestMapping("/registration")
	public String registrationForm(@ModelAttribute("user") User user) {
		return "registrationPage.jsp";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "loginPage.jsp";
	}

	@RequestMapping(value="/registration", method=RequestMethod.POST)
		public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		System.out.println(user);
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		System.out.println(user.getPasswordConfirmation());
		System.out.println(user.getCreatedAt());
		System.out.println(user.getUpdatedAt());
		//if result has errors, return the registration page(don't worry about validations just now)
		validator.validate(user, result);
		if(result.hasErrors()) {
			return "registrationPage.jsp";
		//else, save the user in the database, save the user id in session, and redirect them to the /home route	
		}
		User u = this.userService.registerUser(user);
		session.setAttribute("userID", u.getId());
		return "redirect:/home";
		
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model viewModel, HttpSession session) {
		//if user is authenticated, save their user id in session
		
		boolean isAuthenticated = userService.authenticateUser(email, password);
		if(isAuthenticated) {
			User u = this.userService.findByEmail(email);
			session.setAttribute("userID", u.getId());
			return "redirect:/home";
		//else, add error message and return the login page
		}else {
			viewModel.addAttribute("error", "Invalid. Please try again.");
			return "loginPage.jsp";
		}
	}
	
	@RequestMapping("/home")
	public String home(HttpSession session, Model viewModel) {
		//get user from session, save them in the model and return the home page
		Long userId = (Long) session.getAttribute("userID");
		User u = this.userService.findUserById(userId);
		viewModel.addAttribute("user", u);
		return "homePage.jsp";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		//invalidate session
		session.invalidate();
		//redirect to login page
		return "redirect:/login";
	}
	
	
}
