package ftn.uns.eObrazovanje.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.uns.eObrazovanje.model.Lecturer;
import ftn.uns.eObrazovanje.model.Student;
import ftn.uns.eObrazovanje.repository.LecturerRepo;
import ftn.uns.eObrazovanje.service.LecturerService;

@Service
public class LecturerServiceImpl implements LecturerService{

	@Autowired
	private LecturerRepo lecturerRepo;
	
	@Override
	public Lecturer findByUsernameAndPassword(String username, String password) {
		Lecturer lecturer = lecturerRepo.findByUsername(username);
		if(lecturer.getPassword().equals(password)) {
			return lecturer;
		}else {
			return null;
		}
	}

	@Override
	public List<Lecturer> findAll() {
		return lecturerRepo.findAll();
	}

	@Override
	public void add(Lecturer lecturer) {
		lecturerRepo.save(lecturer);
		
	}

	@Override
	public Lecturer findOne(Integer id) {
		return lecturerRepo.findById(id).orElse(null);
	}

	@Override
	public Lecturer findByUsername(String username) {
		return lecturerRepo.findByUsername(username);
	}

	@Override
	public void remove(Integer id) {
		lecturerRepo.deleteById(id);
		
	}

	@Override
	public Lecturer save(Lecturer lecturer) {
		return lecturerRepo.save(lecturer);
	}

}
