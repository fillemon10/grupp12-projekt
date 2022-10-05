package com.grupp12.grupp12projekt;

import com.grupp12.grupp12projekt.backend.*;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Model {
    private User currentUser;
    private Storage storage;
    private RecipeSearch recipeSearch;
    private static Model instance;

    public static Model getInstance() {
        if (instance == null)
            instance = new Model();
        return instance;
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public void setRecipeSearch(RecipeSearch recipeSearch) {
        this.recipeSearch = recipeSearch;
    }

    public List<Ingredient> getMatchingIngredients(Recipe recipe) {
        return recipeSearch.getMatchingIngredients(recipe, this.storage);
    }

    public double getMatchingPercentage(Recipe recipe) {
        return recipeSearch.getMatchingPercentage(storage, recipe);
    }

    public List<Ingredient> findIngredients(String s) {
        return recipeSearch.findIngredients(s);
    }

    public List<Recipe> filterByIngredient(Ingredient ingredient) {
        return recipeSearch.filterByIngredient(ingredient);
    }
}
