package ftn.uns.eObrazovanje.model.request;

import java.time.LocalDate;

public class AddPaymentRequest {

	private Integer payment_id;

	private String purposeOfPayment;

	private Double amount;

	private LocalDate dateOfPayment;
	
    private Integer accountId;
    
	private boolean deleted;

	
	public AddPaymentRequest(String purposeOfPayment, Double amount, LocalDate dateOfPayment, Integer accountId) {
		super();
		this.purposeOfPayment = purposeOfPayment;
		this.amount = amount;
		this.dateOfPayment = dateOfPayment;
		this.accountId = accountId;
	}

	public AddPaymentRequest(String purposeOfPayment, Double amount, LocalDate dateOfPayment, Integer accountId,
			boolean deleted) {
		super();
		this.purposeOfPayment = purposeOfPayment;
		this.amount = amount;
		this.dateOfPayment = dateOfPayment;
		this.accountId = accountId;
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

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
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
				+ ", amount=" + amount + ", date_of_payment=" + dateOfPayment + ", account_id=" + accountId
				+ ", deleted=" + deleted + "]";
	}
	
	
	
}
