package ftn.uns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.uns.model.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>{

}
