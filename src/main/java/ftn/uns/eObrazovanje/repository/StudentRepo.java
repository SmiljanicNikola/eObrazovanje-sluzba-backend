package ftn.uns.eObrazovanje.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.uns.eObrazovanje.model.Semester;
import ftn.uns.eObrazovanje.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer>{

}
