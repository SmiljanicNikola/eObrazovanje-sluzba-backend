package ftn.uns.eObrazovanje.model.DTO;

import java.time.LocalDate;

import ftn.uns.eObrazovanje.model.ExamDate;


public class ExamDateDTO {
	
	private Integer id;
	
	private LocalDate date;
	
	private String name;
	
	public ExamDateDTO(ExamDate entity) {
		this.id = entity.getId();
		this.date = entity.getDate();
		this.name = entity.getName();
	}

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
	
	

}
