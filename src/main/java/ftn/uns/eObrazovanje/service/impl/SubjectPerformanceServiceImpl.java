package ftn.uns.eObrazovanje.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.uns.eObrazovanje.model.SubjectPerformance;
import ftn.uns.eObrazovanje.repository.SubjectPerformanceRepo;
import ftn.uns.eObrazovanje.service.SubjectPerformanceService;

@Service
public class SubjectPerformanceServiceImpl implements SubjectPerformanceService {
	
	@Autowired
	private SubjectPerformanceRepo repo;

	@Override
	public List<SubjectPerformance> findAll() {
		return repo.findAll();
	}

	@Override
	public SubjectPerformance save(SubjectPerformance subjectPerformance) {
		return repo.save(subjectPerformance);
	}

	@Override
	public SubjectPerformance findOne(Integer id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
