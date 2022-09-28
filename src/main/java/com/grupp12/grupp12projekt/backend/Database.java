package com.grupp12.grupp12projekt.backend;

import java.util.ArrayList;

public class Database {
    ArrayList<Recipe> allRecipes;
    private static final Database instance = new Database();

    private Database() {
        //Private constructor
        allRecipes = new ArrayList<>();
    }

    public static Database getInstance() {
        return Database.instance;
    }

    ArrayList<Recipe> getAllRecipes() {
        return allRecipes;
    }

    public void addRecipe(Recipe recipe) {
        allRecipes.add(recipe);
    }
}
