package ftn.uns.eObrazovanje.service;

import java.util.List;

import ftn.uns.eObrazovanje.model.ExamDate;

public interface ExamDateService {
	
	List<ExamDate> findAll();
	
	ExamDate save(ExamDate examDate);
	
	ExamDate findOne(Integer id);
	
	void remove(Integer id);

}
