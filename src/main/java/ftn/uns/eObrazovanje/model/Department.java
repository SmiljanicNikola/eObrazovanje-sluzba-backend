package ftn.uns.eObrazovanje.model;

import static javax.persistence.CascadeType.ALL;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="departments")
public class Department implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "department_id", unique=true, nullable = false)
	private Integer id;
	
	@Column(name = "number_of_students", unique = false, nullable = false)
	private Integer numberOfStudents;

	@Column(name = "name", unique = false, nullable = false)
	private String name;
	
	@OneToMany(cascade= {ALL}, mappedBy= "department")
    private List<Semester> semesters = new ArrayList<Semester>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumberOfStudents() {
		return numberOfStudents;
	}

	public void setNumberOfStudents(Integer numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department(Integer id, Integer numberOfStudents, String name) {
		super();
		this.id = id;
		this.numberOfStudents = numberOfStudents;
		this.name = name;
	}

	public Department() {
		super();
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", numberOfStudents=" + numberOfStudents + ", name=" + name + "]";
	}
	
	
}
