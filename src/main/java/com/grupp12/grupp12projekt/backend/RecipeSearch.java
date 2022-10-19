package com.grupp12.grupp12projekt.backend;

import com.grupp12.grupp12projekt.backend.dataAccess.DataAccessFacade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecipeSearch {
    private DataAccessFacade dataAccessFacade;
    private static RecipeSearch instance;

    static RecipeSearch getInstance() {
        if (instance == null)
            instance = new RecipeSearch();
        return instance;
    }

    private RecipeSearch() {
        dataAccessFacade = DataAccessFacade.getInstance();
    }

    List<Ingredient> findIngredients(String search) {
        List<Ingredient> allIngredients = dataAccessFacade.getAllIngredients();
        List<Ingredient> foundIngredients = new ArrayList<>();
        for (Ingredient ingredient : allIngredients) {
            if (ingredient.getName().toLowerCase().contains(search.toLowerCase())) {
                foundIngredients.add(ingredient);
            }
        }
        return foundIngredients;
    }

    List<Recipe> filterByIngredient(Ingredient ingredient) {
        List<Recipe> allRecipes = dataAccessFacade.getAllRecipes();
        List<Recipe> filteredRecipes = new ArrayList<>();

        for (Recipe recipe : allRecipes) {
            if (recipe.containsIngredient(ingredient))
                filteredRecipes.add(recipe);
        }
        return filteredRecipes;
    }

    private List<Recipe> sortListOfRecipesBasedOnNumberOfIngredientsInStorage(Storage storage, List<Recipe> recipes) {
        Map<Recipe, Double> recipeIngredientCount = new HashMap<>();
        for (Recipe recipe : recipes) {
            double count = 0;
            for (Ingredient ingredient : storage.getIngredients()) {
                if (recipe.containsIngredient(ingredient)) count++;
            }
            double match =count / recipe.getIngredients().size();
            recipeIngredientCount.put(recipe, match);
        }
        List<Recipe> sortedRecipes = new ArrayList<>();
        recipeIngredientCount.entrySet().stream().sorted(Map.Entry.<Recipe, Double>comparingByValue().reversed()).forEachOrdered(x -> sortedRecipes.add(x.getKey()));
        return sortedRecipes;
    }

    List<Recipe> get20bestMatchingRecipes(Storage storage, List<Recipe> recipes) {
        List<Recipe> sortedRecipes = sortListOfRecipesBasedOnNumberOfIngredientsInStorage(storage, recipes);
        List<Recipe> bestMatchingRecipes = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            try {
                bestMatchingRecipes.add(sortedRecipes.get(i));
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
        return bestMatchingRecipes;
    }

    double getMatchingPercentage(Storage storage, Recipe recipe) {
        double count = 0;
        for (Ingredient ingredient : storage.getIngredients()) {
            if (recipe.containsIngredient(ingredient)) count++;
        }
        double match = count / recipe.getIngredients().size();
        return match;
    }

    List<Ingredient> getMatchingIngredients(Recipe recipe, Storage storage) {
        List<Ingredient> matchingIngredients = new ArrayList<Ingredient>();

        for (Ingredient ingredient : storage.getIngredients()) {
            if (recipe.containsIngredient(ingredient)){
                matchingIngredients.add(ingredient);
            }
        }
        return matchingIngredients;
    }

    List<Recipe> getAllRecipes() {
        return dataAccessFacade.getAllRecipes();
    }

    List<Ingredient> getIngredientsNotInStorage(Storage storage){
        List<Ingredient> ingredients = dataAccessFacade.getAllIngredients();
        List<Ingredient> ingredientsNotInStorage = new ArrayList<>();
        for (Ingredient i : ingredients) {
            if (!storage.containsIngredient(i))
                ingredientsNotInStorage.add(i);
        }
        return ingredientsNotInStorage;
    }

    List<Ingredient> getAllIngredients(){
        return dataAccessFacade.getAllIngredients();
    }
}
