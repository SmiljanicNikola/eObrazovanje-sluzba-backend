package ftn.uns.eObrazovanje.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.uns.eObrazovanje.model.DocumentType;

@Repository
public interface DocumentTypeRepo extends JpaRepository<DocumentType, Integer>{

}
