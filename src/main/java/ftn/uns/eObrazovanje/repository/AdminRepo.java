package ftn.uns.eObrazovanje.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ftn.uns.eObrazovanje.model.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>{

	@Query(value = "SELECT u FROM Admin u WHERE u.username = :username")
	Admin getAdminByUsername(@Param("username") String username);

	
	Admin findByUsername(String username);
}
