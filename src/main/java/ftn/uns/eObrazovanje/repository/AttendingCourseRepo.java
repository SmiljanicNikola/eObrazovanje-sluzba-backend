package ftn.uns.eObrazovanje.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ftn.uns.eObrazovanje.model.AttendingCourses;
import ftn.uns.eObrazovanje.model.Student;

@Repository
public interface AttendingCourseRepo extends JpaRepository<AttendingCourses, Integer>{

	@Query(value = "SELECT u FROM AttendingCourses u WHERE u.student.username = :username")
	Set<AttendingCourses> findByUsername(@Param("username") String username);	

}
