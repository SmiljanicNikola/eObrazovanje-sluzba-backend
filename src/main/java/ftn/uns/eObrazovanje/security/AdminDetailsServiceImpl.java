package ftn.uns.eObrazovanje.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ftn.uns.eObrazovanje.model.Admin;
import ftn.uns.eObrazovanje.repository.AdminRepo;

public class AdminDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private AdminRepo adminRepo;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Admin admin = adminRepo.findByUsername(username);
		return MyAdminDetails.build(admin);
	}

}
