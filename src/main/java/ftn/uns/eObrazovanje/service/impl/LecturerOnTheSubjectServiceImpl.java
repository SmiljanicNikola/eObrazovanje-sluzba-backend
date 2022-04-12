package ftn.uns.eObrazovanje.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.uns.eObrazovanje.model.LecturerOnTheSubject;
import ftn.uns.eObrazovanje.repository.LecturerOnTheSubjectRepo;
import ftn.uns.eObrazovanje.service.LecturerOnTheSubjectService;

@Service
public class LecturerOnTheSubjectServiceImpl implements LecturerOnTheSubjectService {
	
	@Autowired
	private LecturerOnTheSubjectRepo lecturerOnTheSubjectRepo;

	@Override
	public List<LecturerOnTheSubject> findAll() {
		return lecturerOnTheSubjectRepo.findAll();
	}

	@Override
	public LecturerOnTheSubject findOne(Integer id) {
		return lecturerOnTheSubjectRepo.findById(id).orElse(null);
	}

	@Override
	public void delete(Integer id) {
		lecturerOnTheSubjectRepo.deleteById(id);
	}

	@Override
	public LecturerOnTheSubject save(LecturerOnTheSubject lecturerOnTheSubject) {
		return lecturerOnTheSubjectRepo.save(lecturerOnTheSubject);
	}

}
