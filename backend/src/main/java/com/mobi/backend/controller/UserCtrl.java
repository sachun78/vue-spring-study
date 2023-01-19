package com.mobi.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobi.backend.data.User;
import com.mobi.backend.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserCtrl {
    @Autowired
    private UserService userDao;

    @GetMapping("")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> userList = userDao.getAllUser();
        if (userList.size() <= 0) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(userList);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> findById(@PathVariable(name="userId") int id) {
        User user = userDao.findById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/name/{userName}")
    public ResponseEntity<User> findByName(@PathVariable(name="userName") String name) {
        User user = userDao.findByName(name);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        log.info("TEST");

        User checkUser = userDao.findByName(user.getName());
        if (checkUser == null) {
            userDao.addUser(user);
             return ResponseEntity.ok().body("Add user(" + user.getName() + ")");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @PutMapping("/{userId}")
    public ResponseEntity<String> editUser(@PathVariable(name="userId") int id, @RequestBody User user) {
        userDao.editUser(id, user);
        return ResponseEntity.ok().body("Success update user(" + id + ")");
    }

    @DeleteMapping("")
    public ResponseEntity<String> deleteAll() {
        userDao.deleteAll();
        return ResponseEntity.ok().body("Delete all successful !!!!");
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable(name="userId") int id) {
        userDao.deleteUser(id);
        return ResponseEntity.ok().body("Delete user(" + id + ")");
    }
}

