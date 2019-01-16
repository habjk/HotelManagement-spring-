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
import com.KKHHH.eHotels.repositories.UserRepository;
import com.KKHHH.eHotels.services.UserServiceImpl;

@Controller
@RequestMapping("/registrationAdmin")
public class RegisterAdminController {
	

	private UserServiceImpl userImpl;
	
	
	@Autowired
	public RegisterAdminController(UserRepository managerRepository,UserServiceImpl userServiceImple) {
		
		this.userImpl=userServiceImple;
	}
	/*@Autowired
	public RegistrationController(HotelRepository hotelRepository, ManagerRepository managerRepository) {
		this.hotelRepository=hotelRepository;
		this.managerRepository=managerRepository;
	}*/
	
	@GetMapping
	public String getRegisterHotelForm() {
		return "registerAdmin";
	}
	
	
	@ModelAttribute(name="registerAdmin")
	public User registerManager(Model model) {
		return new User();
	}
	
	
	@PostMapping
	public String processRegisterHotel( @Valid User Admin, Errors errors){

		if(errors.hasErrors()) {
			
			return "registerAdmin";
		}
		
		
		userImpl.saveAdminManager(Admin);
		// User registedManager=userRepository.save(manager);
		
		
		
		
		return "index";

		
	

	}
		
}
	
