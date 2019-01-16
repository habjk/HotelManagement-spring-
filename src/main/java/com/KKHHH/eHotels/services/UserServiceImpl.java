package com.KKHHH.eHotels.services;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.KKHHH.eHotels.domains.Role;
import com.KKHHH.eHotels.domains.User;
import com.KKHHH.eHotels.repositories.RoleRepositiory;
import com.KKHHH.eHotels.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

   @Autowired
   private UserRepository userRepository;

   @Autowired
   private RoleRepositiory roleRepository;
   
   @Autowired
   private BCryptPasswordEncoder passwordEncoder;

   public User findByEmail(String email) {
       return userRepository.findUserByEmail(email);

   }
   public void saveHotelManager(User user) {
   	Role r;
   	r=new Role();
   	r.setUser(user);
   	r.setName("MANAGER");
   	user.setRole(r);
   	user.setPassword(passwordEncoder.encode(user.getPassword()));
   	userRepository.save(user);
   	roleRepository.save(r);
   	
   }
   public void saveAdminManager(User user) {
	   	Role r;
	   	r=new Role();
	   	r.setUser(user);
	   	r.setName("ADMIN");
	   	user.setRole(r);
	   	user.setPassword(passwordEncoder.encode(user.getPassword()));
	   	userRepository.save(user);
	   	roleRepository.save(r);
	   	
	   }
   public void saveUser(User user) {
	   Role r;
	   	r=new Role();
	   	r.setUser(user);
	   	r.setName("USER");
	   	user.setRole(r);
	   
       user.setPassword(passwordEncoder.encode(user.getPassword()));
       userRepository.save(user);
   }
   /* public Manager save(UserRegistrationDto registration){
        Manager users = new Manager();
        users.setFirstName(registration.getFirstName());
        users.setLastName(registration.getLastName());
        users.setEmail(registration.getEmail());
        users.setPassword(passwordEncoder.encode(registration.getPassword()));
        users.setRoles(Arrays.asList(new Role("ROLE_USER")));
        return userRepository.save(users);
    }
*//*
   @Override
   public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
       return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRole()));
    }*/
   @Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		UserDetails userDetails = userRepository.findByEmail(email);
		
		if(userDetails != null) {
			return  userDetails;
		}
		throw new UsernameNotFoundException("User '" + email+ "' not found");
	}

	

	@Override
	public List<User> findAllUsersByRole(String role) {
		List<User> users=userRepository.findAllByRole(role);
		return users;
	}
	@Override
	public User findUserByEmail(String username) {
		return userRepository.findUserByEmail(username);
	}
}
