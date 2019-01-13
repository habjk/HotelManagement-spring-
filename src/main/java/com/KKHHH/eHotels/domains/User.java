package com.KKHHH.eHotels.domains;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Entity
@Slf4j
@Table(name="User")

public class User {

	public User() {}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	
	
	@NotNull
	@NotEmpty
	@Size(min=2,message="First Name Cannot Be Empty")
	private String firstname;

	@NotNull
	@NotEmpty
	@Size(min=2,message="Last Name Cannot Be Empty")
	private String lastname;
	

	@NotNull
	@NotEmpty
	@Size(min=2,message="Middle Name Cannot Be Empty")
	private String middlename;
	
	@NotNull
	@NotEmpty
	@Email(message="Invalid Format")
	private String email;
	
	@NotNull
	@NotEmpty
	@Size(min=8,message="Passwrod Length Must Be 8+")
	private String password;
	
	@NotNull
	@NotEmpty
	@Size(min=4,message="Id No Cannot Be Empty")
	private String idno;
	
	

	@NotNull
	@NotEmpty
	@Size(min=4,message="City Cannot Be Empty")
	private String city;
	

	@NotNull
	@NotEmpty
	@Size(min=4,message="City Cannot Be Empty")
	private String subCity;
	
	@NotNull
	@NotEmpty
	@Size(min=4,message="State Cannot Be Empty")
	private String state;
	
	@NotNull
	@NotEmpty
	@Size(min=10,message="Acc No Cannot Be Empty")
	private String accno;
	
}
