package ftn.uns.eObrazovanje.service;

import java.util.List;

import ftn.uns.eObrazovanje.model.AttendingCourses;
import ftn.uns.eObrazovanje.model.Student;
import ftn.uns.eObrazovanje.model.DTO.StudentDTO;

public interface AttendingCourseService {
	
	 	List<AttendingCourses> findAll();

	    
	 	AttendingCourses findOne(Integer id);
	    
	  

}
