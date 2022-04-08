package ftn.uns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.uns.model.PreExaminationObligations;

@Repository
public interface PreExaminationObligationsRepo extends JpaRepository<PreExaminationObligations, Integer>{

}
