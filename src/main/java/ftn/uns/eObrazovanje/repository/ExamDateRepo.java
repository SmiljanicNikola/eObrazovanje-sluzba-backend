package ftn.uns.eObrazovanje.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.uns.eObrazovanje.model.ExamDate;

@Repository
public interface ExamDateRepo extends JpaRepository<ExamDate, Integer>{

}
