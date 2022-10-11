package com.grupp12.grupp12projekt.backend;

import java.util.*;

public class RecipeSearch  {



    public ArrayList<Recipe> prioritize(){
         ArrayList<Recipe> allRecipes = Database.getInstance().getAllRecipes();
         Collections.sort(allRecipes, new Comparator<Recipe>() {
            @Override
            public int compare(Recipe c1, Recipe c2) {
                return Double.compare(c1.getMatchingPercentage(), c2.getMatchingPercentage());

            }

        } );

         return allRecipes;
    }

    public List<Ingredient> findIngredients(String s) {
        String lowS = s.toLowerCase();
        List<Ingredient> result = new ArrayList();
        Iterator var4 = Database.getInstance().getAllIngredients().iterator();

        while (var4.hasNext()) {
            Ingredient i = (Ingredient) var4.next();
            String productName = i.getName().toLowerCase();
            if (productName.indexOf(lowS) > -1) {
                result.add(i);
            }
        }

        return result;
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


    public double getMatchingPercentage(Storage storage, Recipe recipe){
        List<Ingredient> recipeIngredients = recipe.getContents();
        List<Ingredient> storageIngredients = storage.getContents();

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


        matchingPercentage = (numberOfMatchingIngredients/numberOfTotalIngredients);
        return matchingPercentage;

    }
    public List<Ingredient> getMatchingIngredients(Recipe recipe, Storage storage) {
        List<Ingredient> matchingIngredients = new ArrayList<Ingredient>();

        for (Ingredient storageIngredient : storage.getContents()) {
            if (recipe.containsIngredient(storageIngredient))
                matchingIngredients.add(storageIngredient);
        }

        return matchingIngredients;
    }
    public List<Ingredient> getNonMatchingIngredients(Recipe recipe, Storage storage){
        List<Ingredient> nonMatchingIngredients = new ArrayList<>();
        nonMatchingIngredients.addAll(recipe.getContents());
        for (Ingredient recipeIngredient: recipe.getContents()) {
            for (Ingredient storageIngredient: storage.getContents()){
               if( recipeIngredient.getId() == storageIngredient.getId()){
                   nonMatchingIngredients.remove(recipeIngredient);
                   break;
               }
            }
        }
        return nonMatchingIngredients;
    }
}
