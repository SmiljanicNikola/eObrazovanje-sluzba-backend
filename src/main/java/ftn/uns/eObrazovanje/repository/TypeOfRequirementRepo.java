package ftn.uns.eObrazovanje.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.uns.eObrazovanje.model.TypeOfRequirement;

@Repository
public interface TypeOfRequirementRepo extends JpaRepository<TypeOfRequirement, Integer>{

}
