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
    private Student studentId;

    @Column(name = "course_conduting_id", nullable = false)
    private Integer course_conduting_id;
    ;
    
    @Column(name = "subject_performances_id", nullable = false)
    private SubjectPerformance subject_performances_id;

	public AttendingCourses(Integer id, Student studentId, Integer course_conduting_id, SubjectPerformance subject_performances_id) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.course_conduting_id = course_conduting_id;
		this.subject_performances_id =subject_performances_id;
	}

	public AttendingCourses(Student studentId, Integer course_conduting_id , SubjectPerformance subject_performances_id) {
		super();
		this.studentId = studentId;
		this.course_conduting_id = course_conduting_id;
		this.subject_performances_id =subject_performances_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Student getStudentId() {
		return studentId;
	}

	public void setStudentId(Student studentId) {
		this.studentId = studentId;
	}

	public Integer getCourseCondutingId() {
		return course_conduting_id;
	}

	public void setCourseCondutingId(Integer courseCondutingId) {
		this.course_conduting_id = course_conduting_id;
	}


	@Override
	public String toString() {
		return "AttendingCourses [id=" + id + ", studentId=" + studentId + ", courseCondutingId=" + course_conduting_id
				+ ", course_conduting_id=" + course_conduting_id + ", passed=" + course_conduting_id + "]";
	}
    
	
    
    
    
    
}
