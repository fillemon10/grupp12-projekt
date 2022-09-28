package com.grupp12.grupp12projekt.backend;

import java.util.ArrayList;

public class Database {
    ArrayList<Recipe> allRecipes;
    private static Database instance;

    private Database() {
        //Private constructor
        allRecipes = new ArrayList<>();
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return Database.instance;
    }

    public ArrayList<Recipe> getAllRecipes() {
        return allRecipes;
    }

    public void addRecipe(Recipe recipe) {
        allRecipes.add(recipe);
    }
}
