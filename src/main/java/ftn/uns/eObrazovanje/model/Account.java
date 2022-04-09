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
	private String account_ballance;
	
	@JsonIgnore
	@OneToOne(mappedBy = "account")
	private Student student;
	
    @OneToMany(mappedBy="account")
    private List<Payment> payments;

	public Account(Integer account_id, String accountBallance) {
		super();
		this.account_id = account_id;
		this.account_ballance = accountBallance;
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

	public String getAccountBallance() {
		return account_ballance;
	}

	public void setAccountBallance(String accountBallance) {
		this.account_ballance = accountBallance;
	}

	@Override
	public String toString() {
		return "Account [account_id=" + account_id + ", accountBallance=" + account_ballance + "]";
	}

}
