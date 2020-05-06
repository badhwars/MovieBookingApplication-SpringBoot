package com.prog39599.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Payment {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long paymentId;
	double payMentValue;
	int generalTickets;
	int seniorTickets;
	int childTickets;
	
	public double total(boolean tuesday) {
	if(tuesday) {
		return (5*(this.generalTickets + this.seniorTickets +this.childTickets));}
		else {
			return (15*(this.generalTickets) + 5*(this.seniorTickets + this.childTickets));
		}
//	}
		
	}


}
