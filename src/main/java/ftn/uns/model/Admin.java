package ftn.uns.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_Id", unique = true, nullable = false)
	private Integer admin_Id;

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

	@Column(name = "blocked", unique = false, nullable = false)
	private boolean blocked;

	public Admin(Integer admin_Id, String name, String surname, String username, String password, String address, String jmbg,
			boolean blocked) {
		super();
		this.admin_Id = admin_Id;
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.password = password;
		this.address = address;
		this.jmbg = jmbg;
		this.blocked = blocked;
	}

	public Integer getId() {
		return admin_Id;
	}

	public void setId(Integer id) {
		this.admin_Id = id;
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

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

}
