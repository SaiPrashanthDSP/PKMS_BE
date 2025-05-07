package com.pkms.demo.Services;

import com.pkms.demo.Entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserData {
   Optional<User> getUserData(String userName);

   User saveUserData(User user);
}
