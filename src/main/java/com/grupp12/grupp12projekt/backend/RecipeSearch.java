package com.grupp12.grupp12projekt.backend;

import com.grupp12.grupp12projekt.backend.dataAccess.DataAccessFacade;

import java.util.*;

public class RecipeSearch {
    private DataAccessFacade dataAccessFacade;
    private static RecipeSearch instance;

    public static RecipeSearch getInstance() {
        if (instance == null)
            instance = new RecipeSearch();
        return instance;
    }

    private RecipeSearch() {
        dataAccessFacade = DataAccessFacade.getInstance();
    }

    public List<Ingredient> findIngredients(String search) {
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
            if (recipe.containsIngredient(ingredient)) filteredRecipes.add(recipe);
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
            double match = count * (count / recipe.getIngredients().size());
            recipeIngredientCount.put(recipe, match);
        }
        List<Recipe> sortedRecipes = new ArrayList<>();
        recipeIngredientCount.entrySet().stream().sorted(Map.Entry.<Recipe, Double>comparingByValue().reversed()).forEachOrdered(x -> sortedRecipes.add(x.getKey()));
        return sortedRecipes;
    }

    public List<Recipe> get20bestMatchingRecipes(Storage storage, List<Recipe> recipes) {
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

    public double getMatchingPercentage(Storage storage, Recipe recipe) {
        double count = 0;
        for (Ingredient ingredient : storage.getIngredients()) {
            if (recipe.containsIngredient(ingredient)) count++;
        }
        double match = count / recipe.getIngredients().size();
        return match;
    }

    public List<Ingredient> getMatchingIngredients(Recipe recipe, Storage storage) {
        List<Ingredient> matchingIngredients = new ArrayList<Ingredient>();

        for (Ingredient storageIngredient : storage.getIngredients()) {
            if (recipe.containsIngredient(storageIngredient)) matchingIngredients.add(storageIngredient);
        }

        return matchingIngredients;
    }

    public List<Recipe> getAllRecipes() {
        return dataAccessFacade.getAllRecipes();
    }
}
