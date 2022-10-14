package com.Backend;

import com.grupp12.grupp12projekt.Model;
import com.grupp12.grupp12projekt.backend.Authentication;
import com.grupp12.grupp12projekt.backend.User;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertFalse;


public class AuthenticationTest {
    private Model model = Model.getInstance();

    protected String getRandomString(int lenght) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < lenght) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

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
