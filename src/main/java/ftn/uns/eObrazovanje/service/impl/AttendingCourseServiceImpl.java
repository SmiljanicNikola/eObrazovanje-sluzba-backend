package ftn.uns.eObrazovanje.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.uns.eObrazovanje.model.AttendingCourses;
import ftn.uns.eObrazovanje.repository.AttendingCourseRepo;
import ftn.uns.eObrazovanje.service.AttendingCourseService;

@Service
public class AttendingCourseServiceImpl implements AttendingCourseService {

	@Autowired
	AttendingCourseRepo attendingCourseRepo;
	
	@Override
	public List<AttendingCourses> findAll() {
		return attendingCourseRepo.findAll();
	}

	@Override
	public AttendingCourses findOne(Integer id) {
		return attendingCourseRepo.findById(id).orElse(null);
	}

}
