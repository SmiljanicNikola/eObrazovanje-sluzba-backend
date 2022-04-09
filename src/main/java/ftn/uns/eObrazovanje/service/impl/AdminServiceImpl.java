package ftn.uns.eObrazovanje.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.uns.eObrazovanje.model.Admin;
import ftn.uns.eObrazovanje.repository.AdminRepo;
import ftn.uns.eObrazovanje.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepo adminRepo;

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
	public Admin save(Admin admin) {
		return adminRepo.save(admin);
	}

}
