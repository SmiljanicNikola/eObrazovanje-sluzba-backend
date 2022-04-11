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
import ftn.uns.eObrazovanje.model.request.LoginRequest;
import ftn.uns.eObrazovanje.repository.AdminRepo;
import ftn.uns.eObrazovanje.repository.LecturerRepo;
import ftn.uns.eObrazovanje.repository.StudentRepo;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/auth")
public class JwtAuthenticationController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@Autowired
	private AdminRepo adminRepo;
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private LecturerRepo lecturerRepo;
	
	@Autowired
	private AdminDetailsServiceImpl adminDetailsImpl;
	
	@Autowired
	private StudentDetailsServiceImpl studentDetailsImpl;
	
//	@Autowired
//	private LecturerDetailsServiceImpl lecturerDetailsImpl;
	
	@Autowired
	PasswordEncoder encoder;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest){
		
		Admin admin = adminRepo.findByUsername(loginRequest.getUsername());
		
		if(!admin.isBlocked()) {
			
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
			System.out.println("EVO NECEGA" + loginRequest.getPassword());
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			MyAdminDetails adminDetails =  (MyAdminDetails) authentication.getPrincipal();
			
			String jwt = jwtTokenUtil.generateToken(adminDetails);
			

			List<String> roles = adminDetails.getAuthorities().stream()
					.map(item -> item.getAuthority())
					.collect(Collectors.toList());
			
			
			return ResponseEntity.ok(new JwtResponse(jwt, 
					adminDetails.getId(), 
					adminDetails.getUsername(), 
					 roles));
		}else {
			return (ResponseEntity<?>) ResponseEntity.badRequest();
		}


	}

}
