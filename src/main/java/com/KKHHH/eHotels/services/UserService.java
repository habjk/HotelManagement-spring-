package com.KKHHH.eHotels.services;


import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.KKHHH.eHotels.domains.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User findUserByEmail(String email);
	void saveUser(User user);
	void saveHotelManager(User user);
	List<User> findAllUsersByRole(String role);
}
