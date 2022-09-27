package com.grupp12.grupp12projekt.backend;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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

    private List<Recipe> ReadRecipesFromFile() throws IOException, CsvException {
        List<Recipe> recipes = new ArrayList<Recipe>();
        CSVReader reader = new CSVReader(new BufferedReader(new FileReader("src/main/resources/recipes.csv")));
        List<String[]> rows = reader.readAll();
        for (String[] row : rows) {
            List<Ingredient> ingredients = new ArrayList<Ingredient>();
            Recipe recipe = new Recipe(0, "", ingredients , "");
            recipes.add(recipe);
        }

        return recipes;
    }


}
