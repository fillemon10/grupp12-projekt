package com.grupp12.grupp12projekt.backend;

import com.grupp12.grupp12projekt.backend.dataAccess.DataAccessFacade;

public class Authentication {
    private DataAccessFacade dataAccessFacade = DataAccessFacade.getInstance();
    public User loginUser(String username, String password) {
        for (User user : dataAccessFacade.getAllUsers()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public void registerUser(String username, String password) {
        dataAccessFacade.addUserToDatabase(username, password);
    }
}
