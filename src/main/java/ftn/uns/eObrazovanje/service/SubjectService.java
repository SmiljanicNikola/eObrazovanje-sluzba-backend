package ftn.uns.eObrazovanje.service;

import java.util.List;

import ftn.uns.eObrazovanje.model.Department;
import ftn.uns.eObrazovanje.model.Subject;

public interface SubjectService {
	
	List<Subject> findAll();

    void add(Subject subject);
    
    Subject findOne(Integer subjectId);
    
    Subject findByName(String name);
    
    void remove(Integer id);
    
    Subject save(Subject subject);

}
