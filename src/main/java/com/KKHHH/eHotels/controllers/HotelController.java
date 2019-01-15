package com.KKHHH.eHotels.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.KKHHH.eHotels.domains.Hotel;
import com.KKHHH.eHotels.domains.ImageModel;
import com.KKHHH.eHotels.repositories.HotelRepository;
import com.KKHHH.eHotels.repositories.ImageRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/hotelProfile")
public class HotelController {
	
	private HotelRepository hotelRepository;
	private ImageRepository imageRepository;
	@Autowired
	public  HotelController(HotelRepository hotelRepository, ImageRepository imageRepository) {
		this.hotelRepository=hotelRepository;
		this.imageRepository=imageRepository;
	}

	@ModelAttribute(name="profile")
	public Hotel profileHotel(Model model) {
		Hotel hotel=hotelRepository.findById((long) 1);
		//Hotel hotel=new Hotel();
		log.info("asdfghj");
		log.info(hotel.getHotelName());
		return hotel;
	}
	@ModelAttribute(name="images")
	public ImageModel profileImageModel(Model model){
		/*List<ImageModel> images=imageRepository.findByHotelId((long) 1);
		for(ImageModel image:images) {
			model.addAttribute("s",image.getPic());
		}*/
		ImageModel images=imageRepository.findById(1);
		log.info("message");
		return images;
	}
	@GetMapping
	public String getHotelProfile() {
		return "hotelProfile";
	}
	
}
