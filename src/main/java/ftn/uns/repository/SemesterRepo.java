package ftn.uns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.uns.model.Department;
import ftn.uns.model.Semester;

@Repository
public interface SemesterRepo extends JpaRepository<Semester,Integer>{

}
