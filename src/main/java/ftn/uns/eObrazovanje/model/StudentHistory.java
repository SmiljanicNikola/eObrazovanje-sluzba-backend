package ftn.uns.eObrazovanje.model;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "students_history")
public class StudentHistory implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "history_id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "enrollment_year", unique = false, nullable = false)
	private LocalDate enrollment_year;
	
	@Column(name = "year", unique = false, nullable = false)
	private Integer year;
	
	/*// !!!!!!!
	@Column(name = "department_id", unique = false, nullable = false)
	private Department department_id;
	//	!!!!!!!*/
	
	@JsonIgnore
    @OneToOne(mappedBy="studentHistory")
	private Student student;

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

	


	@Override
	public String toString() {
		return "StudentHistory [id=" + id + ", enrollment_year=" + enrollment_year + ", year=" + year + ", student="
				+ student + "]";
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public StudentHistory(Integer id, LocalDate enrollment_year, Integer year, Student student) {
		super();
		this.id = id;
		this.enrollment_year = enrollment_year;
		this.year = year;
		this.student = student;
	}

	public StudentHistory(LocalDate enrollment_year, Integer year, Student student) {
		super();
		this.enrollment_year = enrollment_year;
		this.year = year;
		this.student = student;
	}

	public StudentHistory() {
		super();
	}

	
	
	

}
