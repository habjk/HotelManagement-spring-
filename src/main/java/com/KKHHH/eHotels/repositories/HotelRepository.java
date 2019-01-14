<<<<<<< HEAD
package com.KKHHH.eHotels.repositories;

import org.springframework.data.repository.CrudRepository;

import com.KKHHH.eHotels.domains.Hotel;
public interface HotelRepository extends CrudRepository<Hotel,Long>{

=======
package com.KKHHH.eHotels.repository;

import com.KKHHH.eHotels.model.Hotel;
import org.springframework.data.repository.CrudRepository;

public interface HotelRepository extends CrudRepository<Hotel,Long>{
	Hotel findById(long id);
>>>>>>> bbf28b4ac41bc566c82baba6ac4108fee1136e42
}
