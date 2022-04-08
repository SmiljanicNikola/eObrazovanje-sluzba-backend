package ftn.uns.model;

import static javax.persistence.CascadeType.ALL;

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
@Table(name="subjects")
public class Subject implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subject_id", unique=true, nullable = false)
	private Integer id;
	
	@Column(name = "name", unique = false, nullable = false)
	private String name;
	
	@Column(name = "syllabus", unique = false, nullable = false)
	private String syllabus;
	
	@ManyToOne
	@JoinColumn(name = "semester_id", referencedColumnName = "semester_id")
	private Semester semester;
	
	@OneToMany(cascade= {ALL}, mappedBy= "subject")
    private List<SubjectPerformance> subjectPerformances = new ArrayList<SubjectPerformance>();
	
	@OneToMany(cascade= {ALL}, mappedBy= "subject")
    private List<PreExaminationObligations> examinationObligations = new ArrayList<PreExaminationObligations>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSyllabus() {
		return syllabus;
	}

	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public Subject() {
		super();
	}

	

	public Subject(Integer id, String name, String syllabus, Semester semester) {
		super();
		this.id = id;
		this.name = name;
		this.syllabus = syllabus;
		this.semester = semester;
	}

	public Subject(Integer id, String name, String syllabus, Semester semester,
			List<SubjectPerformance> subjectPerformances) {
		super();
		this.id = id;
		this.name = name;
		this.syllabus = syllabus;
		this.semester = semester;
		this.subjectPerformances = subjectPerformances;
	}

	public Subject(String name, String syllabus, Semester semester, List<SubjectPerformance> subjectPerformances) {
		super();
		this.name = name;
		this.syllabus = syllabus;
		this.semester = semester;
		this.subjectPerformances = subjectPerformances;
	}

	public List<SubjectPerformance> getSubjectPerformances() {
		return subjectPerformances;
	}

	public void setSubjectPerformances(List<SubjectPerformance> subjectPerformances) {
		this.subjectPerformances = subjectPerformances;
	}
	
	
	
	
}
