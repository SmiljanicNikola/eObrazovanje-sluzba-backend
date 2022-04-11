package ftn.uns.eObrazovanje.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ftn.uns.eObrazovanje.model.Student;
import ftn.uns.eObrazovanje.repository.StudentRepo;

public class StudentDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private StudentRepo studentRepo;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Student student = studentRepo.findByUsername(username);
		return MyStudentDetails.build(student);
	}

	
}
