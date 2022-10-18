package com.grupp12.grupp12projekt.backend;

import com.grupp12.grupp12projekt.Model;
import com.grupp12.grupp12projekt.backend.dataAccess.DataAccessFacade;


public class Authentication {
    private static Authentication instance;

    public static Authentication getInstance() {
        if (instance == null)
            instance = new Authentication();
        return instance;
    }

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
        boolean alreadyExists = false;
        for (User user: dataAccessFacade.getAllUsers()) {
            if(user.getUsername().equals(username)){
                alreadyExists = true;
                //släng ett error här tack
                break;
            }
        }
        if (!alreadyExists){
            dataAccessFacade.addUserToDatabase(username, password);
        }
    }
}
