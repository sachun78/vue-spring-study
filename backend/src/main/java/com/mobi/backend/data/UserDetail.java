package com.mobi.backend.data;

import lombok.Data;

@Data
public class UserDetail {
    int id;
    int userId;
    String company;
    String sex;
    String memo;
}