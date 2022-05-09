package ftn.uns.eObrazovanje.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "attending_courses")
public class AttendingCourses implements Serializable{
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attending_courses_id", unique = true, nullable = false)
	private Integer attending_courses_id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="student_id", referencedColumnName = "student_id")
    private Student student;
    
 
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="subject_performance_id", nullable=false)
    private SubjectPerformance subjectPerformance;
    
    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy="attendingCourses")
    private List<TakingExam> takingExams = new ArrayList<TakingExam>();

	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public SubjectPerformance getSubjectPerformance() {
		return subjectPerformance;
	}

	public void setSubjectPerformance(SubjectPerformance subjectPerformance) {
		this.subjectPerformance = subjectPerformance;
	}
	
	

	public Integer getAttending_courses_id() {
		return attending_courses_id;
	}

	public void setAttending_courses_id(Integer attending_courses_id) {
		this.attending_courses_id = attending_courses_id;
	}

	

	public List<TakingExam> getTakingExams() {
		return takingExams;
	}

	public void setTakingExams(List<TakingExam> takingExams) {
		this.takingExams = takingExams;
	}

	@Override
	public String toString() {
		return "AttendingCourses [attending_courses_id=" + attending_courses_id + ", student=" + student
				+  ", taking_exams=" + takingExams + "]";
	}

	public AttendingCourses(Integer attending_courses_id, Student student, SubjectPerformance subjectPerformance,
			List<TakingExam> takingExams) {
		super();
		this.attending_courses_id = attending_courses_id;
		this.student = student;
		this.subjectPerformance = subjectPerformance;
		this.takingExams = takingExams;
	}

	public AttendingCourses(Student student, SubjectPerformance subjectPerformance, List<TakingExam> takingExams) {
		super();
		this.student = student;
		this.subjectPerformance = subjectPerformance;
		this.takingExams = takingExams;
	}

	public AttendingCourses(Student student, SubjectPerformance subjectPerformance) {
		super();
		this.student = student;
		this.subjectPerformance = subjectPerformance;
	}

	public AttendingCourses() {
		super();
	}
	
	

	
	



    
	
    
    
    
    
}
