package com.pkms.demo.Controller;

import com.pkms.demo.Auth.JwtUtil;
import com.pkms.demo.Entity.AuthRequest;
import com.pkms.demo.Entity.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@RestController
//@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/login")
    public ResponseEntity<String> verify(@RequestBody AuthRequest request) {
       Authentication authentication =  authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword())
        );
       System.out.println(request);
       if(authentication.isAuthenticated()) {
           return ResponseEntity.ok(jwtUtil.generateToken(request.getUserName()));
       }
       return ResponseEntity.ok("Unauthorized");
//        String token = jwtUtil.generateToken(request.getUserName());
//        return ResponseEntity.ok(new AuthResponse(token));
    }
    @GetMapping("/hello")
    public ResponseEntity<String> sayHello() {

        return ResponseEntity.ok("Hello");
    }
}



