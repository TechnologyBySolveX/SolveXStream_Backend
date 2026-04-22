package com.solvex.stream.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//AuthController.java
import org.springframework.web.bind.annotation.*;

import com.solvex.stream.entity.User;
import com.solvex.stream.repository.UserRepository;

import java.util.Optional;
import java.util.List;



@CrossOrigin(origins = "http://98.130.8.136")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

 private final UserRepository repo;

 public AuthController(UserRepository repo) {
     this.repo = repo;
 }

// Getting All the Data from the database for testing Purpose Okay 
 
 @GetMapping
 public List<User> getAllUserData(){
	 System.out.println("I am calling the get All user data Methods");
	 return repo.findAll(); 
 }


 // SIGNUP
 @PostMapping("/signup")
 public String signup(@RequestBody User user) {
     Optional<User> existing = repo.findByUserName(user.getUserName());
     if (existing.isPresent()) {
         return "Username already exists!";
     }
     user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
     repo.save(user);
     return "Signup successful!";
 }

 // LOGIN
 @PostMapping("/login")
 public String login(@RequestBody User user, String password) {
     Optional<User> existing = repo.findByUserName(user.getUserName());
     System.out.println("The User name is : ="+user.getUserName());
     System.out.println("The password  is : ="+user.getPassword());
     
     System.out.println("The password is : ="+password);
     
		/*
		 * if (existing.isPresent() &&
		 * existing.get().getPassword().equals(user.getPassword())) { return
		 * "Login successful!"; }
		 */if (user != null &&
 	        new BCryptPasswordEncoder().matches(user.getPassword(), user.getPassword())) {
 	        return "Login successful!";
 	    }
     return "Invalid credentials!";
 }
}
