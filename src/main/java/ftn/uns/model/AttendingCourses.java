package ftn.uns.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "attending_courses")
public class AttendingCourses {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attending_courses_id", unique = true, nullable = false)
	private Integer id;
    
    @Column(name = "student_id", nullable = false)
    private Integer studentId;

    @Column(name = "course_conduting_id", nullable = false)
    private Integer courseCondutingId;
    
    @Column(name = "grade", nullable = false)
    private Integer grade;

    @Column(name = "passed")
    private Boolean passed;

	public AttendingCourses(Integer id, Integer studentId, Integer courseCondutingId, Integer grade, Boolean passed) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.courseCondutingId = courseCondutingId;
		this.grade = grade;
		this.passed = passed;
	}

	public AttendingCourses(Integer studentId, Integer courseCondutingId, Integer grade, Boolean passed) {
		super();
		this.studentId = studentId;
		this.courseCondutingId = courseCondutingId;
		this.grade = grade;
		this.passed = passed;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getCourseCondutingId() {
		return courseCondutingId;
	}

	public void setCourseCondutingId(Integer courseCondutingId) {
		this.courseCondutingId = courseCondutingId;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Boolean getPassed() {
		return passed;
	}

	public void setPassed(Boolean passed) {
		this.passed = passed;
	}
    
	
    
    
    
    
}
