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
@Table(name = "roles")
public class Role implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id", unique = true, nullable = false)
	private Integer role_id;

	@Column(name = "name", unique = false, nullable = false)
	private String name;
	
	@OneToMany(cascade= {ALL}, mappedBy= "role")
    private List<LecturerOnTheSubject> lecturersOnTheSubject = new ArrayList<LecturerOnTheSubject>();

	public Role(Integer role_id, String name) {
		super();
		this.role_id = role_id;
		this.name = name;
	}

	public Role() {
		super();
	}

	public Role(String name) {
		super();
		this.name = name;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", name=" + name + "]";
	}

	public List<LecturerOnTheSubject> getLecturersOnTheSubject() {
		return lecturersOnTheSubject;
	}

	public void setLecturersOnTheSubject(List<LecturerOnTheSubject> lecturersOnTheSubject) {
		this.lecturersOnTheSubject = lecturersOnTheSubject;
	}
	
	

}
