package com.mobi.backend.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mobi.backend.data.User;

@Mapper
public interface UserRepo {
    List<User> getAllUser();
    User findById(int id);
    User findByName(String name);
    void addUser(User data);
    void editUser(int id, User data);
    void deleteAll();
    void deleteUser(int id);
}
