package ftn.uns.eObrazovanje.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.uns.eObrazovanje.model.Subject;
import ftn.uns.eObrazovanje.repository.SubjectRepo;
import ftn.uns.eObrazovanje.service.SubjectService;
@Service
public class SubjectServiceImpl implements SubjectService{

	@Autowired
	private SubjectRepo subRep;

	@Override
	public List<Subject> findAll() {
		return subRep.findAll();
	}

	@Override
	public void add(Subject subject) {
		subRep.save(subject);
		
	}

	@Override
	public Subject findOne(Integer subjectId) {
		return subRep.findById(subjectId).orElse(null);
	}

	@Override
	public Subject findByName(String name) {
		return subRep.findByName(name);
	}

	@Override
	public void remove(Integer id) {
		subRep.deleteById(id);
		
	}

	@Override
	public Subject save(Subject subject) {
		return subRep.save(subject);
	}
	
	
}
