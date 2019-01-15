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
import com.KKHHH.eHotels.domains.ReserveRoom;
import com.KKHHH.eHotels.repositories.HotelRepository;
import com.KKHHH.eHotels.repositories.ReserveRoomRepository;
import com.KKHHH.eHotels.repositories.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/register/booknow")
public class ReserveRoomController {
	
	private ReserveRoomRepository reserveRoomRepository;
	
	
	@Autowired
	public ReserveRoomController(ReserveRoomRepository reserveRoomRepository) {
		
		this.reserveRoomRepository=reserveRoomRepository;
		
	}
	
	@GetMapping
	public String getRegisterHotelForm() {
		return "booknow";
	}
	
	@ModelAttribute(name="reserve")
	public ReserveRoom reserveRoom(Model model) {
		return new ReserveRoom();
	}
	
	@PostMapping
	public String processReserveRoom(@Valid ReserveRoom room , Errors errors){
		
		if(errors.hasErrors()) {
			
			return "booknow";
		}
		
		ReserveRoom reserveRoom=reserveRoomRepository.save(room);
		
		
		return "redirect:/";
	}
}
