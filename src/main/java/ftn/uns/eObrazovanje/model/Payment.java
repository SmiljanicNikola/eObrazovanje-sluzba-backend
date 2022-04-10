package ftn.uns.eObrazovanje.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id", unique = true, nullable = false)
	private Integer payment_id;

	@Column(name = "purpose_of_payment", unique = false, nullable = false)
	private String purpose_of_payment;

	@Column(name = "amount", unique = false, nullable = false)
	private String amount;

	@Column(name = "date_of_payment", unique = false, nullable = false)
	private LocalDate date_of_payment;
	
    @ManyToOne
    @JoinColumn(name="account_id", nullable=false)
    private Account account;
    
    @Column(name = "deleted", unique = false, nullable = false)
	private boolean deleted;

	public Payment(Integer payment_id, String purpose_of_payment, String amount, LocalDate date_of_payment, Account account) {
		super();
		this.payment_id = payment_id;
		this.purpose_of_payment = purpose_of_payment;
		this.amount = amount;
		this.date_of_payment = date_of_payment;
		this.account = account;
	}
	
	

	public Payment(String purpose_of_payment, String amount, LocalDate date_of_payment, Account account,
			boolean deleted) {
		super();
		this.purpose_of_payment = purpose_of_payment;
		this.amount = amount;
		this.date_of_payment = date_of_payment;
		this.account = account;
		this.deleted = deleted;
	}



	public boolean isDeleted() {
		return deleted;
	}



	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}



	public Payment() {
		super();
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

	

	public Payment(String purpose_of_payment, String amount, LocalDate date_of_payment,
			Account account) {
		super();
		this.purpose_of_payment = purpose_of_payment;
		this.amount = amount;
		this.date_of_payment = date_of_payment;
		this.account = account;
	}



	public String getPurpose_of_payment() {
		return purpose_of_payment;
	}



	public void setPurpose_of_payment(String purpose_of_payment) {
		this.purpose_of_payment = purpose_of_payment;
	}



	public LocalDate getDate_of_payment() {
		return date_of_payment;
	}



	public void setDate_of_payment(LocalDate date_of_payment) {
		this.date_of_payment = date_of_payment;
	}



	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Payment [payment_id=" + payment_id + ", purposeOfPayment=" + purpose_of_payment + ", amount=" + amount
				+ ", datum=" + date_of_payment + ", account_id=" + account + "]";
	}
	
	

}
