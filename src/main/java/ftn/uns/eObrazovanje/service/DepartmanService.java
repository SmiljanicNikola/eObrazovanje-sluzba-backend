package ftn.uns.eObrazovanje.service;

import java.util.List;

import ftn.uns.eObrazovanje.model.Department;


public interface DepartmanService {

    List<Department> findAll();

    void add(Department department);
    
    Department findOne(Integer departmenId);
    
    void remove(Integer id);
    
    Department save(Department department);

}
