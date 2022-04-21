package ftn.uns.eObrazovanje.model;

import static javax.persistence.CascadeType.ALL;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="semesters")
public class Semester implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "semester_id", unique=true, nullable = false)
	private Integer id;
	
	@Column(name = "semester_number", unique = false, nullable = false)
	private Integer semesterNumber;
	
	@Column(name = "deleted", unique = false, nullable = false)
	private boolean deleted;
	
	@ManyToOne
	@JoinColumn(name = "department_id", referencedColumnName = "department_id")
	private Department department;
	
	@JsonIgnore
	@OneToMany(cascade= {ALL}, mappedBy= "semester", fetch = FetchType.EAGER)
    private List<Subject> subjects = new ArrayList<Subject>();

	

	public Semester(Integer id, Integer semesterNumber, boolean deleted, Department department,
			List<Subject> subjects) {
		super();
		this.id = id;
		this.semesterNumber = semesterNumber;
		this.deleted = deleted;
		this.department = department;
		this.subjects = subjects;
	}


	public boolean isDeleted() {
		return deleted;
	}


	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}


	public List<Subject> getSubjects() {
		return subjects;
	}


	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}


	public Semester() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSemesterNumber() {
		return semesterNumber;
	}

	public void setSemesterNumber(Integer semesterNumber) {
		this.semesterNumber = semesterNumber;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Semester [id=" + id + ", semesterNumber=" + semesterNumber + ", deleted=" + deleted + ", department="
				+ department + ", subjects=" + subjects + "]";
	}

	
	
}
