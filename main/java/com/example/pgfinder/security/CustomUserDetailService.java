package com.example.pgfinder.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.pgfinder.exception.ResourceNotFoundException;
import com.example.pgfinder.models.User;
import com.example.pgfinder.models.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String user_name) throws UsernameNotFoundException {
		// loading user from database by user_name
		User user = this.userRepo.findByUsername(user_name).orElseThrow(() -> new ResourceNotFoundException("User "+user_name));
		
		return user;
	}

}
