package ftn.uns.eObrazovanje.controllers;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.uns.eObrazovanje.model.AttendingCourses;
import ftn.uns.eObrazovanje.model.Student;
import ftn.uns.eObrazovanje.model.SubjectPerformance;
import ftn.uns.eObrazovanje.model.TakingExam;
import ftn.uns.eObrazovanje.model.User;
import ftn.uns.eObrazovanje.model.DTO.AttendingCourseDTO;
import ftn.uns.eObrazovanje.repository.AttendingCourseRepo;
import ftn.uns.eObrazovanje.service.AttendingCoursesService;
import ftn.uns.eObrazovanje.service.StudentService;
import ftn.uns.eObrazovanje.service.SubjectPerformanceService;
import ftn.uns.eObrazovanje.service.TakingExamService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(value = "api/attendingCourses")
public class AttendingCoursesController {
	
	@Autowired
	private AttendingCoursesService attendingCourseService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private SubjectPerformanceService subjectService;
	
	@Autowired
	private TakingExamService takingExamService;
	
	@GetMapping
	public ResponseEntity<List<AttendingCourses>> getCourses(){
		List<AttendingCourses> courses = attendingCourseService.findAll();

		return ResponseEntity.ok().body(courses);
	}

	@Transactional
	@GetMapping(value = "/student/{username}")
	public ResponseEntity<?> getCourseByUsername(@PathVariable("username") String username){
		Set<AttendingCourses> attendingCourse = attendingCourseService.findByUsername(username);
		Set<TakingExam> exams = takingExamService.findAll();
		
		Set<Object> s = new HashSet<Object>();

		s.addAll(attendingCourse);
		s.addAll(exams);
		return ResponseEntity.ok().body(exams);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AttendingCourses> getCourse(@PathVariable("id") Integer id){
		AttendingCourses course = attendingCourseService.findOne(id);
		
		return ResponseEntity.ok().body(course);
	}
	
	@PostMapping
	public ResponseEntity<AttendingCourses> saveCourse(@RequestBody AttendingCourseDTO course){
		Student student = studentService.findOne(course.getStudent());

		SubjectPerformance subject = subjectService.findOne(course.getSubjectPerformance());
		
		AttendingCourses newCourse = new AttendingCourses(student, subject);
		attendingCourseService.save(newCourse);
		return ResponseEntity.status(201).body(newCourse);    
	}
	
}
