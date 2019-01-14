package com.KKHHH.eHotels.service;



import com.KKHHH.eHotels.model.Role;
import com.KKHHH.eHotels.model.User;
import com.KKHHH.eHotels.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
//import net.javaguides.springboot.springsecurity.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

   public User findByEmail(String email) {
       return userRepository.findByEmail(email);

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
*/
   @Override
   public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
       return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
