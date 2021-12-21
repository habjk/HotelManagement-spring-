package com.KKHHH.eHotels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.KKHHH.eHotels.domains.Hotel;

public interface HotelRepository extends CrudRepository<Hotel,Long>{
//	Hotel findById(long id);
	Hotel findById(long id);
	Hotel findByUser(long id);
	List<Hotel> findByIsConfirmed(short confirmation);

	
}
