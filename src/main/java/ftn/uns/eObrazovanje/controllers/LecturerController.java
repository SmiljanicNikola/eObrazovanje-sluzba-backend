package ftn.uns.eObrazovanje.controllers;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

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

import ftn.uns.eObrazovanje.model.Lecturer;
import ftn.uns.eObrazovanje.model.Student;
import ftn.uns.eObrazovanje.service.LecturerService;

@RestController
@RequestMapping(value = "api/lecturers")
public class LecturerController {
	
	@Autowired
	private LecturerService lecturerService;
	
	@GetMapping
	public ResponseEntity<List<Lecturer>> getLecturers(){
		List<Lecturer> lecturers = lecturerService.findAll();
		
		return ResponseEntity.ok().body(lecturers);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Lecturer> getLecturer(@PathVariable("id") Integer id){
		Lecturer lecturer = lecturerService.findOne(id);
		
		return ResponseEntity.ok().body(lecturer);
	}
	
	@GetMapping(value = "/username/{username}")
	public ResponseEntity<Lecturer> getLecturerByUsername(@PathVariable("username") String username){
		Lecturer lecturer = lecturerService.findByUsername(username);
		
		return ResponseEntity.ok().body(lecturer);
	}
	
	@PostMapping
	public ResponseEntity<Lecturer> saveLecturer(@RequestBody Lecturer lecturer){
		Lecturer lecturerNew = lecturerService.save(lecturer);
		return ResponseEntity.status(201).body(lecturerNew);
	}
	
    @PutMapping("/{id}")
    public ResponseEntity<Lecturer> updateLecturer(
        @PathVariable(value = "id", required = false) final Integer id,
        @RequestBody Lecturer lecturer
    ) throws URISyntaxException {
        if (lecturer.getLecturer_Id() == null) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!Objects.equals(id, lecturer.getLecturer_Id())) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (lecturerService.findOne(id) == null) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Lecturer result = lecturerService.save(lecturer);
        return ResponseEntity
            .ok()
            .body(result);
    }
    
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteLecturer(@PathVariable("id") Integer id) {
        Lecturer lecturer = lecturerService.findOne(id);
        
        if (lecturer.isBlocked()) {
        	lecturer.setBlocked(false);
        	lecturerService.save(lecturer);


        } else {
        	lecturer.setBlocked(true);
        	lecturerService.save(lecturer);
            return new ResponseEntity<>(HttpStatus.OK);
        
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
	

}
