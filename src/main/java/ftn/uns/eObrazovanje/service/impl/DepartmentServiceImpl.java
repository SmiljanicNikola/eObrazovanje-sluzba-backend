package ftn.uns.eObrazovanje.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.uns.eObrazovanje.model.Department;
import ftn.uns.eObrazovanje.repository.DepartmentRepo;
import ftn.uns.eObrazovanje.service.DepartmanService;
@Service
public class DepartmentServiceImpl implements DepartmanService{

	@Autowired
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
	public void remove(Integer id) {
		departRepo.deleteById(id);
		
	}

	@Override
	public Department save(Department department) {
		System.out.println(department);
		return departRepo.save(department);
	}

}
