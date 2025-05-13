package com.pkms.demo.Controller;

import com.pkms.demo.Entity.User;
import com.pkms.demo.Services.Implementation.UserDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserDataServiceImpl userDataServiceImpl;

    @PostMapping("/save-user")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        user.setPassword(new BCryptPasswordEncoder(12).encode(user.getPassword()));
        userDataServiceImpl.saveUserData(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
