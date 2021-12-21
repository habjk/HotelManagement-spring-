package com.KKHHH.eHotels.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.KKHHH.eHotels.domains.Hotel;
import com.KKHHH.eHotels.domains.User;
import com.KKHHH.eHotels.repositories.HotelRepository;
import com.KKHHH.eHotels.repositories.UserRepository;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/default")
public class DefaultController {
	
	private HotelRepository hotelRepository;
	private UserRepository userRepository;
	private User user;
	private Hotel hotel;
	
	@Autowired
	public DefaultController(HotelRepository hotelRepositorry,UserRepository userRepository) {
		this.hotelRepository=hotelRepository;
		this.userRepository=userRepository;
	} 
	
	@GetMapping
	public String getDfault(@AuthenticationPrincipal UserDetails userDetails) {
		if(userDetails.getAuthorities().toString().equals("[MANAGER]")) {
		/*	
			user=(User)userDetails;
			hotel=user.getHotel();
			log.info("username:"+user.getHotel().toString());
			if(hotel.getIsConfirmed()==1) {
				log.info("how the hall");
				return "redirect:/Manager/Home";
			}else {
				log.info("Hello");
				return "redirect:/Manager/blog";
			}
			*/
			return "hotelProfile";
			
		}else if(userDetails.getAuthorities().toString().equals("[ADMIN]")){
			return "redirect:/Admin/Home";
		}else if(userDetails.getAuthorities().toString().equals("[USER]")){
			return "index";
		}else {
			return "AdmiHome";
		}
	}
}
