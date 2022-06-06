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

import ftn.uns.eObrazovanje.model.LecturerOnTheSubject;
import ftn.uns.eObrazovanje.model.Payment;
import ftn.uns.eObrazovanje.model.PreExaminationObligations;
import ftn.uns.eObrazovanje.model.DTO.PreExaminationDTO;
import ftn.uns.eObrazovanje.model.request.AddPaymentRequest;
import ftn.uns.eObrazovanje.model.request.AddPreExaminationObligationRequest;
import ftn.uns.eObrazovanje.service.ExamDateService;
import ftn.uns.eObrazovanje.service.PreExaminationObligationService;
import ftn.uns.eObrazovanje.service.SubjectPerformanceService;
import ftn.uns.eObrazovanje.service.SubjectService;
import ftn.uns.eObrazovanje.service.TypeOfRequirementService;

@RestController
@CrossOrigin(origins="*")
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
	public ResponseEntity<List<PreExaminationDTO>> getObligations(){
		List<PreExaminationObligations> preExaminationObligations = examinationObligationService.findAll();
		List<PreExaminationDTO> preExamDTOList = new ArrayList<PreExaminationDTO>();
		for(PreExaminationObligations item:preExaminationObligations) {
			preExamDTOList.add(new PreExaminationDTO(item));
		}
		return new ResponseEntity<>(preExamDTOList, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PreExaminationDTO> getPreExaminationObligation(@PathVariable("id") Integer id){
		PreExaminationObligations preExaminationObligations = examinationObligationService.findOne(id);
		if(preExaminationObligations == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		PreExaminationDTO preExamDto = new PreExaminationDTO(preExaminationObligations);
		return new ResponseEntity<>(preExamDto, HttpStatus.OK);
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
	public ResponseEntity<PreExaminationDTO> updateObligation(@RequestBody AddPreExaminationObligationRequest examinationObligationRequest, @PathVariable("id") Integer id){
		
		PreExaminationObligations preExaminationObligation = examinationObligationService.findOne(id);
		if(preExaminationObligation == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		preExaminationObligation.setSubject(this.subjectService.findOne(examinationObligationRequest.getSubjectId()));
		preExaminationObligation.setMandatory(examinationObligationRequest.getMandatory());
		preExaminationObligation.setPoints(examinationObligationRequest.getPoints());
		preExaminationObligation.setExamDate(this.examDateService.findOne(examinationObligationRequest.getExamDateId()));
		preExaminationObligation.setSubjectPerformance(this.subjectPerformanceService.findOne(examinationObligationRequest.getSubjectPerformanceId()));
		preExaminationObligation.setTypeOfRequirement(this.typeOfRequirementService.findOne(examinationObligationRequest.getTypeOfRequirementId()));
		preExaminationObligation.setDeleted(false);
		
		preExaminationObligation = examinationObligationService.save(preExaminationObligation);
		PreExaminationDTO preExamDto = new PreExaminationDTO(preExaminationObligation);
		return new ResponseEntity<>(preExamDto, HttpStatus.OK);
		
	}
	
	
	@PostMapping()
	public ResponseEntity<PreExaminationDTO> savePreExaminationObligation(@RequestBody AddPreExaminationObligationRequest examinationObligationRequest){
		
		PreExaminationObligations preExaminationObligation = new PreExaminationObligations();
		
		preExaminationObligation.setSubject(this.subjectService.findOne(examinationObligationRequest.getSubjectId()));
		preExaminationObligation.setMandatory(examinationObligationRequest.getMandatory());
		preExaminationObligation.setPoints(examinationObligationRequest.getPoints());
		preExaminationObligation.setExamDate(this.examDateService.findOne(examinationObligationRequest.getExamDateId()));
		preExaminationObligation.setSubjectPerformance(this.subjectPerformanceService.findOne(examinationObligationRequest.getSubjectPerformanceId()));
		preExaminationObligation.setTypeOfRequirement(this.typeOfRequirementService.findOne(examinationObligationRequest.getTypeOfRequirementId()));
		preExaminationObligation.setDeleted(false);
		
		preExaminationObligation = examinationObligationService.save(preExaminationObligation);
		PreExaminationDTO preExamDto = new PreExaminationDTO(preExaminationObligation);
		return new ResponseEntity<>(preExamDto, HttpStatus.CREATED);
		
	}
	
	@GetMapping(value = "/subject/{id}")
	public ResponseEntity<List<PreExaminationObligations>> getPreExamBySubjectId(@PathVariable("id") Integer id){
		List<PreExaminationObligations> preExams = examinationObligationService.findAll();
		List<PreExaminationObligations> lsitOfPreExam = new ArrayList<>();
		for (PreExaminationObligations preExam : preExams) {
			if ( preExam.getSubject().getId() == id ) {
				lsitOfPreExam.add(preExam);
			}
		}
		return new ResponseEntity<>(lsitOfPreExam, HttpStatus.OK);
	}
	
	
	
}
