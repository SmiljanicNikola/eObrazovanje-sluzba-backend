package ftn.uns.eObrazovanje.controllers;

import java.net.URISyntaxException;
import java.util.List;

import ftn.uns.eObrazovanje.model.request.AddTakingExamRequest;
import ftn.uns.eObrazovanje.service.AttendingCoursesService;
import ftn.uns.eObrazovanje.service.LecturerService;
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

import ftn.uns.eObrazovanje.model.TakingExam;
import ftn.uns.eObrazovanje.service.TakingExamService;

@Controller
@RequestMapping(value = "api/taking-xams")
public class TakingExamController {

	@Autowired
	private TakingExamService takingExamService;

	@Autowired
	private LecturerService lecturerService;

	@Autowired
	private AttendingCoursesService attendingCoursesService;
	
//	@PostMapping
//	public ResponseEntity<TakingExam> save(@RequestBody TakingExam takingExam){
//		System.out.println(takingExam);
//		TakingExam newTakingExam = takingExamService.save(takingExam);
//		return ResponseEntity.status(201).body(newTakingExam);
//	}
	
	
	@GetMapping
	public ResponseEntity<List<TakingExam>> getTakingExams(){
	List<TakingExam> takingExams = takingExamService.findAllList();

		return new ResponseEntity<>(takingExams, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TakingExam> getTakingExam(@PathVariable("id") Integer id){
		TakingExam takingExam = takingExamService.findOne(id);
		if(takingExam == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(takingExam, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteTakingExam(@PathVariable("id") Integer id){
		TakingExam takingExam = takingExamService.findOne(id);
		
		if(!takingExam.isDeleted()) {
			takingExam.setDeleted(true);
			takingExamService.save(takingExam);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<TakingExam> updateTakingExam(
        @PathVariable(value = "id", required = false) final Integer id,
        @RequestBody TakingExam takingExam
    ) throws URISyntaxException {
        if (takingExamService.findOne(id) == null) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        TakingExam result = takingExamService.save(takingExam);
        return ResponseEntity
            .ok()
            .body(result);
    }
	

	@PostMapping
	public ResponseEntity<TakingExam> saveTakingExam(@RequestBody AddTakingExamRequest addTakingExamRequest){

		TakingExam takingExam = new TakingExam();
		takingExam.setGrade(addTakingExamRequest.getGrade());
		takingExam.setPassed(addTakingExamRequest.isPassed());
		takingExam.setLecturer(this.lecturerService.findOne(addTakingExamRequest.getLecturerId()));
		takingExam.setAttendingCourses(this.attendingCoursesService.findOne(addTakingExamRequest.getAttendingCoursesId()));
		takingExam.setDeleted(addTakingExamRequest.isDeleted());

		takingExam = takingExamService.save(takingExam);
		return new ResponseEntity<>(takingExam, HttpStatus.CREATED);

	}
	/*@PostMapping()
	public ResponseEntity<TakingExam> saveTakingExam(@RequestBody TakingExam addTakingExamRequest) {

		TakingExam takingExam = new TakingExam();
		takingExam.setGrade(addTakingExamRequest.getGrade());
		takingExam.setPassed(addTakingExamRequest.isPassed());
		takingExam.setLecturer((addTakingExamRequest.getLecturer()));
		takingExam.setAttendingCourses(addTakingExamRequest.getAttendingCourses());
		takingExam.setDeleted(addTakingExamRequest.isDeleted());

		takingExam = takingExamService.save(takingExam);
		return new ResponseEntity<>(takingExam, HttpStatus.CREATED);

		}*/
	}
