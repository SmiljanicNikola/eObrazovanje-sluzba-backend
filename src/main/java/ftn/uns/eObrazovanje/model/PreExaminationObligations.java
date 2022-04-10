package ftn.uns.eObrazovanje.model;

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
@Table(name = "pre_examination_obligation")
public class PreExaminationObligations implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pre_examination_obligation_id", unique = true, nullable = false)
	private Integer pre_examination_obligation_id;

	@ManyToOne
	@JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
	private Subject subject;

	@Column(name = "mandatory", nullable = false)
	private Boolean mandatory;

	@Column(name = "points", nullable = false)
	private Float points;
	
	@ManyToOne
	@JoinColumn(name = "exam_date_id", referencedColumnName = "exam_date_id")
	private ExamDate examDate;
	
	@ManyToOne
	@JoinColumn(name = "subject_performance_id", referencedColumnName = "subject_performance_id")
	private SubjectPerformance subjectPerformance;

    /*@OneToMany(mappedBy="preExaminationObligations")
    private List<TypeOfRequirement> typeOfRequirements = new ArrayList<TypeOfRequirement>();*/
    
    @ManyToOne
    @JoinColumn(name="type_of_requirement_id", referencedColumnName = "type_of_requirement_id")
    private TypeOfRequirement typeOfRequirement;
    
    @Column(name = "deleted", unique = false, nullable = false)
	private boolean deleted;

	public Integer getPre_examination_obligation_id() {
		return pre_examination_obligation_id;
	}

	public void setPre_examination_obligation_id(Integer pre_examination_obligation_id) {
		this.pre_examination_obligation_id = pre_examination_obligation_id;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
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

	public ExamDate getExamDate() {
		return examDate;
	}

	public void setExamDate(ExamDate examDate) {
		this.examDate = examDate;
	}

	public SubjectPerformance getSubjectPerformance() {
		return subjectPerformance;
	}

	public void setSubjectPerformance(SubjectPerformance subjectPerformance) {
		this.subjectPerformance = subjectPerformance;
	}

	public TypeOfRequirement getTypeOfRequirement() {
		return typeOfRequirement;
	}

	public void setTypeOfRequirement(TypeOfRequirement typeOfRequirement) {
		this.typeOfRequirement = typeOfRequirement;
	}

	public PreExaminationObligations() {
		super();
	}

	public PreExaminationObligations(Integer pre_examination_obligation_id, Subject subject, Boolean mandatory,
			Float points, ExamDate examDate, SubjectPerformance subjectPerformance,
			TypeOfRequirement typeOfRequirement) {
		super();
		this.pre_examination_obligation_id = pre_examination_obligation_id;
		this.subject = subject;
		this.mandatory = mandatory;
		this.points = points;
		this.examDate = examDate;
		this.subjectPerformance = subjectPerformance;
		this.typeOfRequirement = typeOfRequirement;
	}

	public PreExaminationObligations(Subject subject, Boolean mandatory, Float points, ExamDate examDate,
			SubjectPerformance subjectPerformance, TypeOfRequirement typeOfRequirement) {
		super();
		this.subject = subject;
		this.mandatory = mandatory;
		this.points = points;
		this.examDate = examDate;
		this.subjectPerformance = subjectPerformance;
		this.typeOfRequirement = typeOfRequirement;
	}
	
	

	public PreExaminationObligations(Subject subject, Boolean mandatory, Float points, ExamDate examDate,
			SubjectPerformance subjectPerformance, TypeOfRequirement typeOfRequirement, boolean deleted) {
		super();
		this.subject = subject;
		this.mandatory = mandatory;
		this.points = points;
		this.examDate = examDate;
		this.subjectPerformance = subjectPerformance;
		this.typeOfRequirement = typeOfRequirement;
		this.deleted = deleted;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
    
	
	


	

}
