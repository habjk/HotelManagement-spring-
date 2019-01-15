package com.KKHHH.eHotels.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity

@Table(name="bookedroom")
public class ReserveRoom {
		public ReserveRoom() {}
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long hotelId;
		
		
		@NotNull
		@NotEmpty
		private String arrivaldate;
		
		@NotNull
		@NotEmpty
		private String departuredate;
		

		@NotNull
		@NotEmpty
		private String room;


		@NotNull
		@NotEmpty
		private String guests;
		
		
		@NotNull
		@NotEmpty
		private String bedtype;
		
		


		@NotNull
		@NotEmpty
		@Email(message="email should be valid")
		private String email;


		
		private String note;
}
