package com.grupp12.grupp12projekt.backend;

import java.lang.reflect.Array;
import java.util.*;

public class RecipeSearch  {



    public ArrayList<Recipe>  prioritize(){
         ArrayList<Recipe> allRecipes = Database.getInstance().getAllRecipes();
         Collections.sort(allRecipes, new Comparator<Recipe>() {
            @Override
            public int compare(Recipe c1, Recipe c2) {
                return Double.compare(c1.getMatchingprocentage(), c2.getMatchingprocentage());

            }

        } );

         return allRecipes;
    }










    public List<Recipe> filterByIngredient(Ingredient ingredient) {
        List<Recipe> allRecipes = Database.getInstance().getAllRecipes();
        List<Recipe> filteredRecipes = new ArrayList<>();

        for (Recipe recipe : allRecipes) {
            if (recipe.containsIngredient(ingredient))
                filteredRecipes.add(recipe);
        }
        return filteredRecipes;
    }



    public double getMatchingPercentage(List<Ingredient> storageIngredients, List<Ingredient> recipeIngredients){

        double numberOfTotalIngredients = recipeIngredients.size();
        double numberOfMatchingIngredients = 0;
        double matchingPercentage;

        for (Ingredient recipeIngredient: recipeIngredients){
            for(Ingredient storageIngredient: storageIngredients){
                if (storageIngredient.getName() == recipeIngredient.getName()){

                    numberOfMatchingIngredients += 1;

                }
            }
        }


        matchingPercentage = (numberOfMatchingIngredients/numberOfTotalIngredients)*100;
         return (int) matchingPercentage;
         



    }

    public void getMatchingPercentag(List<Ingredient> storageIngredients, Recipe recipe){
        List<Ingredient> recipeIngredients = recipe.getIngredients();




        double numberOfTotalIngredients = recipeIngredients.size();
        double numberOfMatchingIngredients = 0;
        double matchingPercentage;

        for (Ingredient recipeIngredient: recipeIngredients){
            for(Ingredient storageIngredient: storageIngredients){
                if (storageIngredient.getName() == recipeIngredient.getName()){

                    numberOfMatchingIngredients += 1;

                }
            }
        }

        recipe.setMatchingprocentage((numberOfMatchingIngredients/numberOfTotalIngredients)*100);




    }








    public List<Ingredient> getMatchingIngredients(Recipe recipe, Storage storage) {
        List<Ingredient> matchingIngredients = new ArrayList<Ingredient>();

        for (Ingredient storageIngredient : storage.getContents()) {
            if (recipe.containsIngredient(storageIngredient))
                matchingIngredients.add(storageIngredient);
        }

        return matchingIngredients;
    }

/*    public boolean recipeContains(Recipe recipe, Ingredient ingredient) {
        for (Ingredient recipeIngredient : recipe.getContents()) {
            if (recipeIngredient.getID() == ingredient.getID())
                return true;
        }
        return false;
    }*/



    public List<Ingredient> getNonMatchingIngredients(Recipe recipe, Storage storage){
        List<Ingredient> nonMatchingIngredients = new ArrayList<>();
        nonMatchingIngredients.addAll(recipe.getContents());
        for (Ingredient recipeIngredient: recipe.getContents()) {
            for (Ingredient storageIngredient: storage.getContents()){
               if( recipeIngredient.getID() == storageIngredient.getID()){
                   nonMatchingIngredients.remove(recipeIngredient);
                   break;
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
