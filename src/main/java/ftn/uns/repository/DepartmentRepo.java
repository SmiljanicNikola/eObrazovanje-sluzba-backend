package ftn.uns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.uns.model.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Integer> {

}
