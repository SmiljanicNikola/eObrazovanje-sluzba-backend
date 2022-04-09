package ftn.uns.eObrazovanje.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.uns.eObrazovanje.model.AttendingCourses;

@Repository
public interface AttendingCourseRepo extends JpaRepository<AttendingCourses, Integer>{

}
