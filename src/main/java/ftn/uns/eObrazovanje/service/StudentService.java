package ftn.uns.eObrazovanje.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ftn.uns.eObrazovanje.model.Student;
import ftn.uns.eObrazovanje.model.DTO.StudentDTO;


public interface StudentService {
	
    Student findByUsernameAndPassword(String username, String password);

    List<Student> findAll();

    void add(Student student);
    
    Student findOne(Integer id);
    
    Student findByUsername(String username);
    
    void remove(Integer id);
    
    Student save(StudentDTO student);
    
    
    void uploadStudents(MultipartFile file);

}
