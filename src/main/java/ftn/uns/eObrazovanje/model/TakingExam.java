package ftn.uns.eObrazovanje.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@Column(name = "deleted", unique = false, nullable = false)
	private boolean deleted;
	
    @ManyToOne
    @JoinColumn(name="lecturer_id", nullable=false)
    private Lecturer lecturer;

//    @JsonIgnore
//    @OneToMany(mappedBy="takingExam")
//    private List<ExamDate> examDates = new ArrayList<ExamDate>();
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="exam_date_id", nullable=false)
    private ExamDate examDate;
    

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="attending_courses_id", nullable=false)
    private AttendingCourses attendingCourses;

	public TakingExam(Integer taking_exam_id, Integer grade, boolean passed, boolean deleted, Lecturer lecturer,
			ExamDate examDate, AttendingCourses attendingCourses) {
		super();
		this.taking_exam_id = taking_exam_id;
		this.grade = grade;
		this.passed = passed;
		this.deleted = deleted;
		this.lecturer = lecturer;
		this.examDate = examDate;
		this.attendingCourses = attendingCourses;
	}
	
	




	public TakingExam(Integer grade, boolean passed, boolean deleted, Lecturer lecturer, ExamDate examDate,
			AttendingCourses attendingCourses) {
		super();
		this.grade = grade;
		this.passed = passed;
		this.deleted = deleted;
		this.lecturer = lecturer;
		this.examDate = examDate;
		this.attendingCourses = attendingCourses;
	}






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



	public ExamDate getExamDate() {
		return examDate;
	}

	public void setExamDate(ExamDate examDate) {
		this.examDate = examDate;
	}

	public AttendingCourses getAttendingCourses() {
		return attendingCourses;
	}

	public void setAttendingCourses(AttendingCourses attendingCourses) {
		this.attendingCourses = attendingCourses;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "TakingExam [taking_exam_id=" + taking_exam_id + ", grade=" + grade + ", passed=" + passed + ", deleted="
				+ deleted + ", lecturer=" + lecturer + ", examDates=" + examDate + ", attendingCourses="
				+ null + "]";
	}

	public TakingExam() {
		super();
	}
	
	

}
