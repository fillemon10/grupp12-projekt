package com.grupp12.grupp12projekt;

import com.grupp12.grupp12projekt.backend.*;

import java.util.List;

public class Model {
    private User currentUser;
    private Storage storage;
    private RecipeSearch recipeSearch;

    private Database database;

    public Model(User currentUser, Storage storage, RecipeSearch recipeSearch){
        this.currentUser = currentUser;
        this.storage = storage;
        this.recipeSearch = recipeSearch;
    }

    List<Ingredient> getMatchingIngredients(Recipe recipe){
        return recipeSearch.getMatchingIngredients(recipe, this.storage);
    }
}
