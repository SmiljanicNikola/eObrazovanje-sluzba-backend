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
@Table(name = "subject_performances")
public class SubjectPerformance implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subject_performance_id", unique = true, nullable = false)
	private Integer subject_performance_id;

	@Column(name = "school_year", unique = false, nullable = false)
	private String school_year;
	
    @OneToMany(mappedBy="subjectPerformance")
    private List<AttendingCourses> attendingCourses = new ArrayList<AttendingCourses>();
    
    @ManyToOne
	@JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
	private Subject subject;
    
    @OneToMany(mappedBy="subjectPerformance")
    private List<PreExaminationObligations> examinationObligations = new ArrayList<PreExaminationObligations>();
    
    @OneToMany(mappedBy="subjectPerformance")
    private List<LecturerOnTheSubject> lecturersOnTheSubject = new ArrayList<LecturerOnTheSubject>();

	public SubjectPerformance(Integer subject_performance_id, Subject subject, String school_year) {
		super();
		this.subject_performance_id = subject_performance_id;
		this.subject = subject;
		this.school_year = school_year;
	}


	public Integer getSubject_performance_id() {
		return subject_performance_id;
	}

	public void setSubject_performance_id(Integer subject_performance_id) {
		this.subject_performance_id = subject_performance_id;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public List<AttendingCourses> getAttendingCourses() {
		return attendingCourses;
	}

	public void setAttendingCourses(List<AttendingCourses> attendingCourses) {
		this.attendingCourses = attendingCourses;
	}

	public String getSchool_year() {
		return school_year;
	}

	public void setSchool_year(String school_year) {
		this.school_year = school_year;
	}

	public SubjectPerformance() {
		super();
	}


	public List<PreExaminationObligations> getExaminationObligations() {
		return examinationObligations;
	}

	public void setExaminationObligations(List<PreExaminationObligations> examinationObligations) {
		this.examinationObligations = examinationObligations;
	}

	public SubjectPerformance(String school_year, List<AttendingCourses> attendingCourses, Subject subject,
			List<PreExaminationObligations> examinationObligations) {
		super();
		this.school_year = school_year;
		this.attendingCourses = attendingCourses;
		this.subject = subject;
		this.examinationObligations = examinationObligations;
	}

	public SubjectPerformance(Integer subject_performance_id, String school_year,
			List<AttendingCourses> attendingCourses, Subject subject,
			List<PreExaminationObligations> examinationObligations) {
		super();
		this.subject_performance_id = subject_performance_id;
		this.school_year = school_year;
		this.attendingCourses = attendingCourses;
		this.subject = subject;
		this.examinationObligations = examinationObligations;
	}

	public List<LecturerOnTheSubject> getLecturersOnTheSubject() {
		return lecturersOnTheSubject;
	}

	public void setLecturersOnTheSubject(List<LecturerOnTheSubject> lecturersOnTheSubject) {
		this.lecturersOnTheSubject = lecturersOnTheSubject;
	}

	@Override
	public String toString() {
		return "SubjectPerformance [subject_performance_id=" + subject_performance_id + ", school_year=" + school_year
				+ ", attendingCourses=" + attendingCourses + ", subject=" + subject + ", examinationObligations="
				+ examinationObligations + ", lecturersOnTheSubject=" + lecturersOnTheSubject + "]";
	}
	


}
