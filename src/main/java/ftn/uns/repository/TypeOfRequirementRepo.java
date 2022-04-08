package ftn.uns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.uns.model.TypeOfRequirement;

@Repository
public interface TypeOfRequirementRepo extends JpaRepository<TypeOfRequirement, Integer>{

}
