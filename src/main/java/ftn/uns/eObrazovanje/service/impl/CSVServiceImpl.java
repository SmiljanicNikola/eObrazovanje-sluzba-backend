package ftn.uns.eObrazovanje.service.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ftn.uns.eObrazovanje.model.CSVHelper;
import ftn.uns.eObrazovanje.model.User;
import ftn.uns.eObrazovanje.repository.UserRepo;


@Service
public class CSVServiceImpl {

	@Autowired
	UserRepo userRepo;
	
	public void save(MultipartFile file) throws Exception {
	    try {
	      List<User> users = ftn.uns.eObrazovanje.model.CSVHelper.csvToUsers(file.getInputStream());
	      userRepo.saveAll(users);
	    } catch (IOException e) {
	      throw new RuntimeException("fail to store csv data: " + e.getMessage());
	    }
	  }

	  public ByteArrayInputStream load() {
	    List<User> users = userRepo.findAll();

	    ByteArrayInputStream in = CSVHelper.usersToCSV(users);
	    return in;
	  }

	  public List<User> getAllUsers() {
	    return userRepo.findAll();
	  }

	
}
