package com.Backend;

import com.grupp12.grupp12projekt.backend.Model;
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
        model.logInUser("username", "password");
        assertTrue(model.getCurrentUser() != null);
        assertTrue(model.getCurrentUser().getUsername() == "username");
        assertTrue(model.getCurrentUser().getPassword() == "password");
    }

    @Test
    public void testRegisterUser() {
        String username = getRandomString(8);
        String password = getRandomString(8);
        model.createNewUser(username, password);
        assertTrue(model.getCurrentUser() != null);
    }
}
