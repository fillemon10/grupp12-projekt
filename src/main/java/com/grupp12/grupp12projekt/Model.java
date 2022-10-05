package com.grupp12.grupp12projekt;

import com.grupp12.grupp12projekt.backend.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Model {
    private User currentUser;
    private Storage storage;
    private RecipeSearch recipeSearch;



    public Model(User currentUser, Storage storage, RecipeSearch recipeSearch){
        this.currentUser = currentUser;
        this.storage = storage;
        this.recipeSearch = recipeSearch;
    }

    List<Ingredient> getMatchingIngredients(Recipe recipe){
        return recipeSearch.getMatchingIngredients(recipe, this.storage);
    }


    List<Recipe> filterByIngredient(Ingredient ingredient) {
        return recipeSearch.filterByIngredient(ingredient);
    }
}
