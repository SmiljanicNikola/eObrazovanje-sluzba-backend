package ftn.uns.eObrazovanje.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.uns.eObrazovanje.model.SubjectPerformance;

@Repository
public interface SubjectPerformanceRepo extends JpaRepository<SubjectPerformance, Integer>{

}
