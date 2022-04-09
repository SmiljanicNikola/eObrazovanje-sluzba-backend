package ftn.uns.eObrazovanje.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.uns.eObrazovanje.model.TakingExam;

@Repository
public interface TakingExamRepo extends JpaRepository<TakingExam, Integer>{

}
