package com.KKHHH.eHotels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.KKHHH.eHotels.domains.User;

public interface UserRepository extends CrudRepository<User,String>{

	//com.KKHHH.eHotels.domains.User findByEmail(String email);
	User findUserByEmail(String email);

	List<User> findAllByRole(String role);

	UserDetails findByEmail(String email);





}
