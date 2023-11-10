package com.communication.chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.communication.chat.dao.UserRepository;
import com.communication.chat.models.User;

@Service 
public class AuthService {
    
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private PasswordEncoder encoder;
	
	public void addNewUser(User userInfo) {
		 userInfo.setPassword(encoder.encode(userInfo.getPassword())); 
		userRepository.saveUser(userInfo);
	}
}
