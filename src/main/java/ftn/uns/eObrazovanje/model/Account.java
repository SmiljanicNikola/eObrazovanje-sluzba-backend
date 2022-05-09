package ftn.uns.eObrazovanje.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "accounts")
public class Account implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id", unique = true, nullable = false)
	private Integer account_id;

	@Column(name = "account_ballance", unique = false)
	private Float accountBallance;
	
	@JsonIgnore
	@OneToOne(mappedBy = "account")
	@JoinColumn(name = "student_id", referencedColumnName = "student_id")
	private Student student;
	
	@Column(name = "blocked", unique = false, nullable = false)
	private boolean blocked;

	@JsonIgnore
    @OneToMany(mappedBy="account")
    private List<Payment> payments;

	public Account(Float accountBallance, Student student, boolean blocked) {
		this.accountBallance = accountBallance;
		this.student = student;
		this.blocked = blocked;
	}

	public Account(Integer account_id, Float accountBallance, Student student, boolean blocked) {
		this.account_id = account_id;
		this.accountBallance = accountBallance;
		this.student = student;
		this.blocked = blocked;
	}

	public Account() {
		super();
	}

	public Account(Float accountBallance, boolean blocked) {
		this.accountBallance = accountBallance;
		this.blocked = blocked;
	}

	public Float getAccountBallance() {
		return accountBallance;
	}

	public Student getStudent() {
		return student;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public Integer getAccount_id() {
		return account_id;
	}

	public void setAccount_id(Integer account_id) {
		this.account_id = account_id;
	}

	public void setAccountBallance(Float accountBallance) {
		this.accountBallance = accountBallance;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public boolean isBlocked() {
		return blocked;
	}


	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}



	@Override
	public String toString() {
		return "Account [account_id=" + account_id + ", accountBallance=" + accountBallance + "]";
	}

}
