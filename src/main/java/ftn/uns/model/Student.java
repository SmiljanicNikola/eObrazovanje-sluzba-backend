package ftn.uns.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id", unique = true, nullable = false)
	private Integer id;
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "username", unique = true, nullable = false)
    private String username;
    
    @Column(name = "firstname", unique = false, nullable = false)
	private String firstname;
    
    @Column(name = "lastname", unique = false, nullable = false)
	private String lastname;
    
    @Column(name = "password", unique = false, nullable = false)
	private String password;
    
    @Column(name = "jmbg", unique = true, nullable = false)
	private String jmbg;
    
    @Column(name = "adress", nullable = false)
	private String adress;
    
    @Column(name = "index_number", nullable = false)
	private String indexNumber;
    
	@Column(name = "account_id", unique = false, nullable = false)
	private Account account_id;
    
    @Column(name = "blocked")
	private boolean blocked;

	public Student(Integer id, String username, String firstname, String lastname, String password, String jmbg,
			String adress, String indexNumber, Account account_id, boolean blocked) {
		super();
		this.id = id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.jmbg = jmbg;
		this.adress = adress;
		this.indexNumber = indexNumber;
		this.account_id = account_id;
		this.blocked = blocked;
	}

	public Student(String username, String firstname, String lastname, String password, String jmbg, String adress,
			String indexNumber, Account account_id, boolean blocked) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.jmbg = jmbg;
		this.adress = adress;
		this.indexNumber = indexNumber;
		this.account_id = account_id;
		this.blocked = blocked;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getIndexNumber() {
		return indexNumber;
	}

	public void setIndexNumber(String indexNumber) {
		this.indexNumber = indexNumber;
	}

	public Account getAccount_id() {
		return account_id;
	}

	public void setAccount_id(Account account_id) {
		this.account_id = account_id;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", password=" + password + ", jmbg=" + jmbg + ", adress=" + adress + ", indexNumber=" + indexNumber
				+ ", account_id=" + account_id + ", blocked=" + blocked + "]";
	}

}
