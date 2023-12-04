package com.Certif.SlackLike.controller;

import com.Certif.SlackLike.model.User;
import com.Certif.SlackLike.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {


    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        if (userService.getAllUsers().isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(userService.getAllUsers());
        }
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Optional<User>> getUserById(@PathVariable("id") Integer id){
//        Optional<User> user = userService.getUserById(id);
//        if (user.isEmpty()){
//            return ResponseEntity.notFound().build();
//        }
//        else {
//           return ResponseEntity.ok(user);
//        }
//    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Integer id){
        for(User u : userService.getAllUsers()){
            if(u.getId().equals(id))
                return ResponseEntity.ok(u);
        }
        return ResponseEntity.status(404).body("User with 'ID " + id + " not found");
    }

//    @PostMapping
//    public User addUser(@RequestBody User newUser){
//
//        return  userService.createUser(newUser);
//
//    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User newUser){
        userService.createUser(newUser);
        return ResponseEntity.ok(newUser);
    }




}
