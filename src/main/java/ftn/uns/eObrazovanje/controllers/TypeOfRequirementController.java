package ftn.uns.eObrazovanje.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.uns.eObrazovanje.model.PreExaminationObligations;
import ftn.uns.eObrazovanje.model.TypeOfRequirement;
import ftn.uns.eObrazovanje.model.DTO.TypeOfRequirementsDTO;
import ftn.uns.eObrazovanje.model.request.AddPreExaminationObligationRequest;
import ftn.uns.eObrazovanje.service.PreExaminationObligationService;
import ftn.uns.eObrazovanje.service.TypeOfRequirementService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "api/typeOfRequirements")
public class TypeOfRequirementController {
	
	@Autowired 
	TypeOfRequirementService typeOfRequirementService;
	
	@GetMapping 
	public ResponseEntity<List<TypeOfRequirementsDTO>> getTypeOfRequirements(){
		List<TypeOfRequirement> typeOfRequirements = typeOfRequirementService.findAll();
		List<TypeOfRequirementsDTO> dtos = new ArrayList<TypeOfRequirementsDTO>();
		for(TypeOfRequirement type: typeOfRequirements) {
			dtos.add(new TypeOfRequirementsDTO(type));
		}
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TypeOfRequirement> getTypeOfRequirement(@PathVariable("id") Integer id){
		TypeOfRequirement typeOfRequirement = typeOfRequirementService.findOne(id);
		if(typeOfRequirement == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(typeOfRequirement, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteTypeOfRequirement(@PathVariable("id") Integer id){
		//TypeOfRequirement typeOfRequirement = typeOfRequirementService.findOne(id);
		
		typeOfRequirementService.remove(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<TypeOfRequirement> saveTypeOfRequirement(@RequestBody TypeOfRequirement typeOfRequirementRequest){
		
		TypeOfRequirement typeOfRequirement = new TypeOfRequirement();
		
		typeOfRequirement.setName(typeOfRequirementRequest.getName());
		
		typeOfRequirement = typeOfRequirementService.save(typeOfRequirement);
		return new ResponseEntity<>(typeOfRequirement, HttpStatus.CREATED);
		
	}
	
	/*@PutMapping(value = "/{id}")
	public ResponseEntity<TypeOfRequirement> updateTypeOfRequirement(@RequestBody TypeOfRequirement typeOfRequirementRequest, @PathVariable("id") Integer id){
		return null;
		
		
	}*/

}
