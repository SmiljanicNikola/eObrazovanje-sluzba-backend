package ftn.uns.eObrazovanje.service;

import java.util.List;

import ftn.uns.eObrazovanje.model.Admin;
import ftn.uns.eObrazovanje.model.Student;


public interface StudentService {
	
    Student findByUsernameAndPassword(String username, String password);

    List<Student> findAll();

    void add(Student student);
    
    Student findOne(Integer id);
    
    Student findByUsername(String username);
    
    void remove(Integer id);
    
    Student save(Student student);

}