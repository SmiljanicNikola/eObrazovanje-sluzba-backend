package ftn.uns.eObrazovanje.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.uns.eObrazovanje.model.Account;
import ftn.uns.eObrazovanje.service.AccountService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "api/accounts")
public class AccountController {

	@Autowired
	private AccountService accSer;

	@GetMapping
	public ResponseEntity<List<Account>> getAccounts() {
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

	@GetMapping(value = "student/{id}")
	public ResponseEntity<Account> getAccountByStudentId(@PathVariable("id") Integer id) {
		List<Account> accounts = accSer.findAll();
		Account odgovarajuciAccount = new Account();
		for(Account account : accounts) {
			if (account.getStudent().getStudent_id() == id) {
				if (account == null) {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
				odgovarajuciAccount = account;
			}
		}
		return new ResponseEntity<>(odgovarajuciAccount, HttpStatus.OK);
	}

	@PostMapping
	public void save(@RequestBody Account account) {
		accSer.save(account);
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
	}

}
