package com.prog39599.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.prog39599.beans.User.UserBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	@Entity

	public class Account {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
//		private int accountId;
		private String name;
		private String phone;
		private String email;
		
	}