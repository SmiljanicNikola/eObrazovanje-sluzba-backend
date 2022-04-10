package ftn.uns.eObrazovanje.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.uns.eObrazovanje.model.Payment;
import ftn.uns.eObrazovanje.repository.PaymentRepo;
import ftn.uns.eObrazovanje.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	private PaymentRepo paymentRepo;

	@Override
	public List<Payment> findAll() {
		return paymentRepo.findAll();
	}

	@Override
	public Payment save(Payment payment) {
		paymentRepo.save(payment);
		return payment;
	}

	@Override
	public Payment findOne(Integer id) {
		return paymentRepo.findById(id).orElse(null);
	}

	@Override
	public void remove(Integer id) {
		paymentRepo.deleteById(id);
	}

}
