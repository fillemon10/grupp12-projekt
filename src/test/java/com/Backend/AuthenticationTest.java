package com.Backend;

import com.grupp12.grupp12projekt.backend.Authentication;
import com.grupp12.grupp12projekt.backend.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertFalse;


public class AuthenticationTest {
    private Authentication authentication = new Authentication();
    @Test
    public void testLoginUser() {
        User user = authentication.loginUser("username", "password");
        assertFalse(user != null);
    }

    @Test
    public void testRegisterUser() {
        authentication.registerUser("username", "password");
        User user = authentication.loginUser("username", "password");
        assertFalse(user != null);
    }
}
