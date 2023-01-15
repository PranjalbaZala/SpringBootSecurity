package com.example.pgfinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pgfinder.models.repository.UserRepository;
import com.example.pgfinder.models.User; 

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/")
public class UserController 
{
	@Autowired
	private UserRepository userRepository;
	
	//get all user
	@GetMapping("/user")
	public List<User> getAllUserDetails(){
		return userRepository.findAll();
	}
	
	//create the user
	@PostMapping("/user")
	public User createUser(@RequestBody User user)
	{
		return userRepository.save(user);
	}
}
