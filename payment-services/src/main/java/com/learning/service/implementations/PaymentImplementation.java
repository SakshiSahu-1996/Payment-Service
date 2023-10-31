package com.learning.service.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entity.PaymentEntity;
import com.learning.enums.Status;
import com.learning.repostiory.PaymentRepository;
import com.learning.service.PaymentService;

@Service
public class PaymentImplementation implements PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public Long create(PaymentEntity paymentEntity) {
		PaymentEntity entity = paymentRepository.save(paymentEntity);
		return entity.getId();
	}

	@Override
	public PaymentEntity findById(Long id) {
		Optional<PaymentEntity> paymentEntity = paymentRepository.findById(id);
		boolean present = paymentEntity.isPresent();
		if (present) {
			PaymentEntity savedPaymentEntity = paymentEntity.get();
			return savedPaymentEntity;
		} else {
			return null;
		}
	}

	@Override
	public Status updateById(Long id, PaymentEntity paymentEntity) {
		try {
			PaymentEntity savedPayment = findById(id);
			if (savedPayment != null) {
				savedPayment.setName(paymentEntity.getName());
				savedPayment.setDate(paymentEntity.getDate());
				paymentRepository.save(savedPayment);
				return Status.SUCCESS;
			}
		} catch (Exception exception) {
			System.out.println(exception);
		}
		return Status.FAIL;
	}

	@Override
	public Status deleteById(Long id) {
		paymentRepository.deleteById(id);
		return Status.SUCCESS;
	}
}
