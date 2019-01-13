package com.KKHHH.eHotels.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity

@Table(name="Room")
public class Room {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long roomId;

	@NotNull
	@Size(min=1,message="Floor Cannot Be Empty")
	private int floor;

	@NotNull
	@Size(min=1,message="RoomNumber Cannot Be Empty")
	private int roomNumber;
	

	@NotNull
	@Size(min=1,message="Price Cannot Be Empty")
	private int price;
	

	@NotNull
	@Size(min=1,message="Type Cannot Be Empty")
	private String type;
	
	private String description;
	
}
