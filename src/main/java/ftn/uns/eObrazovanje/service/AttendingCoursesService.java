package ftn.uns.eObrazovanje.service;

import java.util.List;
import java.util.Set;

import ftn.uns.eObrazovanje.model.AttendingCourses;
import ftn.uns.eObrazovanje.model.Student;
import ftn.uns.eObrazovanje.model.DTO.AttendingCourseDTO;
import ftn.uns.eObrazovanje.model.DTO.StudentDTO;

public interface AttendingCoursesService {
	
	Set<AttendingCourses> findByUsername(String username);

    List<AttendingCourses> findAll();

    void add(AttendingCourses attendingCourse);
    
    AttendingCourses findOne(Integer id);
    List<Student> getStudents(Integer courseID);
    
    void remove(Integer id);
    
    AttendingCourses save(AttendingCourses attendingCourses);

}
