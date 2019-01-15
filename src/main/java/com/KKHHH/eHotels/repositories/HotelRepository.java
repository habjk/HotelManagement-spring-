package com.KKHHH.eHotels.repositories;

import org.springframework.data.repository.CrudRepository;

import com.KKHHH.eHotels.domains.Hotel;

public interface HotelRepository extends CrudRepository<Hotel,Long>{
	Hotel findById(long id);

}
