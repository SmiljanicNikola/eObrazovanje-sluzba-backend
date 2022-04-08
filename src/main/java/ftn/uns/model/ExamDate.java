package ftn.uns.model;

import java.io.Serializable;
import java.time.LocalDate;
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
@Table(name = "exam_date")
public class ExamDate implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "exam_date_id", unique=true, nullable = false)
	private Integer id;
	
	@Column(name = "date", unique = false, nullable = false)
	private LocalDate date;
	
	@Column(name = "name", unique = false, nullable = false)
	private String name;
	
    @ManyToOne
    @JoinColumn(name="taking_exam_id", nullable=false)
    private TakingExam takingExam;
    
    @OneToMany(mappedBy="examDate")
    private List<PreExaminationObligations> examinationObligations = new ArrayList<PreExaminationObligations>();
    
    

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TakingExam getTakingExam() {
		return takingExam;
	}

	public void setTakingExam(TakingExam takingExam) {
		this.takingExam = takingExam;
	}

	public ExamDate(Integer id, LocalDate date, String name, TakingExam takingExam) {
		super();
		this.id = id;
		this.date = date;
		this.name = name;
		this.takingExam = takingExam;
	}

	public ExamDate(LocalDate date, String name, TakingExam takingExam) {
		super();
		this.date = date;
		this.name = name;
		this.takingExam = takingExam;
	}

	public ExamDate() {
		super();
	}
    
    
}
