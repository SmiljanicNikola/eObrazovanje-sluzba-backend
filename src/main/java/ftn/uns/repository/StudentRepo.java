package ftn.uns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.uns.model.Semester;
import ftn.uns.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer>{

}
