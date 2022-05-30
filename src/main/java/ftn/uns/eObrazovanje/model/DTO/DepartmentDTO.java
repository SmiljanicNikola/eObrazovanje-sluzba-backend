package ftn.uns.eObrazovanje.model.DTO;

import ftn.uns.eObrazovanje.model.Semester;

public class DepartmentDTO {

	private Integer department_id;
	private String name;
	private Integer number_of_students;
	private boolean blocked;
	private Semester semesters;

	public DepartmentDTO() {
		super();
	}
	
	public DepartmentDTO(Integer department_id, String name, Integer number_of_students, boolean blocked,
			Semester semesters) {
		super();
		this.department_id = department_id;
		this.name = name;
		this.number_of_students = number_of_students;
		this.blocked = blocked;
		this.semesters = semesters;
	}

	public Integer getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumber_of_students() {
		return number_of_students;
	}

	public void setNumber_of_students(Integer number_of_students) {
		this.number_of_students = number_of_students;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public Semester getSemesters() {
		return semesters;
	}

	public void setSemesters(Semester semesters) {
		this.semesters = semesters;
	}

}
