package com.mobi.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobi.backend.data.User;
import com.mobi.backend.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public List<User> getAllUser() {
        return userRepo.getAllUser();
    }

    public User findById(int id) {
        return userRepo.findById(id);
    }

    public User findByName(String name) {
        return userRepo.findByName(name);
    }

    public void addUser(User data) {
        userRepo.addUser(data);    
    }

    public void editUser(int id, User data) {
        userRepo.editUser(id, data);
    }

    public void deleteAll() {
        userRepo.deleteAll();
    }

    public void deleteUser(int id) {
        userRepo.deleteUser(id);
    }
}