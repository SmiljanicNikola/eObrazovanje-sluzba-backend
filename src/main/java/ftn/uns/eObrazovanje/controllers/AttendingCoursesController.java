package ftn.uns.eObrazovanje.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.uns.eObrazovanje.model.AttendingCourses;
import ftn.uns.eObrazovanje.model.Student;
import ftn.uns.eObrazovanje.model.SubjectPerformance;
import ftn.uns.eObrazovanje.model.DTO.AttendingCourseDTO;
import ftn.uns.eObrazovanje.service.AttendingCoursesService;
import ftn.uns.eObrazovanje.service.StudentService;
import ftn.uns.eObrazovanje.service.SubjectPerformanceService;

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
	
	@GetMapping
	public ResponseEntity<List<AttendingCourses>> getCourses(){
		List<AttendingCourses> courses = attendingCourseService.findAll();

		return ResponseEntity.ok().body(courses);
	}

	@GetMapping(value = "/student/{username}")
	public ResponseEntity<List<AttendingCourses>> getCourseByUsername(@PathVariable("username") String username){
		List<AttendingCourses> attendingCourse = attendingCourseService.findByUsername(username);
		
		return ResponseEntity.ok().body(attendingCourse);
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
