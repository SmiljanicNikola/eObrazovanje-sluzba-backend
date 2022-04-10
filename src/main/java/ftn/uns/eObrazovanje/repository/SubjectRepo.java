package ftn.uns.eObrazovanje.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ftn.uns.eObrazovanje.model.Subject;

@Repository
public interface SubjectRepo extends JpaRepository<Subject,Integer>{
	
	@Query(value = "SELECT u FROM Subject u WHERE u.name = :name")
	Subject getSubjectByName(@Param("name") String name);

	
	Subject findByName(String name);

}
