package ftn.uns.eObrazovanje.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.uns.eObrazovanje.model.Rolee;

@Repository
public interface RoleRepo extends JpaRepository<Rolee, Integer>{

}
