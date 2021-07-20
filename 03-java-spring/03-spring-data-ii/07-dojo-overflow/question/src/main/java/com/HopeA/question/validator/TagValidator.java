package com.HopeA.question.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.HopeA.question.models.Question;

@Component
public class TagValidator {
	
	  // 1
  
    public boolean supports(Class<?> clazz) {
        return Question.class.equals(clazz);
    }
    
    // 2
   
    public void validate(Object target, Errors errors) {
       Question question = (Question) target;
        
       String[] tags = question.getFrontTags().split(", ");
       if(tags.length > 3) {
    	   errors.rejectValue("frontTags", "Too Many Tags", "Only 3 tags allowed");
       }
              
    }

}
