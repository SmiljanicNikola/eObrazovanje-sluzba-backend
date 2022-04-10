package ftn.uns.eObrazovanje.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ftn.uns.eObrazovanje.model.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Integer> {

	@Query(value = "SELECT u FROM Department u WHERE u.name = :name")
	Department getDepartmentByName(@Param("name") String name);

	
	Department findByName(String name);
	
}
