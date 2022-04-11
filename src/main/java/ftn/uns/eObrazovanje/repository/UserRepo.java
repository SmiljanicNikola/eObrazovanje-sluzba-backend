package ftn.uns.eObrazovanje.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.uns.eObrazovanje.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	
	User findByUsername(String username);

}
