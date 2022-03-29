package ftn.uns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.uns.model.Student;
import ftn.uns.model.Subject;

@Repository
public interface SubjectRepo extends JpaRepository<Subject,Integer>{

}
