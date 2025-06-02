package com.smart.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.smart.Entity.User;
import com.smart.dao.Userrepo;

public class CustomUserServiceDetailimpl  implements UserDetailsService{

	@Autowired
	private Userrepo userrepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		//fetching user from database
		
	User user=	userrepository.getUserbyUsername(username);
	
	if (user==null) {
		throw new UsernameNotFoundException("could not found user!!");
	
	}
	
	CustomUserDetails csd = new CustomUserDetails(user);
	
	return csd;
	}

}
