package com.grupp12.grupp12projekt.backend;

import com.grupp12.grupp12projekt.CSVReader;

import java.io.FileNotFoundException;
import java.util.List;

public class RecipeSearch {
    private List<Recipe> listOfFilteredRecipes[];
    private List<Recipe> allRecipes;

    public RecipeSearch() throws FileNotFoundException {

        this.allRecipes = getAllRecipes();
    }

    private List<Recipe> getAllRecipes() throws FileNotFoundException {
        return null;
    }

    protected void prioritizeRecipes(){


    }

    protected void filterByIngredient(Ingredient ingredient){




    }



}
