package ftn.uns.eObrazovanje.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.uns.eObrazovanje.model.ExamDate;
import ftn.uns.eObrazovanje.repository.ExamDateRepo;
import ftn.uns.eObrazovanje.service.ExamDateService;

@Service
public class ExamDateServiceImpl implements ExamDateService {
	
	@Autowired
	private ExamDateRepo examDateRepo;

	@Override
	public List<ExamDate> findAll() {
		return examDateRepo.findAll();
	}

	@Override
	public ExamDate save(ExamDate examDate) {
		examDateRepo.save(examDate);
		return examDate;
	}

	@Override
	public ExamDate findOne(Integer id) {
		return examDateRepo.findById(id).orElse(null);
	}

	@Override
	public void remove(Integer id) {
		examDateRepo.deleteById(id);
	}

}
