package ftn.uns.eObrazovanje.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ftn.uns.eObrazovanje.model.AttendingCourses;

@Repository
public interface AttendingCourseRepo extends JpaRepository<AttendingCourses, Integer>{

	@Query(value = "SELECT u FROM AttendingCourses u WHERE u.student.username = :username")
	List<AttendingCourses> findByUsername(@Param("username") String username);	
}
