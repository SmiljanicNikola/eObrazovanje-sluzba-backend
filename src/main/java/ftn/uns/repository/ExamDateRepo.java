package ftn.uns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.uns.model.ExamDate;

@Repository
public interface ExamDateRepo extends JpaRepository<ExamDate, Integer>{

}
