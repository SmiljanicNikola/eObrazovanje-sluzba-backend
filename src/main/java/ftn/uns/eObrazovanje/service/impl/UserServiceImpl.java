package ftn.uns.eObrazovanje.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.uns.eObrazovanje.model.User;
import ftn.uns.eObrazovanje.repository.UserRepo;
import ftn.uns.eObrazovanje.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		User user = userRepo.findByUsername(username);
		if(user.getPassword().equals(password)) {
			return user;
		}else {
			return null;
		}
	}

	@Override
	public List<User> findAll() {
		return userRepo.findAll();
	}

	@Override
	public void add(User user) {
		userRepo.save(user);
	}

	@Override
	public User findOne(Integer userId) {
		return userRepo.findById(userId).orElse(null); 
	}

	@Override
	public User findByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	@Override
	public void remove(Integer id) {
		userRepo.deleteById(id);
	}

	@Override
	public User save(User user) {
		return userRepo.save(user);
	}

}
