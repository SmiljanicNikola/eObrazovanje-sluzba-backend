package ftn.uns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.uns.model.TakingExam;

@Repository
public interface TakingExamRepo extends JpaRepository<TakingExam, Integer>{

}
