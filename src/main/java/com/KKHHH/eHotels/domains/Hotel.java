package com.KKHHH.eHotels.domains;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Entity
@Slf4j
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
	
	private short star;
	private String moto;
	private String description;
	
	@OneToMany(targetEntity=Room.class)
	private List<Room> rooms= new ArrayList<>();
	
	public void addRoom(Room room) {
		this.rooms.add(room);
	}
	
	@OneToMany(targetEntity=User.class)
	private List<User> receptions=new ArrayList<>();
	
	public void addReception(User reception) {
		this.receptions.add(reception);
	}
}
