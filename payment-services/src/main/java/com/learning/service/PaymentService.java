package com.learning.service;

import com.learning.entity.PaymentEntity;
import com.learning.enums.Status;

public interface PaymentService {

	Long create(PaymentEntity paymentEntity);
	PaymentEntity findById(Long id);
	Status updateById(Long id, PaymentEntity paymentEntity);
	Status deleteById(Long id);
}
