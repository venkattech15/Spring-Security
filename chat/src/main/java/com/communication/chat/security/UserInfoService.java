package com.communication.chat.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.communication.chat.dao.UserRepository;
import com.communication.chat.models.User;

@Service
public class UserInfoService implements UserDetailsService {
    
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User userDetail = userRepository.getUserByUserName(username);
		if (userDetail != null) {
			LoginUserContextHolder.setLoggedInUserID(userDetail.getId().toString());
			LoginUserContextHolder.setLoggedInUserName(userDetail.getUserName());
			// Converting User to UserInfoDetails
			return new UserInfoDetails(userDetail);
		} else {
			throw new UsernameNotFoundException("UserName Not Found");
		}

	}

}
