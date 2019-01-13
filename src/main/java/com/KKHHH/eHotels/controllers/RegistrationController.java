package com.KKHHH.eHotels.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.KKHHH.eHotels.domains.User;
import com.KKHHH.eHotels.repositories.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/register/user")

public class RegistrationController {
	
	private UserRepository userRepository;
	
	@Autowired
	public RegistrationController(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	

	
	@ModelAttribute(name="register")
	public User registerUser(Model model) {
		return new User();
	}
	@GetMapping
	public String getRegisterHotelForm() {
		return "User/registerUser";
	}
	/*@ModelAttribute(name="registerManager")
	public User registerManager(Model model) {
		return new User();
	}
	*/
	@PostMapping
	public String processRegisterHotel(@Valid User user,Errors errors){
		if(errors.hasErrors()) {
			log.info("ght");
			return "User/registerUser";
		}
		User registerUser=userRepository.save(user);
		//User registerManager=userRepository.save(manager);
		log.info("Order Submited:"+registerUser);
		//log.info("Manager Submited:"+registerManager);
		
		return "index";
	}
	
}
