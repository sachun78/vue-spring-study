package com.mobi.backend.controller;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobi.backend.data.UserDetail;
import com.mobi.backend.service.UserDetailService;

@RestController
@RequestMapping("/api/user-detail")
public class UserDetailCtrl {

    @Autowired
    private UserDetailService userDetailDao;

    @GetMapping("/{userId}")
    public ResponseEntity<UserDetail> getUserDetail(@PathVariable(name="userId") int id) {   
        UserDetail userDetail = userDetailDao.getUserDetail(id);
        if (userDetail == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        return ResponseEntity.ok().body(userDetail);
    }
}
