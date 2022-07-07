package ftn.uns.eObrazovanje.security;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.uns.eObrazovanje.model.Admin;
import ftn.uns.eObrazovanje.model.User;
import ftn.uns.eObrazovanje.model.request.LoginRequest;
import ftn.uns.eObrazovanje.repository.AdminRepo;
import ftn.uns.eObrazovanje.repository.LecturerRepo;
import ftn.uns.eObrazovanje.repository.RoleMainRepo;
import ftn.uns.eObrazovanje.repository.RoleRepo;
import ftn.uns.eObrazovanje.repository.StudentRepo;
import ftn.uns.eObrazovanje.repository.UserRepo;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/auth")
public class JwtAuthenticationController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@Autowired
	RoleMainRepo roleRepository;
	
	@Autowired
	private UserRepo userRepository;
	
	@Autowired
	private AdminRepo adminRepository;
	
	@Autowired
	private StudentRepo studentRepository;
	
	@Autowired
	private LecturerRepo lecturerRepository;
	
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	PasswordEncoder encoder;

	
	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest){
		
		User user = userRepository.findByUsername(loginRequest.getUsername());
		if ( user == null ) 
			return (ResponseEntity<?>) ResponseEntity.badRequest();
		if(!user.isBlocked()) {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			MyUserDetails userDetails =  (MyUserDetails) authentication.getPrincipal();
			System.out.println(user);
			String jwt = jwtTokenUtil.generateToken(userDetails);
			

			List<String> roles = userDetails.getAuthorities().stream()
					.map(item -> item.getAuthority())
					.collect(Collectors.toList());
			
			
			return ResponseEntity.ok(new JwtResponse(jwt, 
					 userDetails.getId(), 
					 userDetails.getUsername(), 
					 roles));
		}else {
			return (ResponseEntity<?>) ResponseEntity.badRequest();
		}


}

}
