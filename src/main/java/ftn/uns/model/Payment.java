package ftn.uns.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id", unique = true, nullable = false)
	private Integer payment_id;

	@Column(name = "purpose_of_payment", unique = false, nullable = false)
	private String purpose_of_payment;

	@Column(name = "amount", unique = false, nullable = false)
	private String amount;

	@Column(name = "datum", unique = false, nullable = false)
	private LocalDate datum;
	
	@Column(name = "account_id", unique = false, nullable = false)
	private Account account_id;

	public Payment(Integer payment_id, String purpose_of_payment, String amount, LocalDate datum, Account account_id) {
		super();
		this.payment_id = payment_id;
		this.purpose_of_payment = purpose_of_payment;
		this.amount = amount;
		this.datum = datum;
		this.account_id = account_id;
	}

	public Integer getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(Integer payment_id) {
		this.payment_id = payment_id;
	}

	public String getPurposeOfPayment() {
		return purpose_of_payment;
	}

	public void setPurposeOfPayment(String purposeOfPayment) {
		this.purpose_of_payment = purposeOfPayment;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public LocalDate getDatum() {
		return datum;
	}

	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}

	public Account getAccount_id() {
		return account_id;
	}

	public void setAccount_id(Account account_id) {
		this.account_id = account_id;
	}

	@Override
	public String toString() {
		return "Payment [payment_id=" + payment_id + ", purposeOfPayment=" + purpose_of_payment + ", amount=" + amount
				+ ", datum=" + datum + ", account_id=" + account_id + "]";
	}
	
	

}
