package com.zk.security.controller;


import com.zk.security.model.User;
import com.zk.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User userCreated = userService.saveUser(user);
        return new ResponseEntity<>(userCreated, HttpStatus.CREATED);
    }
}
