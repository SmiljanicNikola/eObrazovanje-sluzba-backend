package ftn.uns.model;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "taking_exam")
public class TakingExam implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "taking_exam_id", unique=true, nullable = false)
	private Integer taking_exam_id;
	
	@Column(name = "grade", unique = false, nullable = false)
	private Integer grade;
	
	@Column(name = "passed", unique = false, nullable = false)
	private boolean passed;
	
    @ManyToOne
    @JoinColumn(name="lecturer_id", nullable=false)
    private Lecturer lecturer;
	
    @OneToMany(mappedBy="takingExam")
    private List<ExamDate> examDates = new ArrayList<ExamDate>();
    
    @ManyToOne
    @JoinColumn(name="attending_courses_id", nullable=false)
    private AttendingCourses attendingCourses;

	public Integer getTaking_exam_id() {
		return taking_exam_id;
	}

	public void setTaking_exam_id(Integer taking_exam_id) {
		this.taking_exam_id = taking_exam_id;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public boolean isPassed() {
		return passed;
	}

	public void setPassed(boolean passed) {
		this.passed = passed;
	}

	public Lecturer getLecturer() {
		return lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

	public List<ExamDate> getExamDates() {
		return examDates;
	}

	public void setExamDates(List<ExamDate> examDates) {
		this.examDates = examDates;
	}

	public AttendingCourses getAttendingCourses() {
		return attendingCourses;
	}

	public void setAttendingCourses(AttendingCourses attendingCourses) {
		this.attendingCourses = attendingCourses;
	}

}
