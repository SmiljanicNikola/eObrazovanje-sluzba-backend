package ftn.uns.eObrazovanje.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "accounts")
public class Account implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id", unique = true, nullable = false)
	private Integer account_id;

	@Column(name = "account_ballance", unique = false)
	private Float account_ballance;
	
	@JsonIgnore
	@OneToOne(mappedBy = "account")
	private Student student;
	
	@Column(name = "blocked", unique = false, nullable = false)
	private boolean blocked;
	
    @OneToMany(mappedBy="account")
    private List<Payment> payments;

	public Account(Integer account_id, Float accountBallance, Boolean blocked) {
		super();
		this.account_id = account_id;
		this.account_ballance = accountBallance;
		this.blocked = blocked;
	}
	
	
	

	public Account(Float account_ballance, boolean blocked) {
		super();
		this.account_ballance = account_ballance;
		this.blocked = blocked;
	}




	public Account() {
		super();
	}


	public Integer getAccount_id() {
		return account_id;
	}

	public void setAccount_id(Integer account_id) {
		this.account_id = account_id;
	}

	public Float getAccountBallance() {
		return account_ballance;
	}

	public void setAccountBallance(Float accountBallance) {
		this.account_ballance = accountBallance;
	}
	

	public boolean isBlocked() {
		return blocked;
	}


	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}


	@Override
	public String toString() {
		return "Account [account_id=" + account_id + ", accountBallance=" + account_ballance + "]";
	}

}
