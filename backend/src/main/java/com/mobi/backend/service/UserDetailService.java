package com.mobi.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobi.backend.data.User;
import com.mobi.backend.data.UserDetail;
import com.mobi.backend.repository.UserDetailRepo;
import com.mobi.backend.repository.UserRepo;

@Service
public class UserDetailService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserDetailRepo userDetailRepo;

    public UserDetail getUserDetail(int userId) {
        User checkUser = userRepo.findById(userId);
        if (checkUser == null) {
            return null;
        }
        return userDetailRepo.getUserDetail(userId);
    }
}
