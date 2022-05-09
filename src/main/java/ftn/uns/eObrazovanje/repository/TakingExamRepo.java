package ftn.uns.eObrazovanje.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ftn.uns.eObrazovanje.model.AttendingCourses;
import ftn.uns.eObrazovanje.model.TakingExam;

@Repository
public interface TakingExamRepo extends JpaRepository<TakingExam, Integer>{
	
	@Query(value = "SELECT t FROM TakingExam t")
	Set<TakingExam> find();	

}
