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

import ftn.uns.eObrazovanje.model.Student;
import ftn.uns.eObrazovanje.model.DTO.StudentDTO;
import ftn.uns.eObrazovanje.service.StudentService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(value = "api/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public ResponseEntity<List<Student>> getStudents(){
		List<Student> students = studentService.findAll();
		
		return ResponseEntity.ok().body(students); 
	}
	
    @GetMapping(value = "/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") Integer id) {
    	Student student = studentService.findOne(id);
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(student, HttpStatus.OK);
    }
    
    @GetMapping(value = "/username/{username}")
    public ResponseEntity<Student> getStudentByUsername(@PathVariable("username") String username) {
    	Student student = studentService.findByUsername(username);
        if (student  == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(student, HttpStatus.OK);
    }
    
	@PostMapping
	public void save(@RequestBody StudentDTO studentDto) {
		studentService.save(studentDto);
	}
	
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(
        @PathVariable(value = "id", required = false) final Integer id,
        @RequestBody Student student
    ) throws URISyntaxException {
        if (student.getStudent_id() == null) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!Objects.equals(id, student.getStudent_id())) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (studentService.findOne(id) == null) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        studentService.add(student);
        return ResponseEntity
            .ok().body(student);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") Integer id) {
        Student student = studentService.findOne(id);
        
        if (student.isBlocked()) {
        	student.setBlocked(false);
        	studentService.add(student);


        } else {
        	student.setBlocked(true);
        	studentService.add(student);
            return new ResponseEntity<>(HttpStatus.OK);
        
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
