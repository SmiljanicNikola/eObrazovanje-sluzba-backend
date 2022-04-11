package ftn.uns.eObrazovanje.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ftn.uns.eObrazovanje.model.Lecturer;
import ftn.uns.eObrazovanje.repository.LecturerRepo;

public class LecturerDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private LecturerRepo lecturerRepo;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Lecturer lecturer = lecturerRepo.findByUsername("profa");
		System.out.println("KIKIII"+username );
		return MyLecturerDetails.build(lecturer);
		
	}

}
