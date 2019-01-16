package com.KKHHH.eHotels.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KKHHH.eHotels.domains.NewAdmin;
import com.KKHHH.eHotels.repository.NewAdminRepository;

@Service("NewAdminService")
public class NewAdminService {


	private NewAdminRepository userRepository;
	
    @Autowired
    public NewAdminService(NewAdminRepository userRepository) { 
      this.userRepository = userRepository;
    }
    
	public NewAdmin findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public NewAdmin findByConfirmationToken(String confirmationToken) {
		return userRepository.findByConfirmationToken(confirmationToken);
	}
	
	public void saveUser(NewAdmin user) {
		userRepository.save(user);
	}

}