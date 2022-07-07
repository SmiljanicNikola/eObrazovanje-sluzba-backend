package ftn.uns.eObrazovanje.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ftn.uns.eObrazovanje.model.Admin;
import ftn.uns.eObrazovanje.model.Lecturer;
import ftn.uns.eObrazovanje.model.Role;
import ftn.uns.eObrazovanje.model.Student;
import ftn.uns.eObrazovanje.model.User;
import ftn.uns.eObrazovanje.model.DTO.LecturerDTO;
import ftn.uns.eObrazovanje.repository.LecturerRepo;
import ftn.uns.eObrazovanje.repository.RoleMainRepo;
import ftn.uns.eObrazovanje.repository.UserRepo;
import ftn.uns.eObrazovanje.service.LecturerService;

@Service
public class LecturerServiceImpl implements LecturerService{

	@Autowired
	private LecturerRepo lecturerRepo;
	
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RoleMainRepo roleRepo;
	
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
	public Lecturer save(LecturerDTO lecturer) {
		
		
		User user = userRepo.findByUsername(lecturer.getUsername());
		if(user == null) {
		user = new User(lecturer.getFirstname(), lecturer.getLastname(), lecturer.getUsername(), encoder.encode(lecturer.getPassword()),lecturer.getAdress(), lecturer.getJmbg(),false);
		Set<Role> role = new HashSet<>();
		Role role1 = roleRepo.findByName("LECTURER");
		role.add(role1);
		user.setRoles(role);
		userRepo.save(user);
		}
		
		
		Lecturer lect = lecturerRepo.findByUsername(lecturer.getUsername());
		if(lect == null) {
		lect = new Lecturer(lecturer.getUsername(), lecturer.getFirstname(), lecturer.getLastname(), encoder.encode(lecturer.getPassword()),
				lecturer.getJmbg(), lecturer.getAdress(),lecturer.getPay(),false);
		}
		return lecturerRepo.save(lect);
	}

}
