package com.KKHHH.eHotels.service;

import com.KKHHH.eHotels.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
//import net.javaguides.springboot.springsecurity.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    //Manager save(UserRegistrationDto registration);
}
