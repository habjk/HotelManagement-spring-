package com.KKHHH.eHotels.controllers;

import javax.servlet.Registration;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.KKHHH.eHotels.domains.User;
import com.KKHHH.eHotels.repositories.UserRepository;
import com.KKHHH.eHotels.services.UserServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/register/user")

public class RegistrationController {
	
	private UserRepository userRepository;

	private UserServiceImpl userImpl;
	@Autowired
	public RegistrationController(UserRepository userRepository,UserServiceImpl userImpl) {
		this.userImpl=userImpl;
		this.userRepository=userRepository;
	}


	
	@ModelAttribute(name="register")
	public User registerUser(Model model) {
		return new User();
	}
	@GetMapping
	public String getRegisterHotelForm() {
		return "registerUser";
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
			return "registerUser";
		}
		userImpl.saveUser(user);
		//User registerManager=userRepository.save(manager);
		//log.info("Order Submited:"+registerUser);
		//log.info("Manager Submited:"+registerManager);
		
		return "Index";
	}



	public static String create(Registration bulkRegistration, BindingResult result, ModelMap model) {
		// TODO Auto-generated method stub
		return null;
	}
	
}