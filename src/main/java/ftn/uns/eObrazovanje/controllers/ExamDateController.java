package ftn.uns.eObrazovanje.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ftn.uns.eObrazovanje.model.ExamDate;
import ftn.uns.eObrazovanje.model.TakingExam;
import ftn.uns.eObrazovanje.model.request.AddExamDateRequest;
import ftn.uns.eObrazovanje.service.ExamDateService;
import ftn.uns.eObrazovanje.service.TakingExamService;

@RestController
@CrossOrigin(origins="*")
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
		
		//examDate.setDeleted(true);
		examDateService.remove(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ExamDate> updateExamDate(@RequestBody AddExamDateRequest examDateRequest, @PathVariable("id") Integer id){
		
		ExamDate examDate = examDateService.findOne(id);
		List<TakingExam> exams = new ArrayList<TakingExam>();
		exams.add(this.takingExamService.findOne(examDateRequest.getTakingExamId()));
		if(examDate == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		examDate.setDate(examDateRequest.getDate());
		examDate.setName(examDateRequest.getName());
		examDate.setTakingExams(exams);
		examDate.setDeleted(examDateRequest.isDeleted());
		//Jos provera
		
		examDate = examDateService.save(examDate);
		return new ResponseEntity<>(examDate, HttpStatus.OK);
		
	}
	
	@PostMapping()
	public ResponseEntity<ExamDate> saveExamDate(@RequestBody AddExamDateRequest examDateRequest){
		
		ExamDate examDate = new ExamDate();
		
		examDate.setDate(examDateRequest.getDate());
		examDate.setName(examDateRequest.getName());
		examDate.setTakingExams(null);
		examDate.setDeleted(false);
		
		examDate = examDateService.save(examDate);
		return new ResponseEntity<>(examDate, HttpStatus.CREATED);
		
	}
}
