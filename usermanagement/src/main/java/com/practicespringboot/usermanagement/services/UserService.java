package com.practicespringboot.usermanagement.services;
import com.practicespringboot.usermanagement.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practicespringboot.usermanagement.dao.UserRepository;
import com.practicespringboot.usermanagement.entities.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    public User getUserById(int id) {
        return this.userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("The user with id  "+id+" not found"));
    }

    public User getUserByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    public void deleteUserById(int id) {
        this.userRepository.deleteById(id);
    }

}
