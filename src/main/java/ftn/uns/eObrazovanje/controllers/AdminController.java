package ftn.uns.eObrazovanje.controllers;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.uns.eObrazovanje.model.Admin;
import ftn.uns.eObrazovanje.service.AdminService;

@RestController
@RequestMapping(value = "api/admins")
public class AdminController {
	
    @Autowired
    private AdminService adminService;
    
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	
	@GetMapping
	public ResponseEntity<List<Admin>> getAdmins(){
		List<Admin> admins = adminService.findAll();
		
		return new ResponseEntity<>(admins, HttpStatus.OK); 
	}
	
    @GetMapping(value = "/{id}")
    public ResponseEntity<Admin> getAdmin(@PathVariable("id") Integer id) {
        Admin admin = adminService.findOne(id);
        if (admin == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(admin, HttpStatus.OK);
    }
    
    @GetMapping(value = "/username/{username}")
    public ResponseEntity<Admin> getAdminByUsername(@PathVariable("username") String username) {
    	Admin admin = adminService.findByUsername(username);
        if (admin  == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(admin, HttpStatus.OK);
    }
    
	@PostMapping
	public void save(@RequestBody Admin admin) {
		adminService.save(admin);
	}
	
    @PutMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin(
        @PathVariable(value = "id", required = false) final Integer id,
        @RequestBody Admin admin
    ) throws URISyntaxException {
        if (admin.getId() == null) {
        	System.out.println("blaa");
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!Objects.equals(id, admin.getId())) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (adminService.findOne(id) == null) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Admin result = adminService.save(admin);
        return ResponseEntity
            .ok()
            .body(result);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteAdmin(@PathVariable("id") Integer id) {
        Admin admin = adminService.findOne(id);
        
        if (admin.isBlocked()) {
        	admin.setBlocked(false);
        	adminService.save(admin);


        } else {
        	admin.setBlocked(true);
        	adminService.save(admin);
            return new ResponseEntity<>(HttpStatus.OK);
        
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    

    
    

}
