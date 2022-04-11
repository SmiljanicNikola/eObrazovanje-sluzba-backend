package ftn.uns.eObrazovanje.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import ftn.uns.eObrazovanje.model.Admin;
import ftn.uns.eObrazovanje.model.Lecturer;
import ftn.uns.eObrazovanje.model.Student;
import ftn.uns.eObrazovanje.repository.AdminRepo;
import ftn.uns.eObrazovanje.repository.LecturerRepo;
import ftn.uns.eObrazovanje.repository.StudentRepo;
import io.jsonwebtoken.ExpiredJwtException;
@Component
public class JwtRequestFilter extends OncePerRequestFilter{

	@Autowired
	private AdminDetailsServiceImpl adminDetailsService;
	
	@Autowired
	private StudentDetailsServiceImpl studentDetailsService;
	
	@Autowired
	private LecturerDetailsServiceImpl lecturerDetailsService;
	
	@Autowired
	private AdminRepo adminRepo;

	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private LecturerRepo lecturerRepo;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		
		final String requestTokenHeader = request.getHeader("Authorization");
		String username = null;
		String jwtToken = null;
		
		
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);
			try {
				username = jwtTokenUtil.getUsernameFromToken(jwtToken);
			} catch (IllegalArgumentException e) {
				System.out.println("Unable to get JWT Token");
			} catch (ExpiredJwtException e) {
				System.out.println("JWT Token has expired");
			}
		} else {
			logger.warn("JWT Token does not begin with Bearer Stringg");
		}
		
		try {
			System.out.println(adminRepo.findByUsername(username));
			if(adminRepo.findByUsername(username) != null) {
				Admin admin = adminRepo.findByUsername(username);
				
				if (admin != null && username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
					System.out.println("EVO GA JWTREQUESTFILTER80" + username);
					UserDetails userDetails = this.adminDetailsService.loadUserByUsername(username);
					
					if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
						UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
								userDetails, null, userDetails.getAuthorities());
						usernamePasswordAuthenticationToken
								.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

						SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
					}
			}else if(studentRepo.findByUsername(username) != null) {
				Student student = studentRepo.findByUsername(username);
				if(student != null && username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
					System.out.println("EVO GA JWTREQUESTFILTER92"+ username);
					UserDetails userDetails = this.studentDetailsService.loadUserByUsername(username);
					
					if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
						UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
								userDetails, null, userDetails.getAuthorities());
						usernamePasswordAuthenticationToken
								.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

						SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
					}
				}
			}else if(lecturerRepo.findByUsername(username) != null) {
				Lecturer lecturer = lecturerRepo.findByUsername(username);
				
				if(lecturer != null && username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
					System.out.println("EVO GA JWTREQUESTFILTER104"+ username);
					UserDetails userDetails = this.lecturerDetailsService.loadUserByUsername(username);
					
					if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
						UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
								userDetails, null, userDetails.getAuthorities());
						usernamePasswordAuthenticationToken
								.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

						SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
					}
				}
			}
		}
			chain.doFilter(request, response);
		}catch(Exception e) {
			System.out.println("NEMA");
		}
		

		
		
		
		

	}


}
