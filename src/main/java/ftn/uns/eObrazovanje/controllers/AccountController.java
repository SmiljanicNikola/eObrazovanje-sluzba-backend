package ftn.uns.eObrazovanje.controllers;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.uns.eObrazovanje.model.Account;
import ftn.uns.eObrazovanje.model.Admin;
import ftn.uns.eObrazovanje.model.Subject;
import ftn.uns.eObrazovanje.service.AccountService;

@RestController
@RequestMapping(value ="api/account")
public class AccountController {
	
	@Autowired
	private AccountService accSer;
	
	
	/*@GetMapping
	public ResponseEntity<List<Account>> getAccounts(){
		List<Account> account = accSer.findAll();
		
		return new ResponseEntity<>(account, HttpStatus.OK); 
	}
	
    @GetMapping(value = "/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable("id") Integer id) {
    	Account account = accSer.findOne(id);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(account, HttpStatus.OK);
    }
    
    @PostMapping
	public void save(@RequestBody Account account) {
		accSer.save(account);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(
        @PathVariable(value = "id", required = false) final Integer id,
        @RequestBody Account account
    ) throws URISyntaxException {
        if (account.getId() == null) {
        	System.out.println("");
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!Objects.equals(id, account.getId())) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (subSer.findOne(id) == null) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Account result = subSer.save(account);
        return ResponseEntity
            .ok()
            .body(result);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable("id") Integer id) {
        Account account = accSer.findOne(id);
        
        if (account.isBlocked()) {
        	account.setBlocked(false);
        	accSer.save(account);


        } else {
        	account.setBlocked(true);
        	accSer.save(account);
            return new ResponseEntity<>(HttpStatus.OK);
        
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }*/

}
