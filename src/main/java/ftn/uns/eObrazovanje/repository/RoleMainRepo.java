package ftn.uns.eObrazovanje.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.uns.eObrazovanje.model.Role;

@Repository
public interface RoleMainRepo extends JpaRepository<Role, Integer>{

	Role findByName(String name);
}
