package com.grupp12.grupp12projekt.backend;

import com.grupp12.grupp12projekt.backend.dataAccess.DataAccessFacade;


public class Authentication {

    private static Authentication instance;
    private DataAccessFacade dataAccessFacade;

    private Authentication() {
        dataAccessFacade = DataAccessFacade.getInstance();
    }

    public static Authentication getInstance() {
        if (instance == null)
            instance = new Authentication();
        return instance;
    }

    public User loginUser(String username, String password) {
        for (User user : dataAccessFacade.getAllUsers()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new IllegalArgumentException("Wrong username or password");
    }

    public void registerUser(String username, String password) {
        boolean alreadyExists = false;
        for (User user : dataAccessFacade.getAllUsers()) {
            if (user.getUsername().equals(username)) {
                alreadyExists = true;
                break;
            }
        }

        if (!alreadyExists) {
            dataAccessFacade.addUserToDatabase(username, password);
        } else {
            throw new IllegalArgumentException("Username already exists!");
        }
    }
}
