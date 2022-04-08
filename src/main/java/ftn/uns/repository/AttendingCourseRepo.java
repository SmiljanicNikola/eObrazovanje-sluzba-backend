package ftn.uns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.uns.model.AttendingCourses;

@Repository
public interface AttendingCourseRepo extends JpaRepository<AttendingCourses, Integer>{

}
