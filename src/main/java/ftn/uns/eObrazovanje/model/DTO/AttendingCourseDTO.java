package ftn.uns.eObrazovanje.model.DTO;

public class AttendingCourseDTO {
	private Integer attending_courses_id;
	private Integer student;
	private Integer subjectPerformance;
	
	public AttendingCourseDTO() {
		super();
	}
	
	public AttendingCourseDTO(Integer attending_courses_id, Integer student, Integer subjectPerformance) {
		super();
		this.attending_courses_id = attending_courses_id;
		this.student = student;
		this.subjectPerformance = subjectPerformance;
	}
	
	public AttendingCourseDTO(Integer student, Integer subjectPerformance) {
		super();
		this.student = student;
		this.subjectPerformance = subjectPerformance;
	}
	
	public Integer getAttending_courses_id() {
		return attending_courses_id;
	}
	public void setAttending_courses_id(Integer attending_courses_id) {
		this.attending_courses_id = attending_courses_id;
	}
	public Integer getStudent() {
		return student;
	}
	public void setStudent(Integer student) {
		this.student = student;
	}
	public Integer getSubjectPerformance() {
		return subjectPerformance;
	}
	public void setSubjectPerformance(Integer subjectPerformance) {
		this.subjectPerformance = subjectPerformance;
	}

	@Override
	public String toString() {
		return "AttendingCourseDTO [attending_courses_id=" + attending_courses_id + ", student=" + student
				+ ", subjectPerformance=" + subjectPerformance + "]";
	}
	
	
}
