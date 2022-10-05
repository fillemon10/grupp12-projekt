package com.grupp12.grupp12projekt.backend;

import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;

import java.util.ArrayList;

public class old_User {

    private int ID;
    private String username;
    private String password;
    private int storageID;
    private ArrayList<Recipe> favorites;

//    public User(int ID, String username, String password, int storageID, ArrayList<Recipe> favorites)
//    {
//        this.ID = ID;
//        this.username = username;
//        this.password = password;
//        this.storageID = storageID;
//        this.favorites = favorites;
//    }

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

    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }

    public int getStorageID() {
        return storageID;
    }
    public void setStorageID(int storageID) {
        this.storageID = storageID;
    }

    public ArrayList<Recipe> getFavorites() {
        return favorites;
    }
    public void setFavorites(ArrayList<Recipe> favorites) {
        this.favorites = favorites;
    }

    public void addRecipeToFavorite(Recipe recipe) {
        favorites.add(recipe);
    }

    public void removeRecipeFromFavorites(Recipe recipe){
        favorites.remove(recipe);
    }


}
