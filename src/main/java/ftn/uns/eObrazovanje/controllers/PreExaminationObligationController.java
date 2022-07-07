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
import ftn.uns.eObrazovanje.model.DTO.PreExameDTO;
import ftn.uns.eObrazovanje.model.request.AddPreExaminationObligationRequest;
import ftn.uns.eObrazovanje.service.ExamDateService;
import ftn.uns.eObrazovanje.service.PreExaminationObligationService;
import ftn.uns.eObrazovanje.service.SubjectPerformanceService;
import ftn.uns.eObrazovanje.service.SubjectService;
import ftn.uns.eObrazovanje.service.TypeOfRequirementService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "api/examinationObligations")
public class PreExaminationObligationController {
	
	@Autowired 
	PreExaminationObligationService examinationObligationService;
	
	@Autowired 
	SubjectService subjectService;
	
	@Autowired 
	TypeOfRequirementService typeOfRequirementService;
	
	@Autowired
	ExamDateService examDateService;
	
	@Autowired
	SubjectPerformanceService subjectPerformanceService;
	
	
	@GetMapping 
	public ResponseEntity<List<PreExameDTO>> getObligations(){
		List<PreExaminationObligations> preExaminationObligations = examinationObligationService.findAll();
		List<PreExameDTO> dtos = new ArrayList<PreExameDTO>();
		for(PreExaminationObligations p : preExaminationObligations) {
			dtos.add(new PreExameDTO(p));
		}
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AddPreExaminationObligationRequest> getPreExaminationObligation(@PathVariable("id") Integer id){
		PreExaminationObligations preExaminationObligations = examinationObligationService.findOne(id);
		if(preExaminationObligations == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new AddPreExaminationObligationRequest(preExaminationObligations), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deletePreExaminationObligation(@PathVariable("id") Integer id){
		PreExaminationObligations preExaminationObligation = examinationObligationService.findOne(id);
		
		if(!preExaminationObligation.isDeleted()) {
			preExaminationObligation.setDeleted(true);
			examinationObligationService.save(preExaminationObligation);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<PreExaminationObligations> updateObligation(@RequestBody AddPreExaminationObligationRequest examinationObligationRequest, @PathVariable("id") Integer id){
		
		PreExaminationObligations preExaminationObligation = examinationObligationService.findOne(id);
		if(preExaminationObligation == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		//preExaminationObligation.setExamDate(this.examDateService.findOne(examinationObligationRequest.getExamDateId()));
		preExaminationObligation.setPoints(examinationObligationRequest.getPoints());
		//preExaminationObligation.setTypeOfRequirement(typeOfRequirement);
		
		preExaminationObligation = examinationObligationService.save(preExaminationObligation);
		return new ResponseEntity<>(preExaminationObligation, HttpStatus.OK);
		
	}
	
	
	@PostMapping()
	public ResponseEntity<PreExaminationObligations> savePreExaminationObligation(@RequestBody AddPreExaminationObligationRequest examinationObligationRequest){
		
		PreExaminationObligations preExaminationObligation = new PreExaminationObligations();
		
		preExaminationObligation.setSubject(this.subjectService.findOne(examinationObligationRequest.getSubjectId()));
		preExaminationObligation.setMandatory(examinationObligationRequest.getMandatory());
		preExaminationObligation.setPoints(examinationObligationRequest.getPoints());
		preExaminationObligation.setExamDate(this.examDateService.findOne(examinationObligationRequest.getExamDateId()));
		preExaminationObligation.setSubjectPerformance(this.subjectPerformanceService.findOne(examinationObligationRequest.getSubjectPerformanceId()));
		preExaminationObligation.setTypeOfRequirement(this.typeOfRequirementService.findOne(examinationObligationRequest.getTypeOfRequirementId()));
		preExaminationObligation.setDeleted(false);
		
		preExaminationObligation = examinationObligationService.save(preExaminationObligation);
		return new ResponseEntity<>(preExaminationObligation, HttpStatus.CREATED);
		
	}
	
}
