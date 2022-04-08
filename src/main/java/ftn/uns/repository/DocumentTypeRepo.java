package ftn.uns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.uns.model.DocumentType;

@Repository
public interface DocumentTypeRepo extends JpaRepository<DocumentType, Integer>{

}
