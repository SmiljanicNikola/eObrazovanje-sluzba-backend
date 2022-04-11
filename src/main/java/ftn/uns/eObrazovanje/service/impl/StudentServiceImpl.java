package ftn.uns.eObrazovanje.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.uns.eObrazovanje.model.Student;
import ftn.uns.eObrazovanje.repository.StudentRepo;
import ftn.uns.eObrazovanje.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public Student findByUsernameAndPassword(String username, String password) {
		Student student = studentRepo.findByUsername(username);
		if(student.getPassword().equals(password)) {
			return student;
		}else {
			return null;
		}
	}

	@Override
	public List<Student> findAll() {
		return studentRepo.findAll();
	}

	@Override
	public void add(Student student) {
		studentRepo.save(student);
		
	}

	@Override
	public Student findOne(Integer id) {
		return studentRepo.findById(id).orElse(null);
	}

	@Override
	public Student findByUsername(String username) {
		return studentRepo.findByUsername(username);
	}

	@Override
	public void remove(Integer id) {
		studentRepo.deleteById(id);
		
	}

	@Override
	public Student save(Student student) {
		return studentRepo.save(student);
	}

}
