package com.grupp12.grupp12projekt.backend;

import com.grupp12.grupp12projekt.backend.dataAccess.DataAccessFacade;

import java.util.*;

public class RecipeSearch  {


    private DataAccessFacade dataAccessFacade = DataAccessFacade.getInstance();


    public List<Ingredient> findIngredients(String search){
        List<Ingredient> allIngredients = dataAccessFacade.getAllIngredients();
        List<Ingredient> foundIngredients = new ArrayList<>();
        for (Ingredient ingredient : allIngredients) {
            if (ingredient.getName().toLowerCase().contains(search.toLowerCase())) {
                foundIngredients.add(ingredient);
            }
        }
        return foundIngredients;
    }

    public List<Recipe> filterByIngredient(Ingredient ingredient) {
        List<Recipe> allRecipes = dataAccessFacade.getAllRecipes();
        List<Recipe> filteredRecipes = new ArrayList<>();

        for (Recipe recipe : allRecipes) {
            if (recipe.containsIngredient(ingredient))
                filteredRecipes.add(recipe);
        }
        return filteredRecipes;
    }


    public double getMatchingPercentage(Storage storage, Recipe recipe){
        List<Ingredient> recipeIngredients = recipe.getIngredients();
        List<Ingredient> storageIngredients = storage.getIngredients();

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

        for (Ingredient storageIngredient : storage.getIngredients()) {
            if (recipe.containsIngredient(storageIngredient))
                matchingIngredients.add(storageIngredient);
        }

        return matchingIngredients;
    }
    public List<Ingredient> getNonMatchingIngredients(Recipe recipe, Storage storage){
        List<Ingredient> nonMatchingIngredients = new ArrayList<>();
        nonMatchingIngredients.addAll(recipe.getIngredients());
        for (Ingredient recipeIngredient: recipe.getIngredients()) {
            for (Ingredient storageIngredient: storage.getIngredients()){
               if( recipeIngredient.getId() == storageIngredient.getId()){
                   nonMatchingIngredients.remove(recipeIngredient);
                   break;
               }
            }
        }
        return nonMatchingIngredients;
    }


    public Recipe getRecipeById(int id){
        Recipe recipe = dataAccessFacade.getRecipeById(id);
        return recipe;
    }

    public List<Recipe> getAllRecipes(){
        return dataAccessFacade.getAllRecipes();
    }
}
