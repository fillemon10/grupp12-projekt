package com.Backend;

import com.grupp12.grupp12projekt.backend.Authentication;
import com.grupp12.grupp12projekt.backend.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class AuthenticationTest {
    @Test
    public void testLoginUser() {
        Authentication authentication = new Authentication();
        User user = authentication.loginUser("username", "password");
        assertFalse(user != null);

    }
}
