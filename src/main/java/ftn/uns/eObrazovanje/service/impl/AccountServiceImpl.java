package ftn.uns.eObrazovanje.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.uns.eObrazovanje.model.Account;
import ftn.uns.eObrazovanje.repository.AccountRepo;
import ftn.uns.eObrazovanje.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepo accRep;
	
	@Override
	public List<Account> findAll() {
		return accRep.findAll();
	}

	@Override
	public Account findOne(Integer accountId) {
		return accRep.findById(accountId).orElse(null);
	}

	@Override
	public void remove(Integer id) {
		accRep.deleteById(id);
		
	}

	@Override
	public Account save(Account account) {
		return accRep.save(account);
	}

}
