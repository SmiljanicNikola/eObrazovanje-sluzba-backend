package ftn.uns.eObrazovanje.service.impl;

import java.util.List;
import java.util.Set;

import ftn.uns.eObrazovanje.repository.TakingExamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.uns.eObrazovanje.model.TakingExam;
import ftn.uns.eObrazovanje.service.TakingExamService;

@Service
public class TakingExamServiceImpl implements TakingExamService{

	@Autowired
	private TakingExamRepo takingExamRepo;

	@Override
	public Set<TakingExam> findAll() {
		return takingExamRepo.find();
	}

	@Override
	public List<TakingExam> findAllList() {
		return takingExamRepo.findAll();
	}

	@Override
	public TakingExam save(TakingExam takingExam) {
		takingExamRepo.save(takingExam);
		return takingExam;
	}

	@Override
	public TakingExam findOne(Integer id) {
		return takingExamRepo.findById(id).orElse(null);
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
	}
	
	

}
