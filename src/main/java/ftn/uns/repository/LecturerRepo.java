package ftn.uns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.uns.model.Lecturer;

@Repository
public interface LecturerRepo extends JpaRepository<Lecturer, Integer>{

}
