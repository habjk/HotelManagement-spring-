package com.KKHHH.eHotels.services;


import org.springframework.security.core.userdetails.UserDetailsService;

import com.KKHHH.eHotels.domains.User;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    //Manager save(UserRegistrationDto registration);
}
