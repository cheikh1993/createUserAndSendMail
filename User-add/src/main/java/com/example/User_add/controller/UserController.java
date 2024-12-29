package com.example.User_add.controller;

import com.example.User_add.Entity.UserEntity;
import com.example.User_add.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
@PostMapping("/add")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
     UserEntity createUser =userService.addUser(user);
     return ResponseEntity.ok(createUser);
}
@PutMapping("/update")
    public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity user) {
UserEntity updateUser = userService.updateUser(user);
return ResponseEntity.ok(updateUser);
}
}
