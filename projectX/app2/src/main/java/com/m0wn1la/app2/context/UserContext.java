package com.m0wn1la.app2.context;

import com.m0wn1la.app2.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserContext {
    private static final ThreadLocal<User> CURRENT_USER = new ThreadLocal<>();
    public static User getCurrentUser() {
        return CURRENT_USER.get();
    }
    public static void setCurrentUser(User user) {
        CURRENT_USER.set(user);
    }
}
