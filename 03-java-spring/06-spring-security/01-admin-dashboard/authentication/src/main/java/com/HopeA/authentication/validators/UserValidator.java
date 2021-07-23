package com.HopeA.authentication.validators;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.HopeA.authentication.models.User;
import com.HopeA.authentication.repositories.UserRepository;



@Component
public class UserValidator {
	
	private UserRepository userRepository;
	
	public UserValidator(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		User user = (User)target;
		
		if(!user.getPassword().equals(user.getPasswordConfirmation())) {
			errors.rejectValue("password", "Match", "Password does not match." );
		}
		
		if(this.userRepository.existsByEmail(user.getEmail())) {
			errors.rejectValue("email", "Match", "Email has already been registered.");
		}
		
	}
	
		

}
