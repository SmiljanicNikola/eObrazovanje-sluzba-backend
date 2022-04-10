package ftn.uns.eObrazovanje.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import ftn.uns.eObrazovanje.model.Department;
import ftn.uns.eObrazovanje.repository.DepartmentRepo;
import ftn.uns.eObrazovanje.service.DepartmanService;
@Service
public class DepartmentServiceImpl implements DepartmanService{

	private DepartmentRepo departRepo;
	
	@Override
	public List<Department> findAll() {
		return departRepo.findAll();
	}

	@Override
	public void add(Department department) {
		departRepo.save(department);
		
	}

	@Override
	public Department findOne(Integer departmenId) {
		return departRepo.findById(departmenId).orElse(null);
	}

	@Override
	public Department findByName(String name) {
		return departRepo.findByName(name);
	}

	@Override
	public void remove(Integer id) {
		departRepo.deleteById(id);
		
	}

	@Override
	public Department save(Department department) {
		return departRepo.save(department);
	}

}
