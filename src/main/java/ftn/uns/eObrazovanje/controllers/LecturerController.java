package ftn.uns.eObrazovanje.controllers;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

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

import ftn.uns.eObrazovanje.model.Lecturer;
import ftn.uns.eObrazovanje.model.Student;
import ftn.uns.eObrazovanje.model.User;
import ftn.uns.eObrazovanje.model.DTO.LecturerDTO;
import ftn.uns.eObrazovanje.repository.UserRepo;
import ftn.uns.eObrazovanje.service.LecturerService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(value = "api/lecturers")
public class LecturerController {
	
	@Autowired
	private LecturerService lecturerService;
	
	@Autowired
	private UserRepo userRepo;
	
	
	
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
        if (lecturer  == null) {
        	System.out.println("NISMO GA NASLI");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
		return ResponseEntity.ok().body(lecturer);
	}
	
	@PostMapping
	public ResponseEntity<Lecturer> saveLecturer(@RequestBody LecturerDTO lecturer){
		System.out.println(lecturer);
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
        
        User user =userRepo.findByUsername(lecturer.getUsername());
        
        user.setName(lecturer.getName());
        user.setSurname(lecturer.getSurname());
        user.setUsername(lecturer.getUsername());
        user.setAddress(lecturer.getAddress());
        user.setPassword(lecturer.getPassword());
        user.setBlocked(lecturer.isBlocked());
        user.setJmbg(lecturer.getJmbg());
        
        userRepo.save(user);

        lecturerService.add(lecturer);
        return ResponseEntity
            .ok()
            .body(lecturer);
    }
    
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteLecturer(@PathVariable("id") Integer id) {
        Lecturer lecturer = lecturerService.findOne(id);
        
        if (lecturer.isBlocked()) {
        	lecturer.setBlocked(false);
        	lecturerService.add(lecturer);


        } else {
        	lecturer.setBlocked(true);
        	lecturerService.add(lecturer);
            return new ResponseEntity<>(HttpStatus.OK);
        
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
	

}
