package ftn.uns.eObrazovanje.service.impl;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ftn.uns.eObrazovanje.helper.CSVHelper;
import ftn.uns.eObrazovanje.model.Account;
import ftn.uns.eObrazovanje.model.Role;
import ftn.uns.eObrazovanje.model.Student;
import ftn.uns.eObrazovanje.model.StudentHistory;
import ftn.uns.eObrazovanje.model.User;
import ftn.uns.eObrazovanje.model.DTO.StudentDTO;
import ftn.uns.eObrazovanje.repository.AccountRepo;
import ftn.uns.eObrazovanje.repository.RoleMainRepo;
import ftn.uns.eObrazovanje.repository.RoleRepo;
import ftn.uns.eObrazovanje.repository.StudentHistoryRepo;
import ftn.uns.eObrazovanje.repository.StudentRepo;
import ftn.uns.eObrazovanje.repository.UserRepo;
import ftn.uns.eObrazovanje.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RoleMainRepo roleRepo;
	
	@Autowired
	private AccountRepo accRepo;
	
	@Autowired
	private StudentHistoryRepo historyRepo;
	
	@Autowired
	private CSVHelper CSVHelper;
	
	@Autowired
	PasswordEncoder encoder;

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
	public Student save(StudentDTO student) {
		
		Account account = new Account((float) 0,false);
		
		accRepo.save(account);
		
		
		StudentHistory history = new StudentHistory(LocalDate.now(),1);
		
		historyRepo.save(history);
		
		
		
		User user = new User(student.getFirstname(), student.getLastname(), student.getUsername(), encoder.encode(student.getPassword()),student.getAdress(), student.getJmbg(),false);
		Set<Role> role = new HashSet<>();
		Role role1 = roleRepo.findByName("STUDENT");
		role.add(role1);
		user.setRoles(role);
		
		userRepo.save(user);
		
		Student st = new Student(student.getUsername(), student.getFirstname(), student.getLastname(), encoder.encode(student.getPassword()),
				student.getJmbg(), student.getAdress(),
				student.getIndexNumber(), account, history,false);
		
		
		return studentRepo.save(st);
	}

	@Override
	public void uploadStudents(MultipartFile file) {
		try {
			
		      List<Student> students = CSVHelper.csvToStudents(file.getInputStream());
		      studentRepo.saveAll(students);
		    } catch (IOException e) {
		      throw new RuntimeException("fail to store csv data: " + e.getMessage());
		    }
	}
}
