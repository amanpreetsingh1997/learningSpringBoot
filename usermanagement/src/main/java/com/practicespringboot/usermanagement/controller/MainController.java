package com.practicespringboot.usermanagement.controller;

import org.springframework.web.bind.annotation.RestController;

import com.practicespringboot.usermanagement.entities.Response;
import com.practicespringboot.usermanagement.entities.User;
import com.practicespringboot.usermanagement.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private Response response;
    
    @PostMapping("/insertUser")
    public ResponseEntity<?> saveUserHandler(@RequestBody User user) {
        User savedUser = this.userService.saveUser(user);
        response.setMessage("User saved with "+savedUser.getId()+" id.");
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/getUserInfo/{id}")
    public User getUserHandler(@PathVariable int id) {
        return this.userService.getUserById(id);
    }

    @GetMapping("/getUserInfo")
    public User getUserByEmailHandler(@RequestParam String email) {
        return this.userService.getUserByEmail(email);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUserHandler(@PathVariable int id) {
        this.userService.deleteUserById(id);
        response.setMessage("The User with id "+id+" is deleted.");
        return ResponseEntity.ok().body(response);
    }
    
}
