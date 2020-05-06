package com.prog39599.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String Day;
	private String Time;
//	@OneToOne
//	@JoinTable(name="Bookings", joinColumns = @JoinColumn(name="Booking_ID"), inverseJoinColumns=@JoinColumn(name="MOVIE_ID"))
		private String movie;
//		private Movie movie;
//		
        
		
		
}
