package ftn.uns.eObrazovanje.model.request;

public class AddPreExaminationObligationRequest {
	
	
	private Integer pre_examination_obligation_id;

	private Integer subjectId;

	private Boolean mandatory;

	private Float points;
	
	private Integer examDateId;
	
	private Integer subjectPerformanceId;
    
    private Integer typeOfRequirementId;
    
	private boolean deleted;

	public Integer getPre_examination_obligation_id() {
		return pre_examination_obligation_id;
	}

	public void setPre_examination_obligation_id(Integer pre_examination_obligation_id) {
		this.pre_examination_obligation_id = pre_examination_obligation_id;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
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

	public Integer getExamDateId() {
		return examDateId;
	}

	public void setExamDateId(Integer examDateId) {
		this.examDateId = examDateId;
	}

	public Integer getSubjectPerformanceId() {
		return subjectPerformanceId;
	}

	public void setSubjectPerformanceId(Integer subjectPerformanceId) {
		this.subjectPerformanceId = subjectPerformanceId;
	}

	public Integer getTypeOfRequirementId() {
		return typeOfRequirementId;
	}

	public void setTypeOfRequirementId(Integer typeOfRequirementId) {
		this.typeOfRequirementId = typeOfRequirementId;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	

	public AddPreExaminationObligationRequest() {
		super();
	}



	public AddPreExaminationObligationRequest(Integer pre_examination_obligation_id, Integer subjectId,
			Boolean mandatory, Float points, Integer examDateId, Integer subjectPerformanceId,
			Integer typeOfRequirementId, boolean deleted) {
		super();
		this.pre_examination_obligation_id = pre_examination_obligation_id;
		this.subjectId = subjectId;
		this.mandatory = mandatory;
		this.points = points;
		this.examDateId = examDateId;
		this.subjectPerformanceId = subjectPerformanceId;
		this.typeOfRequirementId = typeOfRequirementId;
		this.deleted = deleted;
	}

	public AddPreExaminationObligationRequest(Integer subjectId, Boolean mandatory, Float points, Integer examDateId,
			Integer subjectPerformanceId, Integer typeOfRequirementId) {
		super();
		this.subjectId = subjectId;
		this.mandatory = mandatory;
		this.points = points;
		this.examDateId = examDateId;
		this.subjectPerformanceId = subjectPerformanceId;
		this.typeOfRequirementId = typeOfRequirementId;
	}

	public AddPreExaminationObligationRequest(Integer subjectId, Boolean mandatory, Float points, Integer examDateId,
			Integer subjectPerformanceId, Integer typeOfRequirementId, boolean deleted) {
		super();
		this.subjectId = subjectId;
		this.mandatory = mandatory;
		this.points = points;
		this.examDateId = examDateId;
		this.subjectPerformanceId = subjectPerformanceId;
		this.typeOfRequirementId = typeOfRequirementId;
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "AddPreExaminationObligationRequest [pre_examination_obligation_id=" + pre_examination_obligation_id
				+ ", subjectId=" + subjectId + ", mandatory=" + mandatory + ", points=" + points + ", examDateId="
				+ examDateId + ", subjectPerformanceId=" + subjectPerformanceId + ", typeOfRequirementId="
				+ typeOfRequirementId + ", deleted=" + deleted + "]";
	}
	
	
	
	

}
