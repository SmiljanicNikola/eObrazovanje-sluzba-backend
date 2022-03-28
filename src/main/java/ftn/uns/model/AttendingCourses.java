package ftn.uns.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "attending_courses")
public class AttendingCourses {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attending_courses_id", unique = true, nullable = false)
	private Integer attending_courses_id;

    @ManyToOne
    @JoinColumn(name="student_id", nullable=false)
    private Student student;
    
    @ManyToOne
    @JoinColumn(name="subject_performance_id", nullable=false)
    private SubjectPerformance subjectPerformance;
    
    @OneToMany(mappedBy="attendingCourses")
    private List<TakingExam> taking_exams;

	public AttendingCourses(Integer attending_courses_id, Student student, Integer course_conduting_id, SubjectPerformance subjectPerformance) {
		super();
		this.attending_courses_id = attending_courses_id;
		this.student = student;
		this.subjectPerformance =subjectPerformance;
	}

	public AttendingCourses(Student student, Integer course_conduting_id , SubjectPerformance subjectPerformance) {
		super();
		this.student = student;
		this.subjectPerformance =subjectPerformance;
	}

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

	public List<TakingExam> getTaking_exams() {
		return taking_exams;
	}

	public void setTaking_exams(List<TakingExam> taking_exams) {
		this.taking_exams = taking_exams;
	}

	@Override
	public String toString() {
		return "AttendingCourses [attending_courses_id=" + attending_courses_id + ", student=" + student
				+ ", subjectPerformance=" + subjectPerformance + ", taking_exams=" + taking_exams + "]";
	}


	



    
	
    
    
    
    
}
