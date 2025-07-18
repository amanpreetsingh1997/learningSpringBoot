package com.practicespringboot.usermanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practicespringboot.usermanagement.entities.User;


public interface UserRepository extends JpaRepository<User, Integer>{

    User findByEmail(String email);
    
}
