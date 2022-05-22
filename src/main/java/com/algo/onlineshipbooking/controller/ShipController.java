package com.algo.onlineshipbooking.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.algo.onlineshipbooking.helper.Message;
import com.algo.onlineshipbooking.model.User;
import com.algo.onlineshipbooking.service.ShipServices;
import com.algo.onlineshipbooking.service.UserService;

@Controller
public class ShipController 
{
	@Autowired
	private UserService userService;	
	@Autowired
	private ShipServices shipService;	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;	
	@RequestMapping("/")	
	public String home(Model model) {
		model.addAttribute("title","Home: Online Ship-Booking System");
		return "home";
	}
	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("title","About: Online Ship-Booking System");
		return "about";
	}
	@RequestMapping("/signup")
	public String signUp(Model model) {
		model.addAttribute("title","Register:Online Ship-Booking System");
		model.addAttribute("user",new User());
		return "signup";
	}
	@RequestMapping("/signin")
	public String signIn(Model model) {
		model.addAttribute("title","Login:Online Ship-Booking System");
		return "signin";
	}
	@PostMapping("/do_register")
	public String registerUser(@ModelAttribute("user") User user,BindingResult result,
			@RequestParam(value="agreement", defaultValue = "false") boolean agreement,
			@RequestParam(value="confirm_password",defaultValue = "") String confirm_password, 
			Model model,HttpSession session) 
	{
		try 
		{
			if(!user.getPassword().equals(confirm_password)) {
				throw new Exception("Please enter similar password in both fields.");
			}
			if(!agreement) {
				throw new Exception("You have not checked the terms and conditions");
			}
			if(result.hasErrors()) {
				System.out.println("ERROR:"+result.toString());
				model.addAttribute("user",user);
				return "signup";
			}
			user.setRole("ROLE_USER");
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			model.addAttribute("user", user);
			userService.insertUser(user);
			session.setAttribute("message", new Message("Succefully Registered!","alter-success"));
		}catch(Exception e) {
			model.addAttribute("user",user);
			session.setAttribute("message", new Message("Something went wrong!!"+e.getMessage(),"alter-danger"));
			return "signup";
		}
		return "signup";
	}
//	@PostMapping
//	public User insertUser(@RequestBody User user) {
//		return userService.insertUser(user);
//	}
//	@GetMapping("/user/{id}")
//	public User getUserById(@PathVariable Long id) {
//		return userService.getUserById(id);
//	}
//	@GetMapping("/user")
//	public List<User> getAllUsers() {
//		return userService.getAllUsers();
//	}
}