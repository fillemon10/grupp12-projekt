package com.grupp12.grupp12projekt.backend;

import java.util.ArrayList;
import java.util.List;

public class RecipeSearch {
    //private List<Recipe> listOfFilteredRecipes[];
    //private List<Recipe> allRecipes;


    protected void prioritizeRecipes(){

    }

    protected void filterByIngredient(Ingredient ingredient){

    }

    public List<Ingredient> getMatchingIngredients(Recipe recipe, Storage storage){
        List<Ingredient> matchingIngredients = new ArrayList<Ingredient>();

        for (Ingredient recipeIngredient: recipe.getContents()){
            for (Ingredient storageIngredient: storage.getContents()){
                 if (recipeIngredient.getID() == storageIngredient.getID()){
                     matchingIngredients.add(recipeIngredient);
                     break;
                 }
            }
        }
        return matchingIngredients;
    }

    public List<Ingredient> getNonMatchingIngredients(Recipe recipe, Storage storage){
        List<Ingredient> nonMatchingIngredients = new ArrayList<Ingredient>();
        for (Ingredient recipeIngredient: recipe.getContents()) {
            for (Ingredient storageIngredient: storage.getContents()) {
                if(recipeIngredient.getID() != storageIngredient.getID()){
                    nonMatchingIngredients.add(recipeIngredient);
                }
            }

        }
        return nonMatchingIngredients;
    }

//    public List<Recipe> ReadRecipesFromFile() throws IOException, CsvException {
//        List<Recipe> recipes = new ArrayList<Recipe>();
//        CSVReader reader = new CSVReader(new BufferedReader(new FileReader("src/main/resources/recipe.csv")));
//        List<String[]> rows = reader.readAll();
//
//        List<Ingredient> ingredients = new ArrayList<Ingredient>();
//        for (int i = 5; i < rows.get(0).length; i++) {
//            ingredients.add(new Ingredient(0, rows.get(0)[i]));
//        }
//
//        for (String[] row : rows) {
//            Recipe recipe = new Recipe(0, "", ingredients , "");
//            recipes.add(recipe);
//        }
//
//        return recipes;
//    }


}
