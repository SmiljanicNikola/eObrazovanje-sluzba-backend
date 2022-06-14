package ftn.uns.eObrazovanje.model.request;

import java.time.LocalDate;

import ftn.uns.eObrazovanje.model.Account;

public class AddPaymentRequest {

	private Integer payment_id;

	private String purposeOfPayment;

	private Double amount;

	private LocalDate dateOfPayment;
	
    private Account account;
    
	private boolean deleted;

	
	public AddPaymentRequest(String purposeOfPayment, Double amount, LocalDate dateOfPayment, Account account) {
		super();
		this.purposeOfPayment = purposeOfPayment;
		this.amount = amount;
		this.dateOfPayment = dateOfPayment;
		this.account = account;
	}

	public AddPaymentRequest(String purposeOfPayment, Double amount, LocalDate dateOfPayment, Account account,
			boolean deleted) {
		super();
		this.purposeOfPayment = purposeOfPayment;
		this.amount = amount;
		this.dateOfPayment = dateOfPayment;
		this.account = account;
		this.deleted = deleted;
	}

	public Integer getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(Integer payment_id) {
		this.payment_id = payment_id;
	}

	

	public String getPurposeOfPayment() {
		return purposeOfPayment;
	}

	public void setPurposeOfPayment(String purposeOfPayment) {
		this.purposeOfPayment = purposeOfPayment;
	}

	public LocalDate getDateOfPayment() {
		return dateOfPayment;
	}

	public void setDateOfPayment(LocalDate dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccountId(Account account) {
		this.account = account;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public AddPaymentRequest() {
		super();
	}

	

	@Override
	public String toString() {
		return "AddPaymentRequest [payment_id=" + payment_id + ", purpose_of_payment=" + purposeOfPayment
				+ ", amount=" + amount + ", date_of_payment=" + dateOfPayment + ", account=" + account
				+ ", deleted=" + deleted + "]";
	}
	
	
	
}
