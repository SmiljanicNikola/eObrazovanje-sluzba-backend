package ftn.uns.eObrazovanje.security;

import javax.transaction.Transactional;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.OSA.OSA.model.entity.User;
//import com.OSA.OSA.repository.UserRepo;
//import com.OSA.OSA.security.MyUserDetails;

//@Service
//public class UserDetailsService implements UserDetailsService{
//
//	@Autowired
//	private UserRepo userRepository;
//	
//	
//	@Override
//	@Transactional
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = userRepository.findByUsername(username);
//		return MyUserDetails.build(user);
//	}
//	
//}
