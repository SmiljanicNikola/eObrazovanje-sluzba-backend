package ftn.uns.eObrazovanje.service;

import java.util.List;

import ftn.uns.eObrazovanje.model.SubjectPerformance;

public interface SubjectPerformanceService {

	List<SubjectPerformance> findAll();
	
	SubjectPerformance save(SubjectPerformance subjectPerformance);
	
	SubjectPerformance findOne(Integer id);
	
	void remove(Integer id);
	
}
