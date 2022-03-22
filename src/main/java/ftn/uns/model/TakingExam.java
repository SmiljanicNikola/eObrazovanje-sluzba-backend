package ftn.uns.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

public class TakingExam {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "taking_exam_id", unique=true, nullable = false)
	private Integer id;
	
	@Column(name = "grade", unique = false, nullable = false)
	private Integer grade;
	
	@Column(name = "passed", unique = false, nullable = false)
	private boolean passed;
	
	@JoinColumn(name = "lecturer_id", referencedColumnName = "lecturer_id")
	private Lecturer lecturer;

}
