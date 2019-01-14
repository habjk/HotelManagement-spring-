package com.KKHHH.eHotels.controllers;

<<<<<<< HEAD
import javax.validation.Valid;
import javax.websocket.Session;

=======
<<<<<<< HEAD
import javax.validation.Valid;
=======
import com.KKHHH.eHotels.model.Hotel;
import com.KKHHH.eHotels.model.Manager;
import com.KKHHH.eHotels.repository.HotelRepository;
import com.KKHHH.eHotels.repository.ManagerRepository;
import lombok.extern.slf4j.Slf4j;
>>>>>>> f3a00b910a8265240b584f6f18643a7916ed8868
>>>>>>> bbf28b4ac41bc566c82baba6ac4108fee1136e42
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import com.KKHHH.eHotels.domains.Hotel;
import com.KKHHH.eHotels.domains.User;
import com.KKHHH.eHotels.repositories.HotelRepository;
import com.KKHHH.eHotels.repositories.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/register/hotel")
=======

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/registration")
>>>>>>> bbf28b4ac41bc566c82baba6ac4108fee1136e42

public class RegistrationController {
	
	private HotelRepository hotelRepository;
<<<<<<< HEAD
	private UserRepository userRepository;
	
	@Autowired
	public RegistrationController(HotelRepository hotelRepository,UserRepository userRepository) {
		this.hotelRepository=hotelRepository;
		this.userRepository=userRepository;
=======
	private ManagerRepository managerRepository;
	
	@Autowired
	public RegistrationController(HotelRepository hotelRepository, ManagerRepository managerRepository) {
		this.hotelRepository=hotelRepository;
		this.managerRepository = managerRepository;
>>>>>>> bbf28b4ac41bc566c82baba6ac4108fee1136e42
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
<<<<<<< HEAD
	public User registerManager(Model model) {
		return new User();
	}
	
	@PostMapping
	public String processRegisterHotel(@Valid Hotel hotel,Errors errors){
=======
	public Manager registerManager(Model model) {
		return new Manager();
	}
	
	
	@PostMapping
	public String processRegisterHotel(@Valid Hotel hotel, @Valid Manager manager, Errors errors){
>>>>>>> bbf28b4ac41bc566c82baba6ac4108fee1136e42
		if(errors.hasErrors()) {
			log.info("ght");
			return "registerHotel";
		}
		Hotel registerHotel=hotelRepository.save(hotel);
<<<<<<< HEAD
		//User registerManager=userRepository.save(manager);
		log.info("Order Submited:"+registerHotel);
		//log.info("Manager Submited:"+registerManager);
		
		return "index";
=======
		manager.setHotel(registerHotel);
		Manager registerManager= managerRepository.save(manager);
		

		log.info("Order Submited:"+registerHotel);
		log.info("Manager Submited:"+registerManager);
		
		return "login";
>>>>>>> bbf28b4ac41bc566c82baba6ac4108fee1136e42
	}
	
}
