package com.grupp12.grupp12projekt.backend;

import com.grupp12.grupp12projekt.backend.dataAccess.IDataAccess;
import com.grupp12.grupp12projekt.backend.dataAccess.JsonDBUserDataAccess;

public class Authentication {
    public User loginUser(String username, String password) {
        IDataAccess<User> userDataAccess = new JsonDBUserDataAccess();
        for (User user : userDataAccess.getAll()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
