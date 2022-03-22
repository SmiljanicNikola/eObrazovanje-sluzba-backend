package ftn.uns.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pre_examination_obligation")
public class PreExaminationObligations {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pre_examination_obligation_id", unique = true, nullable = false)
	private Integer pre_examination_obligation_id;

	@Column(name = "subject_id", nullable = false)
	private Subject subject_id;

	@Column(name = "mandatory", nullable = false)
	private Boolean mandatory;

	@Column(name = "points", nullable = false)
	private Float points;

	@Column(name = "type_of_requirement_Id", nullable = false)
	private TypeOfRequirement type_of_requirement_Id;
	
	@Column(name = "attending_courses_id", nullable = false)
	private AttendingCourses attending_courses_id;

	public PreExaminationObligations(Integer pre_examination_obligation_id, Subject subject_id, Boolean mandatory,
			Float points, TypeOfRequirement type_of_requirement_Id, AttendingCourses attending_courses_id) {
		super();
		this.pre_examination_obligation_id = pre_examination_obligation_id;
		this.subject_id = subject_id;
		this.mandatory = mandatory;
		this.points = points;
		this.type_of_requirement_Id = type_of_requirement_Id;
		this.attending_courses_id = attending_courses_id;
	}

	public Integer getPre_examination_obligation_id() {
		return pre_examination_obligation_id;
	}

	public void setPre_examination_obligation_id(Integer pre_examination_obligation_id) {
		this.pre_examination_obligation_id = pre_examination_obligation_id;
	}

	public Subject getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(Subject subject_id) {
		this.subject_id = subject_id;
	}

	public Boolean getMandatory() {
		return mandatory;
	}

	public void setMandatory(Boolean mandatory) {
		this.mandatory = mandatory;
	}

	public Float getPoints() {
		return points;
	}

	public void setPoints(Float points) {
		this.points = points;
	}

	public TypeOfRequirement getType_of_requirement_Id() {
		return type_of_requirement_Id;
	}

	public void setType_of_requirement_Id(TypeOfRequirement type_of_requirement_Id) {
		this.type_of_requirement_Id = type_of_requirement_Id;
	}

	public AttendingCourses getAttending_courses_id() {
		return attending_courses_id;
	}

	public void setAttending_courses_id(AttendingCourses attending_courses_id) {
		this.attending_courses_id = attending_courses_id;
	}

	@Override
	public String toString() {
		return "PreExaminationObligations [pre_examination_obligation_id=" + pre_examination_obligation_id
				+ ", subject_id=" + subject_id + ", mandatory=" + mandatory + ", points=" + points
				+ ", type_of_requirement_Id=" + type_of_requirement_Id + ", attending_courses_id="
				+ attending_courses_id + "]";
	}
	

}
