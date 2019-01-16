package com.KKHHH.eHotels.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/default")
public class DefaultController {
	@GetMapping
	public String getDfault(@AuthenticationPrincipal UserDetails userDetails) {
		if(userDetails.getAuthorities().toString().equals("[MANAGER]")) {
			log.info("here");
			return "HotelHome";
		}else if(userDetails.getAuthorities().toString().equals("[ADMIN]")){
			return "AdminHome";
		}else if(userDetails.getAuthorities().toString().equals("[USER]")){
			return "UserHome";
		}else {
			return "AdminHome";
		}
	}
}
