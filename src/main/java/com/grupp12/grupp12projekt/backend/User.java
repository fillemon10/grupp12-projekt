package com.grupp12.grupp12projekt.backend;

import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;

@Document(collection = "users", schemaVersion = "1.0")
public class User {
    @Id
    private int id;
    private String username;
    private String password;
    private int storageID;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStorageID() {
        return storageID;
    }

    public void setStorageID(int storageID) {
        this.storageID = storageID;
    }

}
