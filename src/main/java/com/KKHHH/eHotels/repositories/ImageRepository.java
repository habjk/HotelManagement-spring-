package com.KKHHH.eHotels.repositories;

import org.springframework.data.repository.CrudRepository;

import com.KKHHH.eHotels.domains.ImageModel;

public interface ImageRepository extends CrudRepository<ImageModel, Long> {
	//List<ImageModel> findByHotelId(Long hotelId);
	ImageModel findById(long id);
}
