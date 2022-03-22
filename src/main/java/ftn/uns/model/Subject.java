package ftn.uns.model;

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
@Table(name="subjects")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subject_id", unique=true, nullable = false)
	private Integer id;
	
	/*@OneToMany
	@JoinColumn(name = "deparment_id", referencedColumnName = "deparment_id")
	private Department department;*/
	
	@Column(name = "name", unique = false, nullable = false)
	private String name;
	
	@Column(name = "syllabus", unique = false, nullable = false)
	private String syllabus;
	
	@OneToMany
	@JoinColumn(name = "semester_id", referencedColumnName = "semester_id")
	private Semester semester;
	
	
}
