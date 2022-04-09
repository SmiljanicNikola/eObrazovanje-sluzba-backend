package ftn.uns.eObrazovanje.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.uns.eObrazovanje.model.Department;
import ftn.uns.eObrazovanje.model.Semester;

@Repository
public interface SemesterRepo extends JpaRepository<Semester,Integer>{

}
