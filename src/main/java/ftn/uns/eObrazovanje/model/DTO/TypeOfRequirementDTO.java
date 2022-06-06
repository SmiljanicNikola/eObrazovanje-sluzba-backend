package ftn.uns.eObrazovanje.model.DTO;

import ftn.uns.eObrazovanje.model.TypeOfRequirement;

public class TypeOfRequirementDTO {

	private Integer id;
	private String name;

	public TypeOfRequirementDTO(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public TypeOfRequirementDTO(TypeOfRequirement entity) {
		super();
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
