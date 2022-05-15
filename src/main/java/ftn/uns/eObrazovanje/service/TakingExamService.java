package ftn.uns.eObrazovanje.service;

import java.util.List;
import java.util.Set;

import ftn.uns.eObrazovanje.model.TakingExam;

public interface TakingExamService {
	
	Set<TakingExam> findAll();

	List<TakingExam> findAllList();
	
	TakingExam save(TakingExam takingExam);
	
	TakingExam findOne(Integer id);
	
	void remove(Integer id);
	
}
