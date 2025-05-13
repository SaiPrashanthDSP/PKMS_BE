package com.pkms.demo.Services.Implementation;

import com.pkms.demo.Entity.User;
import com.pkms.demo.Repository.UserRepository;
import com.pkms.demo.Services.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserDataServiceImpl implements UserData {
    @Autowired
    private UserRepository userRepository;


    @Override
    public Optional<User> getUserData(String userName) {
        return userRepository.findByEmail(userName);
    }

    @Override
    public User saveUserData(User user) {
        return userRepository.save(user);
    }
}
