package com.mobi.backend.repository;

import org.apache.ibatis.annotations.Mapper;

import com.mobi.backend.data.UserDetail;

@Mapper
public interface UserDetailRepo {
    UserDetail getUserDetail(int userId);
}
