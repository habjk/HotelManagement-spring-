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

import com.KKHHH.eHotels.domains.Hotel;
import com.KKHHH.eHotels.domains.User;
import com.KKHHH.eHotels.repositories.HotelRepository;
import com.KKHHH.eHotels.repositories.UserRepository;
import com.KKHHH.eHotels.services.UserServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/registration")

public class RegistrationHotelController {
	
	private HotelRepository hotelRepository;

	private UserRepository userRepository;
	private UserServiceImpl userImpl;
	
	
	@Autowired
	public RegistrationHotelController(HotelRepository hotelRepository,UserRepository managerRepository,UserServiceImpl userServiceImple) {
		this.hotelRepository=hotelRepository;
		this.userRepository=managerRepository;
		this.userImpl=userServiceImple;
	}
	/*@Autowired
	public RegistrationController(HotelRepository hotelRepository, ManagerRepository managerRepository) {
		this.hotelRepository=hotelRepository;
		this.managerRepository=managerRepository;
	}*/
	
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
	public String processRegisterHotel(@Valid Hotel hotel, @Valid User manager, Errors errors){

		if(errors.hasErrors()) {
			log.info("ght");
			return "registerHotel";
		}
		Hotel registerHotel=hotelRepository.save(hotel);
		manager.setHotel(registerHotel);
		userImpl.saveHotelManager(manager);
		// User registedManager=userRepository.save(manager);
		
		log.info("Order Submited:"+registerHotel);
		
		
		return "index";

		
	

	}
	
}
