package com.HopeA.authentication.services;




import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.HopeA.authentication.models.User;
import com.HopeA.authentication.repositories.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	//register user and hash their password
	
	 public User registerUser(User user) {
		 System.out.println(user);
	        String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
	        user.setPassword(hash);
	        return this.userRepository.save(user);
	    }
	 
	 //find user by email
	 public User findByEmail(String email) {
		 return this.userRepository.findByEmail(email);
	 }
	 
	 //find user by id
	 
	 public User findUserById(Long id) {
//		 Optional<User> u = userRepository.findById(id);
//		 
//		 if(u.isPresent()) {
//			 return u.get();
//		 }else {
//			 return null;
//		 }
		 User user = this.userRepository.findById(id).orElse(null);
		 return user;
	 }
	 
	 //authenticate user
	 
	 public boolean authenticateUser(String email, String password) {
		 //first find the user by email
		 
		 User user = this.userRepository.findByEmail(email);
		 
		 //if we can't find it by email, return false
		 if(user == null) {
			 return false;
		 }else {
			 //if the password match, return true, else, return false
//			 if(BCrypt.checkpw(password, user.getPassword())) {
//				 return true;
//			 }else {
//				 return false;
//			 }
			 return BCrypt.checkpw(password, user.getPassword());
		 }
	 }

}
