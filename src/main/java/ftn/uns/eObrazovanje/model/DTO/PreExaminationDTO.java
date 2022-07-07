package ftn.uns.eObrazovanje.model.DTO;


import ftn.uns.eObrazovanje.model.ExamDate;
import ftn.uns.eObrazovanje.model.PreExaminationObligations;
import ftn.uns.eObrazovanje.model.Subject;
import ftn.uns.eObrazovanje.model.SubjectPerformance;

public class PreExaminationDTO {
	private Integer pre_examination_obligation_id;
	private Subject subject;

	private Boolean mandatory;
	private Float points;

	private ExamDate examDate;

	private SubjectPerformance subjectPerformance;
	private TypeOfRequirementDTO typeOfRequirement;

	private boolean deleted;

	public PreExaminationDTO(Integer pre_examination_obligation_id, Subject subject, Boolean mandatory, Float points,
			ExamDate examDate, SubjectPerformance subjectPerformance, TypeOfRequirementDTO typeOfRequirement,
			boolean deleted) {
		super();
		this.pre_examination_obligation_id = pre_examination_obligation_id;
		this.subject = subject;
		this.mandatory = mandatory;
		this.points = points;
		this.examDate = examDate;
		this.subjectPerformance = subjectPerformance;
		this.typeOfRequirement = typeOfRequirement;
		this.deleted = deleted;
	}
	
	public PreExaminationDTO(PreExaminationObligations entity) {
		super();
		this.pre_examination_obligation_id = entity.getPre_examination_obligation_id();
		this.subject = entity.getSubject();
		this.mandatory = entity.getMandatory();
		this.points = entity.getPoints();
		this.examDate = entity.getExamDate();
		this.subjectPerformance = entity.getSubjectPerformance();
		this.typeOfRequirement = new TypeOfRequirementDTO(entity.getTypeOfRequirement());
		this.deleted = entity.isDeleted();
	}

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

	public TypeOfRequirementDTO getTypeOfRequirement() {
		return typeOfRequirement;
	}

	public void setTypeOfRequirement(TypeOfRequirementDTO typeOfRequirement) {
		this.typeOfRequirement = typeOfRequirement;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	

}