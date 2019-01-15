package com.KKHHH.eHotels.repositories;

import org.springframework.data.repository.CrudRepository;


import com.KKHHH.eHotels.domains.User;

public interface UserRepository extends CrudRepository<User,String>{

	com.KKHHH.eHotels.domains.User findByEmail(String email);
	User findByEmail1(String email);



}
