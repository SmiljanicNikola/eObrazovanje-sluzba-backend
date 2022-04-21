package ftn.uns.eObrazovanje.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ftn.uns.eObrazovanje.model.Admin;
import ftn.uns.eObrazovanje.model.Role;
import ftn.uns.eObrazovanje.model.Student;
import ftn.uns.eObrazovanje.model.User;
import ftn.uns.eObrazovanje.model.DTO.AdminDTO;
import ftn.uns.eObrazovanje.repository.AdminRepo;
import ftn.uns.eObrazovanje.repository.RoleMainRepo;
import ftn.uns.eObrazovanje.repository.UserRepo;
import ftn.uns.eObrazovanje.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepo adminRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RoleMainRepo roleRepo;
    
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public Admin findByUsernameAndPassword(String username, String password) {
		Admin admin = adminRepo.findByUsername(username);
		if(admin.getPassword().equals(password)) {
			return admin;
		}else {
			return null;
		}
		
	}

	@Override
	public List<Admin> findAll() {
		return adminRepo.findAll();
	}

	@Override
	public void add(Admin admin) {
		adminRepo.save(admin);
		
	}

	@Override
	public Admin findOne(Integer userId) {
		return adminRepo.findById(userId).orElse(null);
	}

	@Override
	public Admin findByUsername(String username) {
		return adminRepo.findByUsername(username);
	}

	@Override
	public void remove(Integer id) {
		adminRepo.deleteById(id);
		
	}

	@Override
	public Admin save(AdminDTO admin) {
		
		User user = new User(admin.getFirstname(), admin.getLastname(), admin.getUsername(), encoder.encode(admin.getPassword()),admin.getAdress(), admin.getJmbg(),false);
		Set<Role> role = new HashSet<>();
		Role role1 = roleRepo.findByName("ADMIN");
		role.add(role1);
		user.setRoles(role);
		
		userRepo.save(user);
		
		Admin adminn = new Admin(admin.getUsername(), admin.getFirstname(), admin.getLastname(), encoder.encode(admin.getPassword()),
				admin.getJmbg(), admin.getAdress(),false);
		
		return adminRepo.save(adminn);
	}

}
