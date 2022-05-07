package ftn.uns.eObrazovanje.service;

import java.util.List;

import ftn.uns.eObrazovanje.model.AttendingCourses;
import ftn.uns.eObrazovanje.model.Student;
import ftn.uns.eObrazovanje.model.DTO.AttendingCourseDTO;
import ftn.uns.eObrazovanje.model.DTO.StudentDTO;

public interface AttendingCoursesService {
	
    AttendingCourses findByUsername(String username);

    List<AttendingCourses> findAll();

    void add(AttendingCourses attendingCourse);
    
    AttendingCourses findOne(Integer id);
    
    void remove(Integer id);
    
    AttendingCourses save(AttendingCourses attendingCourses);

}
