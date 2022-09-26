package com.grupp12.grupp12projekt.backend;

import java.util.List;

public class User {

    private int ID;
    private String username;
    private String password;
    private int storageID;
    private List<Recipe> favorites;

    public User(int ID, String username, String password, int StorageID, List<Recipe> favorites)
    {
        this.ID = ID;
        this.username = username;
        this.password = password;
    }

    String getUsername() {
        return username;
    }

     String getPassword() {
        return password;
    }

    int getStorageID() {
        return storageID;
    }
}
