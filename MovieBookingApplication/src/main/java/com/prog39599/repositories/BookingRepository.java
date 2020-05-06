package com.prog39599.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog39599.beans.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{

	public Booking findFirstByOrderByIdDesc();
	

}
