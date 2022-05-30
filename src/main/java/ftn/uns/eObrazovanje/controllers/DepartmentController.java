package ftn.uns.eObrazovanje.controllers;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import ftn.uns.eObrazovanje.model.Department;
import ftn.uns.eObrazovanje.service.DepartmanService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "api/departments")
@CrossOrigin(origins = "http://localhost:4200")
public class DepartmentController {
	
	@Autowired
	private DepartmanService depServ;
	
	@GetMapping
	public ResponseEntity<List<Department>> getDepartments(){
		System.out.println("lavor");
		List<Department> departments = depServ.findAll();
		
		return new ResponseEntity<>(departments, HttpStatus.OK); 
	}
	
    @GetMapping(value = "/{id}")
    public ResponseEntity<Department> getDepartment(@PathVariable("id") Integer id) {
    	Department department = depServ.findOne(id);
        if (department == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(department, HttpStatus.OK);
    }
    
//    @GetMapping(value = "/name/{name}")
//    public ResponseEntity<Department> getDepartmentByName(@PathVariable("name") String name) {
//    	Department department = depServ.findByName(name);
//        if (department  == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        return new ResponseEntity<>(department, HttpStatus.OK);
//    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(
        @PathVariable(value = "id", required = false) final Integer id,
        @RequestBody Department department
    ) throws URISyntaxException {
        if (department.getId() == null) {
        	System.out.println("");
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!Objects.equals(id, department.getId())) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (depServ.findOne(id) == null) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Department result = depServ.save(department);
        return ResponseEntity
            .ok()
            .body(result);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable("id") Integer id) {
        Department department = depServ.findOne(id);
        
        if (department.isBlocked()) {
        	department.setBlocked(false);
        	depServ.save(department);


        } else {
        	department.setBlocked(true);
        	depServ.save(department);
            return new ResponseEntity<>(HttpStatus.OK);
        
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping
	public void save(@RequestBody Department department) {
		depServ.save(department);
	}

}
