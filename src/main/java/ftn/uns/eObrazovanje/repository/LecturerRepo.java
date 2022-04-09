package ftn.uns.eObrazovanje.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ftn.uns.eObrazovanje.model.Lecturer;
import ftn.uns.eObrazovanje.model.Student;

@Repository
public interface LecturerRepo extends JpaRepository<Lecturer, Integer>{

	@Query(value = "SELECT u FROM Lecturer u WHERE u.username = :username")
	Student getLecturerByUsername(@Param("username") String username);

	
	Lecturer findByUsername(String username);
}
