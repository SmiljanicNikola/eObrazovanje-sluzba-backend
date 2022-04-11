package ftn.uns.eObrazovanje.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
//	@Autowired
//	private JwtRequestFilter jwtRequestFilter;
	
	@Autowired
	@Lazy
	private AdminDetailsServiceImpl adminDetailsService;
	
	@Autowired
	@Lazy
	private StudentDetailsServiceImpl studentDetailsService;
	
	@Autowired
	@Lazy
	private LecturerDetailsServiceImpl lecturerDetailsService;
	
	@Autowired
	private JwtAuthenticationEntryPoint unauthorizedHandler;
	
	@Bean
	public AdminDetailsServiceImpl adminDetailsService() {
		return new AdminDetailsServiceImpl();
	}
	
	@Bean
	public StudentDetailsServiceImpl studentDetailsService() {
		return new StudentDetailsServiceImpl();
	}
	
	@Bean
	public LecturerDetailsServiceImpl lecturerDetailsService() {
		return new LecturerDetailsServiceImpl();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public JwtRequestFilter authenticationJwtTokenFilter() {
		return new JwtRequestFilter();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(adminDetailsService());
		authProvider.setUserDetailsService(studentDetailsService());
		authProvider.setUserDetailsService(lecturerDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
		auth.userDetailsService(adminDetailsService).passwordEncoder(passwordEncoder());
		auth.userDetailsService(studentDetailsService).passwordEncoder(passwordEncoder());
		auth.userDetailsService(lecturerDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
			.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.authorizeRequests().antMatchers("/api/auth/login").permitAll()
//			.antMatchers("/api/**").permitAll()
//			
//			.antMatchers(HttpMethod.POST, "/api/articles/new").hasAnyAuthority("SALESMEN","ADMIN")
//			.antMatchers(HttpMethod.POST, "/api/articles/addToCart").hasAnyAuthority("SALESMEN","ADMIN","BUYER")
//			.antMatchers(HttpMethod.PUT, "/api/articles/**").hasAnyAuthority( "SALESMEN","ADMIN")
//			.antMatchers(HttpMethod.DELETE, "/api/articles/**").hasAnyAuthority("SALESMEN","ADMIN")
			.anyRequest().authenticated();

		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers("/api/auth/login");
	}

}
