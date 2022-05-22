package com.algo.onlineshipbooking.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.algo.onlineshipbooking.dao.UserDao;
import com.algo.onlineshipbooking.model.User;

public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserDao dao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = dao.getUserByUsername(username);
		if(user==null)
		{
			throw new UsernameNotFoundException("User Not Found!");
		}
		CustomUserDetails cud = new CustomUserDetails(user);
		return cud;
	}

}