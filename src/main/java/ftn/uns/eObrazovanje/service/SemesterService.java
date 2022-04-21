package ftn.uns.eObrazovanje.service;

import java.util.List;

import ftn.uns.eObrazovanje.model.Semester;

public interface SemesterService {
	
	List<Semester> findAll();
	
	Semester save(Semester semeseter);
	
	Semester findOne(Integer id);
	
	void delete(Integer id);

}
