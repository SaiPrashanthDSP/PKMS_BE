package com.pkms.demo.Entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AuthRequest {
    String userName;
    String password;

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }
}
