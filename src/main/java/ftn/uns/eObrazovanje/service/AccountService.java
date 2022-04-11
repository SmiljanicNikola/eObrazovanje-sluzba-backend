package ftn.uns.eObrazovanje.service;

import java.util.List;

import ftn.uns.eObrazovanje.model.Account;

public interface AccountService {

	List<Account> findAll();

	Account findOne(Integer accountId);

	Account save(Account account);

	void remove(Integer id);

}
