package ftn.uns.eObrazovanje.model.request;

import java.time.LocalDate;

public class AddExamDateRequest {

	private Integer id;
	
	private LocalDate date;
	
	private String name;
	
    private Integer takingExamId;
    
	private boolean deleted;

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

	public Integer getTakingExamId() {
		return takingExamId;
	}

	public void setTakingExamId(Integer takingExamId) {
		this.takingExamId = takingExamId;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public AddExamDateRequest(Integer id, LocalDate date, String name, Integer takingExamId, boolean deleted) {
		super();
		this.id = id;
		this.date = date;
		this.name = name;
		this.takingExamId = takingExamId;
		this.deleted = deleted;
	}

	public AddExamDateRequest(LocalDate date, String name, Integer takingExamId, boolean deleted) {
		super();
		this.date = date;
		this.name = name;
		this.takingExamId = takingExamId;
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "AddExamDateRequest [id=" + id + ", date=" + date + ", name=" + name + ", takingExamId=" + takingExamId
				+ ", deleted=" + deleted + "]";
	}

	public AddExamDateRequest() {
		super();
	}
	
	
	
}
