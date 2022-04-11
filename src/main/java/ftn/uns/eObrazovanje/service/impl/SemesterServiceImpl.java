package ftn.uns.eObrazovanje.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.uns.eObrazovanje.model.Semester;
import ftn.uns.eObrazovanje.repository.SemesterRepo;
import ftn.uns.eObrazovanje.service.SemesterService;

@Service
public class SemesterServiceImpl implements SemesterService {
	
	@Autowired
	private SemesterRepo semesterRepo;

	@Override
	public List<Semester> findAll() {
		return semesterRepo.findAll();
	}

	@Override
	public Semester save(Semester semester) {
		semesterRepo.save(semester);
		return semester;
	}

	@Override
	public Semester findOne(Integer id) {
		return semesterRepo.findById(id).orElse(null);
	}

	@Override
	public void delete(Integer id) {
		semesterRepo.deleteById(id);
	}

	
	
}
