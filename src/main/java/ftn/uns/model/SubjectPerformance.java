package ftn.uns.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subject_performances")
public class SubjectPerformance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subject_performances_id", unique = true, nullable = false)
	private Integer subject_performances_id;

	@Column(name = "subject_id", unique = false, nullable = false)
	private Subject subject_id;

	@Column(name = "school_year", unique = false, nullable = false)
	private String school_year;

	public SubjectPerformance(Integer subject_performances_id, Subject subject_id, String school_year) {
		super();
		this.subject_performances_id = subject_performances_id;
		this.subject_id = subject_id;
		this.school_year = school_year;
	}

	public Integer getSubject_performances_id() {
		return subject_performances_id;
	}

	public void setSubject_performances_id(Integer subject_performances_id) {
		this.subject_performances_id = subject_performances_id;
	}

	public Subject getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(Subject subject_id) {
		this.subject_id = subject_id;
	}

	public String getSchool_year() {
		return school_year;
	}

	public void setSchool_year(String school_year) {
		this.school_year = school_year;
	}

}
