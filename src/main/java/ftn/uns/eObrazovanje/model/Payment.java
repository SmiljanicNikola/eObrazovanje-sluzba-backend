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
	private String purposeOfPayment;

	@Column(name = "amount", unique = false, nullable = false)
	private Double amount;

	@Column(name = "date_of_payment", unique = false, nullable = false)
	private LocalDate dateOfPayment;
	
    @ManyToOne
    @JoinColumn(name="account_id", nullable=false)
    private Account account;
    
    @Column(name = "deleted", unique = false, nullable = false)
	private boolean deleted;

    
    
	public Payment(Integer payment_id, String purposeOfPayment, Double amount, LocalDate dateOfPayment, Account account,
			boolean deleted) {
		super();
		this.payment_id = payment_id;
		this.purposeOfPayment = purposeOfPayment;
		this.amount = amount;
		this.dateOfPayment = dateOfPayment;
		this.account = account;
		this.deleted = deleted;
	}

	public Payment(String purposeOfPayment, Double amount, LocalDate dateOfPayment, Account account, boolean deleted) {
		super();
		this.purposeOfPayment = purposeOfPayment;
		this.amount = amount;
		this.dateOfPayment = dateOfPayment;
		this.account = account;
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
		return purposeOfPayment;
	}

	public void setPurposeOfPayment(String purposeOfPayment) {
		this.purposeOfPayment = purposeOfPayment;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getDateOfPayment() {
		return dateOfPayment;
	}

	public void setDateOfPayment(LocalDate dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	
	
	

}
