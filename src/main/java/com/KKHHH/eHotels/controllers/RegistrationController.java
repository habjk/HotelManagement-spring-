package com.KKHHH.eHotels.controllers;

import javax.validation.Valid;
<<<<<<< HEAD
=======
import javax.websocket.Session;
>>>>>>> c666b211eb6dc5a4fbb55a6e9ca80961c9bcf826

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD

import com.KKHHH.eHotels.domains.User;
=======
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import com.KKHHH.eHotels.domains.Hotel;
import com.KKHHH.eHotels.domains.User;
import com.KKHHH.eHotels.repositories.HotelRepository;
>>>>>>> c666b211eb6dc5a4fbb55a6e9ca80961c9bcf826
import com.KKHHH.eHotels.repositories.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
<<<<<<< HEAD
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
=======
@RequestMapping("/register/hotel")

public class RegistrationController {
	
	private HotelRepository hotelRepository;
	private UserRepository userRepository;
	
	@Autowired
	public RegistrationController(HotelRepository hotelRepository,UserRepository userRepository) {
		this.hotelRepository=hotelRepository;
		this.userRepository=userRepository;
	}
	
	@GetMapping
	public String getRegisterHotelForm() {
		return "registerHotel";
	}
	
	@ModelAttribute(name="register")
	public Hotel registerHotel(Model model) {
		return new Hotel();
	}
	@ModelAttribute(name="registerManager")
	public User registerManager(Model model) {
		return new User();
	}
	
	@PostMapping
	public String processRegisterHotel(@Valid Hotel hotel,@Valid User manager,Errors errors){
		if(errors.hasErrors()) {
			log.info("ght");
			return "registerHotel";
		}
		Hotel registerHotel=hotelRepository.save(hotel);
		manager.setHotel(registerHotel);
		User registerManager=userRepository.save(manager);
		
	
		
	
		log.info("Order Submited:"+registerHotel);
		log.info("Manager Submited:"+registerManager);
>>>>>>> c666b211eb6dc5a4fbb55a6e9ca80961c9bcf826
		
		return "index";
	}
	
}
