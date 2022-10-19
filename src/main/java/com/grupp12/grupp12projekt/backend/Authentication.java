package com.grupp12.grupp12projekt.backend;

import com.grupp12.grupp12projekt.backend.dataAccess.DataAccessFacade;

/**
 * The Authentication class handles the creation and log in functionality of the users of the program
 */


public class Authentication {

    private static Authentication instance;
    private DataAccessFacade dataAccessFacade;

    private Authentication() {
        dataAccessFacade = DataAccessFacade.getInstance();
    }

    static Authentication getInstance() {
        if (instance == null)
            instance = new Authentication();
        return instance;
    }

    /**
     * Method for logging in registered users to the program.
     *
     * @param username the supplied username
     * @param password the supplied password
     * @throws IllegalArgumentException if the supplied username and password for this user is incorrect
     * @return The supplied user
     */

     User loginUser(String username, String password) {
        for (User user : dataAccessFacade.getAllUsers()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new IllegalArgumentException("Wrong username or password");
    }

    /**
     * Method for registering a user to the program. Throws a IllegalArgumentException if the supplied username already is taken by another user.
     * @param username the supplied username for the registration of this user
     * @param password the supplied password for the registration of this user
     * @throws IllegalArgumentException if the supplied username already is taken by another user
     */

    void registerUser(String username, String password) {
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

    void setStorageID(User user){
        dataAccessFacade.setStorageID(user);
    }
}
