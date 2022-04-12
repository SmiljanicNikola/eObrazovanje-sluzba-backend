package ftn.uns.eObrazovanje.model;

import static javax.persistence.CascadeType.ALL;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "lecturers")
public class Lecturer implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lecturer_id", unique = true, nullable = false)
	private Integer lecturer_id;

	@Column(name = "name", unique = false, nullable = false)
	private String name;

	@Column(name = "surname", unique = false, nullable = false)
	private String surname;

	@Column(name = "username", unique = true, nullable = false)
	private String username;

	@Column(name = "password", unique = false, nullable = false)
	private String password;

	@Column(name = "address", unique = false, nullable = false)
	private String address;

	@Column(name = "jmbg", unique = true, nullable = false)
	private String jmbg;

	@Column(name = "pay", unique = false, nullable = false)
	private Integer pay;
	
    @OneToMany(mappedBy="lecturer")
    private List<TakingExam> taking_exams;//
    
    @OneToMany(cascade= {ALL}, mappedBy= "lecturer")
    private List<LecturerOnTheSubject> lecturersOnTheSubject = new ArrayList<LecturerOnTheSubject>();

	@Column(name = "blocked", unique = false, nullable = false)
	private boolean blocked;


	public Lecturer() {
		super();
	}

	public Lecturer(Integer lecturer_id, String name, String surname, String username, String password, String address,
			String jmbg, Integer pay, boolean blocked) {
		super();
		this.lecturer_id = lecturer_id;
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.password = password;
		this.address = address;
		this.jmbg = jmbg;
		this.pay = pay;
		this.blocked = blocked;
	}

	
	public Lecturer(String name, String surname, String username, String password, String address, String jmbg,
			Integer pay,boolean blocked) {
		super();
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.password = password;
		this.address = address;
		this.jmbg = jmbg;
		this.pay = pay;
		this.taking_exams = taking_exams;
		this.lecturersOnTheSubject = lecturersOnTheSubject;
		this.blocked = blocked;
	}

	public Integer getLecturer_Id() {
		return lecturer_id;
	}

	public void setLecturer_Id(Integer lecturer_Id) {
		this.lecturer_id = lecturer_Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public Integer getPay() {
		return pay;
	}

	public void setPay(Integer pay) {
		this.pay = pay;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	@Override
	public String toString() {
		return "Lecturer [lecturer_Id=" + lecturer_id + ", name=" + name + ", surname=" + surname + ", username="
				+ username + ", password=" + password + ", address=" + address + ", jmbg=" + jmbg + ", pay=" + pay
				+ ", blocked=" + blocked + "]";
	}
	
}
