package ftn.uns.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "students_history")
public class StudentHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "history_id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "enrollment_year", unique = false, nullable = false)
	private LocalDate enrollment_year;
	
	@Column(name = "year", unique = false, nullable = false)
	private Integer year;
	
	// !!!!!!!
	
	@Column(name = "department_id", unique = false, nullable = false)
	private Department department_id;

	
//	!!!!!!!
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
	private Student student;
	
	
	public StudentHistory(LocalDate enrollment_year, Integer year, Department department_id) {
		super();
		this.enrollment_year = enrollment_year;
		this.year = year;
		this.department_id = department_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getEnrollment_year() {
		return enrollment_year;
	}

	public void setEnrollment_year(LocalDate enrollment_year) {
		this.enrollment_year = enrollment_year;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Department getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(Department department_id) {
		this.department_id = department_id;
	}

	@Override
	public String toString() {
		return "StudentHistory [id=" + id + ", enrollment_year=" + enrollment_year + ", year=" + year
				+ ", department_id=" + department_id + "]";
	}
	
	

}
