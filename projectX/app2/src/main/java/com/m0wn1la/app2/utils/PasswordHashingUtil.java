package com.m0wn1la.app2.utils;

import org.springframework.stereotype.Component;
import org.mindrot.jbcrypt.BCrypt;

@Component
public class PasswordHashingUtil {
    public String hashPassword(String password, String salt) {
        return BCrypt.hashpw(password, salt);

    }
    public String generateSalt() {
        return BCrypt.gensalt();
    }
}
