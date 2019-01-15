package com.KKHHH.eHotels.domains;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name="Manager")
public class Manager {
	
	@Id
	@NotNull
	@NotEmpty
	@Email(message="Incorrect Email")
	private String email;
	
	@NotNull
	@NotEmpty
	@Size(min=8,message="Password is less than 8")
	private String password;
	

	@ManyToOne(optional = false)
	@JoinColumn(name="hotel",nullable=true)
	private Hotel hotel;
	
}
