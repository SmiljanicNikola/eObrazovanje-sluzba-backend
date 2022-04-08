package ftn.uns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.uns.model.StudentHistory;

@Repository
public interface StudentHistoryRepo extends JpaRepository<StudentHistory, Integer>{

}
