package com.learning.repostiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.entity.PaymentEntity;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long>{
	
}
