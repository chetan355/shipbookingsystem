package com.algo.onlineshipbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algo.onlineshipbooking.dao.UserDao;
import com.algo.onlineshipbooking.model.User;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	public User insertUser(User user) {
		return userDao.save(user);
	}
	public User getUserById(Long id) {
		User user = userDao.findById(id).get();
		return user;
	}
	public List<User> getAllUsers(){
		List<User> allUsers = userDao.findAll();
		return allUsers;		
	}
}