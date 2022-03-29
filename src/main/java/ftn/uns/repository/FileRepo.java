package ftn.uns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.uns.model.File;


@Repository
public interface FileRepo extends JpaRepository<File, Integer>{

}
