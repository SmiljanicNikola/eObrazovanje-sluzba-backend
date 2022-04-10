package ftn.uns.eObrazovanje.controllers;

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
	public ResponseEntity<Payment> savePayment(@RequestBody AddPaymentRequest addPaymentRequest){
		Payment payment = new Payment();
		payment.setPurpose_of_payment(addPaymentRequest.getPurpose_of_payment());
		payment.setAmount(addPaymentRequest.getAmount());
		payment.setDate_of_payment(addPaymentRequest.getDate_of_payment());
		//payment.setAccount(this.accountService.findOne(addPaymentRequest.getAccount_id()));
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
		payment.setPurpose_of_payment(paymentRequest.getPurpose_of_payment());
		payment.setAmount(paymentRequest.getAmount());
		payment.setDate_of_payment(paymentRequest.getDate_of_payment());
		
		payment = paymentService.save(payment);
		return new ResponseEntity<>(payment, HttpStatus.OK);
		
	}
	
	
}
