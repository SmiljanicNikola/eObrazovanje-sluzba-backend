package ftn.uns.eObrazovanje.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.uns.eObrazovanje.model.ExamDate;
import ftn.uns.eObrazovanje.model.request.AddExamDateRequest;
import ftn.uns.eObrazovanje.service.ExamDateService;
import ftn.uns.eObrazovanje.service.TakingExamService;

@RestController
@RequestMapping(value = "api/examDates")
public class ExamDateController {
	
	@Autowired
	ExamDateService examDateService;
	
	@Autowired
	TakingExamService takingExamService;
	
	@GetMapping
	public ResponseEntity<List<ExamDate>> getExamDates(){
		List<ExamDate> examDates = examDateService.findAll();
		
		return new ResponseEntity<>(examDates, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ExamDate> getExamDates(@PathVariable("id") Integer id){
		ExamDate examDate = examDateService.findOne(id);
		if(examDate == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(examDate, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteExamDate(@PathVariable("id") Integer id){
		ExamDate examDate = examDateService.findOne(id);
		
		examDate.setDeleted(true);
		examDateService.save(examDate);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ExamDate> updateExamDate(@RequestBody AddExamDateRequest examDateRequest, @PathVariable("id") Integer id){
		
		ExamDate examDate = examDateService.findOne(id);
		if(examDate == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		examDate.setDate(examDateRequest.getDate());
		examDate.setName(examDateRequest.getName());
		examDate.setTakingExam(this.takingExamService.findOne(examDateRequest.getTakingExamId()));
		//examDate.setDeleted(examDateRe);
		//Jos provera
		
		examDate = examDateService.save(examDate);
		return new ResponseEntity<>(examDate, HttpStatus.OK);
		
	}
	
	@PostMapping()
	public ResponseEntity<ExamDate> saveExamDate(@RequestBody AddExamDateRequest examDateRequest){
		
		ExamDate examDate = new ExamDate();
		
		examDate.setDate(examDateRequest.getDate());
		examDate.setName(examDateRequest.getName());
		examDate.setTakingExam(this.takingExamService.findOne(examDateRequest.getTakingExamId()));
		examDate.setDeleted(false);
		
		examDate = examDateService.save(examDate);
		return new ResponseEntity<>(examDate, HttpStatus.CREATED);
		
	}
	
	

}
