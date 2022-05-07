package ftn.uns.eObrazovanje.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.uns.eObrazovanje.model.AttendingCourses;
import ftn.uns.eObrazovanje.model.DTO.AttendingCourseDTO;
import ftn.uns.eObrazovanje.repository.AttendingCourseRepo;
import ftn.uns.eObrazovanje.service.AttendingCoursesService;

@Service
public class AttendingCoursesServiceImpl implements AttendingCoursesService{
	
	@Autowired
	private AttendingCourseRepo courseRepo;

	@Override
	public AttendingCourses findByUsername(String username) {
		return courseRepo.findByUsername(username);
	}

	@Override
	public List<AttendingCourses> findAll() {
		return courseRepo.findAll();
	}

	@Override
	public void add(AttendingCourses attendingCourse) {
		courseRepo.save(attendingCourse);
	}

	@Override
	public AttendingCourses findOne(Integer id) {
		return courseRepo.findById(id).orElse(null);
	}

	@Override
	public void remove(Integer id) {
		courseRepo.deleteById(id);
	}

	@Override
	public AttendingCourses save(AttendingCourses course) {
		return courseRepo.save(course);
	}


}
