package com.example.User_add.service;

import com.example.User_add.Entity.UserEntity;

public interface UserService {
    UserEntity addUser(UserEntity user);
    UserEntity updateUser(UserEntity user);
}
