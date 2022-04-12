package ftn.uns.eObrazovanje.service;

import java.util.List;

import ftn.uns.eObrazovanje.model.LecturerOnTheSubject;

public interface LecturerOnTheSubjectService {

	List<LecturerOnTheSubject> findAll();
	
	LecturerOnTheSubject findOne(Integer id);
	
	void delete(Integer id);
	
	LecturerOnTheSubject save(LecturerOnTheSubject lecturerOnTheSubject);
	
}
