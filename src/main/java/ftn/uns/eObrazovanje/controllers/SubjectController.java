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

import ftn.uns.eObrazovanje.model.Department;
import ftn.uns.eObrazovanje.model.Subject;
import ftn.uns.eObrazovanje.service.SubjectService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(value = "api/subjects")
public class SubjectController {

	@Autowired
	private SubjectService subSer;

	@GetMapping
	public ResponseEntity<List<Subject>> getSubjects() {
		List<Subject> subjects = subSer.findAll();

		return new ResponseEntity<>(subjects, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Subject> getSubject(@PathVariable("id") Integer id) {
		Subject subject = subSer.findOne(id);
		if (subject == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(subject, HttpStatus.OK);
	}

	@GetMapping(value = "/name/{name}")
	public ResponseEntity<Subject> getSubjectByName(@PathVariable("name") String name) {
		Subject subject = subSer.findByName(name);
		if (subject == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(subject, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<Subject> updateSubject(
        @PathVariable(value = "id", required = false) final Integer id,
        @RequestBody Subject subject
    ) throws URISyntaxException {
        if (subject.getId() == null) {
        	System.out.println("");
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!Objects.equals(id, subject.getId())) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (subSer.findOne(id) == null) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Subject result = subSer.save(subject);
        return ResponseEntity
            .ok()
            .body(result);
    }

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteSubject(@PathVariable("id") Integer id) {
		Subject subject = subSer.findOne(id);

		if (subject.isBlocked()) {
			subject.setBlocked(false);
			subSer.save(subject);

		} else {
			subject.setBlocked(true);
			subSer.save(subject);
			return new ResponseEntity<>(HttpStatus.OK);

		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping
	public void save(@RequestBody Subject subject) {
		subSer.save(subject);
	}

}
