package ftn.uns.eObrazovanje.controllers;

import java.net.URISyntaxException;
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

import ftn.uns.eObrazovanje.model.Semester;
import ftn.uns.eObrazovanje.service.SemesterService;

@Controller
@RequestMapping(value = "api/semester")
public class SemesterController {

	@Autowired
	private SemesterService semesterService;

	@GetMapping
	public ResponseEntity<List<Semester>> getSemesters() {
		List<Semester> semesters = semesterService.findAll();

		return new ResponseEntity<>(semesters, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Semester> getSemesters(@PathVariable("id") Integer id) {
		Semester semester = semesterService.findOne(id);
		if (semester == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(semester, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteSemester(@PathVariable("id") Integer id) {
		Semester semester = semesterService.findOne(id);

		if (!semester.isDeleted()) {
			semester.setDeleted(true);
			semesterService.save(semester);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Semester> updateSemester(@PathVariable(value = "id", required = false) final Integer id,
			@RequestBody Semester semester) throws URISyntaxException {
		if (semesterService.findOne(id) == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Semester result = semesterService.save(semester);
		return ResponseEntity.ok().body(result);
	}

	@PostMapping()
	public ResponseEntity<Semester> save(@RequestBody Semester semester) {
		Semester newSemester = semesterService.save(semester);
		return ResponseEntity.status(201).body(newSemester);
	}
}
