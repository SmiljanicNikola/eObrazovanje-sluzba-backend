package ftn.uns.eObrazovanje.service;

import java.util.List;

import ftn.uns.eObrazovanje.model.Payment;

public interface PaymentService {
	
	List<Payment> findAll();
	
	Payment save(Payment payment);
	
	Payment findOne(Integer id);
	
	void remove(Integer id);

}
