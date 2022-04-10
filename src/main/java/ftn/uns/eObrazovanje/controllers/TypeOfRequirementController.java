package ftn.uns.eObrazovanje.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.uns.eObrazovanje.service.PreExaminationObligationService;
import ftn.uns.eObrazovanje.service.TypeOfRequirementService;

@RestController
@RequestMapping(value = "api/typeOfRequirements")
public class TypeOfRequirementController {
	
	@Autowired 
	TypeOfRequirementService typeOfRequirementService;
	
	

}
