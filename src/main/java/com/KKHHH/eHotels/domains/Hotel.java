package com.KKHHH.eHotels.model;

<<<<<<< HEAD
import java.beans.Transient;
import java.util.Set;
=======
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
>>>>>>> f3a00b910a8265240b584f6f18643a7916ed8868

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
<<<<<<< HEAD

import lombok.Data;
=======
import java.util.Set;
>>>>>>> f3a00b910a8265240b584f6f18643a7916ed8868

@Data
@Entity
@Table(name="Hotel")
public class Hotel {
	public Hotel() {}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long hotelId;
	
	
	@NotNull
	@NotEmpty
	@Size(min=4,message="Hotel Name Cannot Be Empty")
	private String hotelName;
	
	@NotNull
	@NotEmpty
	@Size(min=4,message="City Cannot Be Empty")
	private String city;
	

	@NotNull
	@NotEmpty
	@Size(min=4,message="City Cannot Be Empty")
	private String subCity;
	

	
	private String phone;
	private short star;
	private String moto;
	private String description;
	
	
	@OneToMany(mappedBy="hotel")
	private Set<Manager> users;
	
	@OneToMany(mappedBy="hotelId")
	private Set<ImageModel> imageModel;
	
}
