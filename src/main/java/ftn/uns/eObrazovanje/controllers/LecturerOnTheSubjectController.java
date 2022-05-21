package ftn.uns.eObrazovanje.controllers;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import ftn.uns.eObrazovanje.model.LecturerOnTheSubject;
import ftn.uns.eObrazovanje.model.TakingExam;
import ftn.uns.eObrazovanje.service.LecturerOnTheSubjectService;

@Controller
@RequestMapping(value = "api/lecturersOnTheSubject")
public class LecturerOnTheSubjectController {

	@Autowired
	private LecturerOnTheSubjectService lecturerOnTheSubjectService;
	
	@GetMapping 
	public ResponseEntity<List<LecturerOnTheSubject>> getLecturerOnTheSubject(){
		List<LecturerOnTheSubject> lecturerOnTheSubjects = lecturerOnTheSubjectService.findAll();
		
		return new ResponseEntity<>(lecturerOnTheSubjects, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<LecturerOnTheSubject> getLecturerOnTheSubject(@PathVariable("id") Integer id){
		LecturerOnTheSubject lecturerOnTheSubject = lecturerOnTheSubjectService.findOne(id);
		if(lecturerOnTheSubject == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(lecturerOnTheSubject, HttpStatus.OK);
	}
	
	@GetMapping(value = "/lecturer/{id}")
	public ResponseEntity<List<LecturerOnTheSubject>> getLecturerOnTheSubjectsByLecturerId(@PathVariable("id") Integer id){
		List<LecturerOnTheSubject> lecturerOnTheSubjects = lecturerOnTheSubjectService.findAll();
		List<LecturerOnTheSubject> listOfLecturerOnTheSubjects = new ArrayList<>();
		for (LecturerOnTheSubject lecturerOnTheSubject : lecturerOnTheSubjects) {
			if ( lecturerOnTheSubject.getLecturerOnTheSubject_Id() == id ) {
				listOfLecturerOnTheSubjects.add(lecturerOnTheSubject);
			}
		}
		return new ResponseEntity<>(listOfLecturerOnTheSubjects, HttpStatus.OK);
	}
	
	@GetMapping(value = "/subject/{id}")
	public ResponseEntity<List<LecturerOnTheSubject>> getLecturerOnTheSubjectsBySubjectId(@PathVariable("id") Integer id){
		List<LecturerOnTheSubject> lecturerOnTheSubjects = lecturerOnTheSubjectService.findAll();
		List<LecturerOnTheSubject> listOfLecturerOnTheSubjects = new ArrayList<>();
		for (LecturerOnTheSubject lecturerOnTheSubject : lecturerOnTheSubjects) {
			if ( lecturerOnTheSubject.getSubjectPerformance().getSubject_performance_id() == id ) { // ??? ovo nemam blage da li radi nisam stigao da testiram
				listOfLecturerOnTheSubjects.add(lecturerOnTheSubject);
			}
		}
		return new ResponseEntity<>(listOfLecturerOnTheSubjects, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteTakingExam(@PathVariable("id") Integer id){
		LecturerOnTheSubject lecturerOnTheSubject = lecturerOnTheSubjectService.findOne(id);
		
		if(!lecturerOnTheSubject.isDeleted()) {
			lecturerOnTheSubject.setDeleted(true);
			lecturerOnTheSubjectService.save(lecturerOnTheSubject);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<LecturerOnTheSubject> updateLecturerOnTheSubject(
        @PathVariable(value = "id", required = false) final Integer id,
        @RequestBody LecturerOnTheSubject lecturerOnTheSubject
    ) throws URISyntaxException {
        if (lecturerOnTheSubjectService.findOne(id) == null) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        LecturerOnTheSubject result = lecturerOnTheSubjectService.save(lecturerOnTheSubject);
        return ResponseEntity
            .ok()
            .body(result);
    }
	
	
	@PostMapping()
	public ResponseEntity<LecturerOnTheSubject> save(@RequestBody LecturerOnTheSubject lecturerOnTheSubject){
		LecturerOnTheSubject newLecturerOnTheSubject = lecturerOnTheSubjectService.save(lecturerOnTheSubject);
		return ResponseEntity.status(201).body(newLecturerOnTheSubject);
	}
	
}
