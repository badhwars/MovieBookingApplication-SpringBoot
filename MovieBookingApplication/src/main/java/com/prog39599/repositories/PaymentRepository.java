package com.prog39599.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog39599.beans.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
	public Payment findFirstByOrderByPaymentIdDesc();
}
