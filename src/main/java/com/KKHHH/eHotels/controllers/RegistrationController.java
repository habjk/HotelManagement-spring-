package com.KKHHH.eHotels.controllers;

<<<<<<< HEAD
import javax.validation.Valid;
=======
import com.KKHHH.eHotels.model.Hotel;
import com.KKHHH.eHotels.model.Manager;
import com.KKHHH.eHotels.repository.HotelRepository;
import com.KKHHH.eHotels.repository.ManagerRepository;
import lombok.extern.slf4j.Slf4j;
>>>>>>> f3a00b910a8265240b584f6f18643a7916ed8868
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/registration")

public class RegistrationController {
	
	private HotelRepository hotelRepository;
	private ManagerRepository managerRepository;
	
	@Autowired
	public RegistrationController(HotelRepository hotelRepository, ManagerRepository managerRepository) {
		this.hotelRepository=hotelRepository;
		this.managerRepository = managerRepository;
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
	public Manager registerManager(Model model) {
		return new Manager();
	}
	
	
	@PostMapping
	public String processRegisterHotel(@Valid Hotel hotel, @Valid Manager manager, Errors errors){
		if(errors.hasErrors()) {
			log.info("ght");
			return "registerHotel";
		}
		Hotel registerHotel=hotelRepository.save(hotel);
		manager.setHotel(registerHotel);
		Manager registerManager= managerRepository.save(manager);
		

		log.info("Order Submited:"+registerHotel);
		log.info("Manager Submited:"+registerManager);
		
		return "login";
	}
	
}
