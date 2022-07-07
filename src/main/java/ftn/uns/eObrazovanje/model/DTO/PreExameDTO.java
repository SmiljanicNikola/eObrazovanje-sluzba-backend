package ftn.uns.eObrazovanje.model.DTO;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import ftn.uns.eObrazovanje.model.ExamDate;
import ftn.uns.eObrazovanje.model.PreExaminationObligations;
import ftn.uns.eObrazovanje.model.Subject;
import ftn.uns.eObrazovanje.model.SubjectPerformance;
import ftn.uns.eObrazovanje.model.TypeOfRequirement;

public class PreExameDTO {

	private Integer pre_examination_obligation_id;

	private String subject;

	private Boolean mandatory;

	private Float points;
	
	private ExamDateDTO examDate;
	
	private String subjectPerformance;

    private String typeOfRequirement;
    
    public PreExameDTO(PreExaminationObligations entity) {
    	this.pre_examination_obligation_id = entity.getPre_examination_obligation_id();
    	this.subject = entity.getSubject().getName();
    	this.mandatory = entity.getMandatory();
    	this.examDate = new ExamDateDTO(entity.getExamDate());
    	this.points = entity.getPoints();
    	this.subjectPerformance = entity.getSubjectPerformance().getSchool_year();
    	this.typeOfRequirement = entity.getTypeOfRequirement().getName();
    }

	public Integer getPre_examination_obligation_id() {
		return pre_examination_obligation_id;
	}

	public void setPre_examination_obligation_id(Integer pre_examination_obligation_id) {
		this.pre_examination_obligation_id = pre_examination_obligation_id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
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

	public ExamDateDTO getExamDate() {
		return examDate;
	}

	public void setExamDate(ExamDateDTO examDate) {
		this.examDate = examDate;
	}

	public String getSubjectPerformance() {
		return subjectPerformance;
	}

	public void setSubjectPerformance(String subjectPerformance) {
		this.subjectPerformance = subjectPerformance;
	}

	public String getTypeOfRequirement() {
		return typeOfRequirement;
	}

	public void setTypeOfRequirement(String typeOfRequirement) {
		this.typeOfRequirement = typeOfRequirement;
	}
    
    
    
}
