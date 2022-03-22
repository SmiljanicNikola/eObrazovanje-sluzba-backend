package ftn.uns.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id", unique = true, nullable = false)
	private Integer account_id;

	@Column(name = "accountBallance", unique = false, nullable = false)
	private String accountBallance;

	public Account(Integer account_id, String accountBallance) {
		super();
		this.account_id = account_id;
		this.accountBallance = accountBallance;
	}

	public Integer getAccount_id() {
		return account_id;
	}

	public void setAccount_id(Integer account_id) {
		this.account_id = account_id;
	}

	public String getAccountBallance() {
		return accountBallance;
	}

	public void setAccountBallance(String accountBallance) {
		this.accountBallance = accountBallance;
	}

	
	
}
