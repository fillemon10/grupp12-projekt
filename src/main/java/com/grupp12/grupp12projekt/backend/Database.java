package com.grupp12.grupp12projekt.backend;

import java.util.ArrayList;

public class Database {
    ArrayList<Recipe> allRecipes;
    private static final Database instance = new Database();

    private Database() {
        //Privat konstruktor
    }

    public static Database getInstance() {
        return Database.instance;
    }

    ArrayList<Recipe> getAllRecipes() {
        return allRecipes;
    }

    void addRecipe(Recipe recipe) {
        allRecipes.add(recipe);
    }
}
