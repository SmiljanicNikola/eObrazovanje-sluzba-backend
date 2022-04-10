package ftn.uns.eObrazovanje.service;

import java.util.List;

import ftn.uns.eObrazovanje.model.TakingExam;

public interface TakingExamService {
	
	List<TakingExam> findAll();
	
	TakingExam save(TakingExam takingExam);
	
	TakingExam findOne(Integer id);
	
	void remove(Integer id);
	
}
