package ftn.uns.eObrazovanje.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ftn.uns.eObrazovanje.model.SubjectPerformance;
import ftn.uns.eObrazovanje.service.SubjectPerformanceService;


@Controller
@CrossOrigin("*")
@RequestMapping(value = "api/subject-performance")
public class SubjectPerformanceController {
	
	@Autowired
	private SubjectPerformanceService subjectPerformanceService;
	
	@GetMapping
	public ResponseEntity<List<SubjectPerformance>> getSubjectPerformances() {
		List<SubjectPerformance> subjectsPer = subjectPerformanceService.findAll();

		return new ResponseEntity<>(subjectsPer, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<SubjectPerformance> getSubjectPerformance(@PathVariable("id") Integer id) {
		SubjectPerformance subjectPer = subjectPerformanceService.findOne(id);
		if (subjectPer == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(subjectPer, HttpStatus.OK);
	}

}
