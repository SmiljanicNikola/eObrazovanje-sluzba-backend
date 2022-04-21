package ftn.uns.eObrazovanje.service;

import java.util.List;

import ftn.uns.eObrazovanje.model.User;


public interface UserService {

    User findByUsernameAndPassword(String username, String password);

    List<User> findAll();

    void add(User user);
    
    User findOne(Integer userId);
    
    User findByUsername(String username);
    
    void remove(Integer id);
    
    User save(User user);
}
