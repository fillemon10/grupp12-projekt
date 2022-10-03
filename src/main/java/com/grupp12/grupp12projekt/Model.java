package com.grupp12.grupp12projekt;

import com.grupp12.grupp12projekt.backend.*;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class Model {
    private User currentUser;
    private Storage storage;
    private RecipeSearch recipeSearch;

    private static UserDataAccess userDataAccess = new UserDataAccess();



    public Model(User currentUser, Storage storage, RecipeSearch recipeSearch){
        this.currentUser = currentUser;
        this.storage = storage;
        this.recipeSearch = recipeSearch;
    }

    List<Ingredient> getMatchingIngredients(Recipe recipe){
        return recipeSearch.getMatchingIngredients(recipe, this.storage);
    }

    ArrayList<Recipe> filterByIngredient(Ingredient ingredient) {
        return recipeSearch.filterByIngredient(ingredient);
    }
}
