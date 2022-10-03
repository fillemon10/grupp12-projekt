package com.grupp12.grupp12projekt.backend;

import io.jsondb.annotation.Id;
import io.jsondb.annotation.Secret;

import java.util.ArrayList;

public class User {

    @Id
    private int ID;
    private String username;
    @Secret
    private String password;
    private int storageID;
    private ArrayList<Recipe> favorites;

    public User(int ID, String username, String password, int storageID, ArrayList<Recipe> favorites)
    {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.storageID = storageID;
        this.favorites = favorites;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getID() {
        return ID;
    }
    public int getStorageID() {
        return storageID;
    }

    public ArrayList<Recipe> getFavorites() {
        return favorites;
    }

    public void addRecipeToFavorite(Recipe recipe) {
        favorites.add(recipe);
    }

    public void removeRecipeFromFavorites(Recipe recipe){
        favorites.remove(recipe);
    }


}
