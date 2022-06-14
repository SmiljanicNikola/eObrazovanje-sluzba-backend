package ftn.uns.eObrazovanje.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.uns.eObrazovanje.model.Payment;
import ftn.uns.eObrazovanje.model.request.AddPaymentRequest;
import ftn.uns.eObrazovanje.service.AccountService;
import ftn.uns.eObrazovanje.service.PaymentService;

@RestController
@RequestMapping(value = "api/payments")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private AccountService accountService;//Trebace mi za POST() metodu, nije implementirano
	
	@GetMapping 
	public ResponseEntity<List<Payment>> getPayments(){
		List<Payment> payments = paymentService.findAll();
		
		return new ResponseEntity<>(payments, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Payment> getPayment(@PathVariable("id") Integer id){
		Payment payment = paymentService.findOne(id);
		if(payment == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(payment, HttpStatus.OK);
	}

	@GetMapping(value = "account/{id}")
	public ResponseEntity<List<Payment>> getPaymentsByAccountId(@PathVariable("id") Integer id){
		List<Payment> payments = paymentService.findAll();
		List<Payment> paymentsOfSpecificStudent = new ArrayList<Payment>();
		for (Payment payment : payments){
			if(payment.getAccount().getAccount_id() == id){
				paymentsOfSpecificStudent.add(payment);
			}
		}
		/*if(payments == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}*/
		return new ResponseEntity<>(paymentsOfSpecificStudent, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deletePayment(@PathVariable("id") Integer id){
		Payment payment = paymentService.findOne(id);
		
		if(!payment.isDeleted()) {
			payment.setDeleted(true);
			paymentService.save(payment);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Payment> savePayment(@RequestBody Payment addPaymentRequest){
		Payment payment = new Payment();
		System.out.println(addPaymentRequest);
		payment.setPurposeOfPayment(addPaymentRequest.getPurposeOfPayment());
		payment.setAmount(addPaymentRequest.getAmount());
		payment.setDateOfPayment(addPaymentRequest.getDateOfPayment());
		payment.setAccount(this.accountService.findOne(addPaymentRequest.getAccount().getAccount_id()));
		payment.setDeleted(false);
		
		payment = paymentService.save(payment);
		return new ResponseEntity<>(payment, HttpStatus.CREATED);
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Payment> updatePayment(@RequestBody Payment paymentRequest, @PathVariable("id") Integer id){
		
		Payment payment = paymentService.findOne(id);
		if(payment == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		payment.setPurposeOfPayment(paymentRequest.getPurposeOfPayment());
		payment.setAmount(paymentRequest.getAmount());
		payment.setDateOfPayment(paymentRequest.getDateOfPayment());
		
		payment = paymentService.save(payment);
		return new ResponseEntity<>(payment, HttpStatus.OK);
		
	}
	
	
}
