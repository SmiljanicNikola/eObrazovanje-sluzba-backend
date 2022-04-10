package ftn.uns.eObrazovanje.service;

import java.util.List;

import ftn.uns.eObrazovanje.model.TypeOfRequirement;

public interface TypeOfRequirementService {
	
	List<TypeOfRequirement> findAll();
	
	TypeOfRequirement save(TypeOfRequirement typeOfRequirement);
	
	TypeOfRequirement findOne(Integer id);
	
	void remove(Integer id);

}
