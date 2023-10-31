package com.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entity.PaymentEntity;
import com.learning.enums.Status;
import com.learning.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@PostMapping 
	public Long create(@RequestBody PaymentEntity paymentEntity) {
		return paymentService.create(paymentEntity);
	}

	
	@GetMapping("/{id}")
	public PaymentEntity findById(@PathVariable Long id) {
		return paymentService.findById(id);
	}

	
	@PutMapping("/{id}")
	public Status updateById(@PathVariable Long id, @RequestBody PaymentEntity paymentEntity) {
		return paymentService.updateById(id, paymentEntity);
	}

	
	@DeleteMapping("/{id}")
	public Status deleteById(@PathVariable Long id) {
		return paymentService.deleteById(id);
	}
}
