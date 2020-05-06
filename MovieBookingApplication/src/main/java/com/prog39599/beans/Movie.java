package com.prog39599.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
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

public class Movie {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String rating;
	//private String[] showtimes;
	
//	@OneToOne
//
//	@JoinTable(name="STUDENT_ACCOUNT", joinColumns = @JoinColumn(name="STUDENT_ID"), inverseJoinColumns=@JoinColumn(name="ACCOUNT_ID"))	
//	private Account account;
//	
//
//	@OneToMany
//	private List<Vehicle> vehicleList;
}
