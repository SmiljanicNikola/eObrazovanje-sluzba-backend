package ftn.uns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.uns.model.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account,Integer>{

}
