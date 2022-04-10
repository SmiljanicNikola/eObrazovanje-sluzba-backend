package ftn.uns.eObrazovanje.model.request;

import java.time.LocalDate;

public class AddPaymentRequest {

	private Integer payment_id;

	private String purpose_of_payment;

	private String amount;

	private LocalDate date_of_payment;
	
    private Integer account_id;
    
	private boolean deleted;

	public Integer getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(Integer payment_id) {
		this.payment_id = payment_id;
	}

	public String getPurpose_of_payment() {
		return purpose_of_payment;
	}

	public void setPurpose_of_payment(String purpose_of_payment) {
		this.purpose_of_payment = purpose_of_payment;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public LocalDate getDate_of_payment() {
		return date_of_payment;
	}

	public void setDate_of_payment(LocalDate date_of_payment) {
		this.date_of_payment = date_of_payment;
	}

	public Integer getAccount_id() {
		return account_id;
	}

	public void setAccount_id(Integer account_id) {
		this.account_id = account_id;
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

	public AddPaymentRequest(Integer payment_id, String purpose_of_payment, String amount, LocalDate date_of_payment,
			Integer account_id, boolean deleted) {
		super();
		this.payment_id = payment_id;
		this.purpose_of_payment = purpose_of_payment;
		this.amount = amount;
		this.date_of_payment = date_of_payment;
		this.account_id = account_id;
		this.deleted = deleted;
	}

	public AddPaymentRequest(String purpose_of_payment, String amount, LocalDate date_of_payment, Integer account_id,
			boolean deleted) {
		super();
		this.purpose_of_payment = purpose_of_payment;
		this.amount = amount;
		this.date_of_payment = date_of_payment;
		this.account_id = account_id;
		this.deleted = deleted;
	}

	public AddPaymentRequest(Integer payment_id, String purpose_of_payment, String amount, LocalDate date_of_payment,
			Integer account_id) {
		super();
		this.payment_id = payment_id;
		this.purpose_of_payment = purpose_of_payment;
		this.amount = amount;
		this.date_of_payment = date_of_payment;
		this.account_id = account_id;
	}

	@Override
	public String toString() {
		return "AddPaymentRequest [payment_id=" + payment_id + ", purpose_of_payment=" + purpose_of_payment
				+ ", amount=" + amount + ", date_of_payment=" + date_of_payment + ", account_id=" + account_id
				+ ", deleted=" + deleted + "]";
	}
	
	
	
}
