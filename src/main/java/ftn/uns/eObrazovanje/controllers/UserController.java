package ftn.uns.eObrazovanje.controllers;

import ftn.uns.eObrazovanje.model.Student;
import ftn.uns.eObrazovanje.model.User;
import ftn.uns.eObrazovanje.model.request.UpdateUserRequest;
import ftn.uns.eObrazovanje.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(value = "api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = userService.findAll();
        //System.out.println(students.get(3).getAttendingCourses());

        return ResponseEntity.ok().body(users);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Integer id) {
        User user = userService.findOne(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(value = "/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username) {
        User user = userService.findByUsername(username);
        if (user  == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateUser(@RequestBody UpdateUserRequest updateUserRequest,
                                             @PathVariable Integer id) {
        try {
            User existingUser = userService.findOne(id);
            if(existingUser != null) {
                existingUser.setName(existingUser.getName());
                existingUser.setSurname(existingUser.getSurname());
                existingUser.setUsername(existingUser.getUsername());
                existingUser.setAddress(existingUser.getAddress());
                existingUser.setJmbg(existingUser.getJmbg());

                userService.save(existingUser);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("updatePassword/username/{username}")
    public ResponseEntity<?> updatePassword(@RequestBody User user,
                                            @PathVariable String username) {
        try {
            User existUser = userService.findByUsername(username);
            if(existUser != null) {
                existUser.setPassword(passwordEncoder.encode(user.getPassword()));
                userService.save(existUser);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
