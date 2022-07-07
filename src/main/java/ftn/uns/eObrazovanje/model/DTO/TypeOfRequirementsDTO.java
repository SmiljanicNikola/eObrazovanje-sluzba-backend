package ftn.uns.eObrazovanje.model.DTO;

import javax.persistence.Column;

import ftn.uns.eObrazovanje.model.TypeOfRequirement;

public class TypeOfRequirementsDTO {
	private Integer id;

	private String name;
	
	public TypeOfRequirementsDTO(TypeOfRequirement entity) {
		this.id = entity.getId();
		this.name = entity.getName();
	}

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
	
	
}
