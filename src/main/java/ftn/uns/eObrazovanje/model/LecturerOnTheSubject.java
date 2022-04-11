package ftn.uns.eObrazovanje.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lecturers_on_the_subject")
public class LecturerOnTheSubject implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lecturer_on_the_subject_id", unique = true, nullable = false)
	private Integer lecturerOnTheSubject_Id;

	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lecturer_id", referencedColumnName = "lecturer_id")
	private Lecturer lecturer;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_performance_id", referencedColumnName = "subject_performance_id")
	private SubjectPerformance subjectPerformance;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
	private Rolee role;

	public Integer getLecturerOnTheSubject_Id() {
		return lecturerOnTheSubject_Id;
	}

	public void setLecturerOnTheSubject_Id(Integer lecturerOnTheSubject_Id) {
		this.lecturerOnTheSubject_Id = lecturerOnTheSubject_Id;
	}

	public Lecturer getLecturer() {
		return lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

	public SubjectPerformance getSubjectPerformance() {
		return subjectPerformance;
	}

	public void setSubjectPerformance(SubjectPerformance subjectPerformance) {
		this.subjectPerformance = subjectPerformance;
	}

	public Rolee getRole() {
		return role;
	}

	public void setRole(Rolee role) {
		this.role = role;
	}

	public LecturerOnTheSubject() {
		super();
	}

	public LecturerOnTheSubject(Integer lecturerOnTheSubject_Id, Lecturer lecturer,
			SubjectPerformance subjectPerformance, Rolee role) {
		super();
		this.lecturerOnTheSubject_Id = lecturerOnTheSubject_Id;
		this.lecturer = lecturer;
		this.subjectPerformance = subjectPerformance;
		this.role = role;
	}

	public LecturerOnTheSubject(Lecturer lecturer, SubjectPerformance subjectPerformance, Rolee role) {
		super();
		this.lecturer = lecturer;
		this.subjectPerformance = subjectPerformance;
		this.role = role;
	}
	
	

}
