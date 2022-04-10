package ftn.uns.eObrazovanje.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.uns.eObrazovanje.model.TypeOfRequirement;
import ftn.uns.eObrazovanje.repository.TypeOfRequirementRepo;
import ftn.uns.eObrazovanje.service.TypeOfRequirementService;

@Service
public class TypeOfRequirementServiceImpl implements TypeOfRequirementService {

	@Autowired
	private TypeOfRequirementRepo typeOfRequirementRepo;
	
	@Override
	public List<TypeOfRequirement> findAll() {
		return typeOfRequirementRepo.findAll();
	}

	@Override
	public TypeOfRequirement save(TypeOfRequirement typeOfRequirement) {
		typeOfRequirementRepo.save(typeOfRequirement);
		return typeOfRequirement;
	}

	@Override
	public TypeOfRequirement findOne(Integer id) {
		return typeOfRequirementRepo.findById(id).orElse(null);
	}

	@Override
	public void remove(Integer id) {
		typeOfRequirementRepo.deleteById(id);
		
	}

}
