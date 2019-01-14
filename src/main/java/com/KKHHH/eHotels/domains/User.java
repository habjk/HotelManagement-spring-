package com.KKHHH.eHotels.domains;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name="User")
public class User {
	
	@Id
	@NotNull
	@NotEmpty
	@Email(message="Incorrect Email")
	private String email;
	
	@NotNull
	@NotEmpty
	@Size(min=8,message="Password is less than 8")
	private String password;
	

	@ManyToOne
	@JoinColumn(name="hotel",nullable=false)
	private Hotel hotel;
	

}
