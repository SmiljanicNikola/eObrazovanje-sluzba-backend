package ftn.uns.eObrazovanje.service;

import java.util.List;

import ftn.uns.eObrazovanje.model.Admin;
import ftn.uns.eObrazovanje.model.DTO.AdminDTO;

public interface AdminService {

    Admin findByUsernameAndPassword(String username, String password);

    List<Admin> findAll();

    void add(Admin admin);
    
    Admin findOne(Integer userId);
    
    Admin findByUsername(String username);
    
    void remove(Integer id);
    
    Admin save(AdminDTO admin);
}
