package ftn.uns.eObrazovanje.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ftn.uns.eObrazovanje.model.Admin;
import ftn.uns.eObrazovanje.model.Semester;
import ftn.uns.eObrazovanje.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer>{
	
	@Query(value = "SELECT u FROM Student u WHERE u.username = :username")
	Student getStudentByUsername(@Param("username") String username);

	
	Student findByUsername(String username);

}
