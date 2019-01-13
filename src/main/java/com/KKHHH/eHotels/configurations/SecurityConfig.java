package com.KKHHH.eHotels.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable();
		//http.authorizeRequests().antMatchers("/","/register/user").permitAll().anyRequest().authenticated().and().authorizeRequests()
		//.antMatchers("/css/**","/js/**","/images/**","/fonts/**","/assets/**").permitAll().anyRequest().authenticated();
	}
}
