package ftn.uns.eObrazovanje.service;

import java.util.List;

import ftn.uns.eObrazovanje.model.Lecturer;
import ftn.uns.eObrazovanje.model.DTO.LecturerDTO;


public interface LecturerService {

    Lecturer findByUsernameAndPassword(String username, String password);

    List<Lecturer> findAll();

    void add(Lecturer lecturer);
    
    Lecturer findOne(Integer id);
    
    Lecturer findByUsername(String username);
    
    void remove(Integer id);
    
    Lecturer save(LecturerDTO lecturer);
}
