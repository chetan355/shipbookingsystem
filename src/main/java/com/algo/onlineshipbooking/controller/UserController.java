package com.algo.onlineshipbooking.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.algo.onlineshipbooking.dao.UserDao;
import com.algo.onlineshipbooking.model.User;

@Controller
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	private UserDao userDao;

	@ModelAttribute
	public void addUserProfile(Model model, Principal principal) {
		User user = userDao.getUserByUsername(principal.getName());
		model.addAttribute("title","Dashboard");
		model.addAttribute("user", user);
		
	}
	@RequestMapping("/index")
	public String dashboard(Model model, Principal principal) {		
		return "normal/dashboard";
	}
	
	@GetMapping("/show-ships")
	public String getShips(Model m) {
		return "normal/show-ships";
	}
}
