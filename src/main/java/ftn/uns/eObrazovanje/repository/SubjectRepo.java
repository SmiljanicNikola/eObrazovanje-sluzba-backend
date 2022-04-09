package ftn.uns.eObrazovanje.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.uns.eObrazovanje.model.Student;
import ftn.uns.eObrazovanje.model.Subject;

@Repository
public interface SubjectRepo extends JpaRepository<Subject,Integer>{

}
