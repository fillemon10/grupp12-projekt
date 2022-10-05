package com.grupp12.grupp12projekt.backend;

import java.util.ArrayList;

public class Database {
    private static Database instance;
    private ArrayList<Recipe> allRecipes;
    private ArrayList<Ingredient> allIngredients;

    private Database() {
        //Private constructor
        allRecipes = new ArrayList<>();
        allIngredients = new ArrayList<>();
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

    public ArrayList<Ingredient> getAllIngredients() {
        return allIngredients;
    }

    public void addIngredient(Ingredient ingredient) {
        allIngredients.add(ingredient);
    }
}
