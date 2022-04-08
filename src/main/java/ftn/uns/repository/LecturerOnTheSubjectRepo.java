package ftn.uns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.uns.model.LecturerOnTheSubject;

@Repository
public interface LecturerOnTheSubjectRepo extends JpaRepository<LecturerOnTheSubject, Integer>{

}
