package ftn.uns.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="semesters")
public class Semester {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "semester_id", unique=true, nullable = false)
	private Integer id;
	
	@Column(name = "semester_number", unique = false, nullable = false)
	private Integer semesterNumber;
	
	@JoinColumn(name = "department_id", referencedColumnName = "department_id")
	private Department department;

	public Semester(Integer id, Integer semesterNumber, Department department) {
		super();
		this.id = id;
		this.semesterNumber = semesterNumber;
		this.department = department;
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
		return "Semester [id=" + id + ", semesterNumber=" + semesterNumber + ", department=" + department + "]";
	}
	
	
	
}
