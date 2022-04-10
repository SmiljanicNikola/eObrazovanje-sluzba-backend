package ftn.uns.eObrazovanje.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ftn.uns.eObrazovanje.model.Account;
import ftn.uns.eObrazovanje.model.Student;

@Repository
public interface AccountRepo extends JpaRepository<Account,Integer>{
	
}
