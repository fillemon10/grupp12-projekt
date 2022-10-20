package com.grupp12.grupp12projekt.backend;

import com.grupp12.grupp12projekt.backend.dataAccess.DataAccessFacade;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class for finding recipes
 */
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

    /**
     * method for finding ingredients that match the search query
     * @param search
     * @return list of ingredients matching the search
     */
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

    /**
     * a filtering method for the recipe search, that is supplied an ingredient and only returns recipes that contain the supplied ingredient
     * @param ingredient supplied filtering ingredient
     * @return Returns a list with recipes that all contain the supplied ingredient
     */

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

    /**
     * method that returns a list containing the 20 best matching recipes based on the supplied list of recipes and storage.
     * @param storage supplied
     * @param recipes supplied
     * @return returns an ArrayList of the top 20 best matching recipes
     */

     List<Recipe> getBestMatchingRecipes(Storage storage, List<Recipe> recipes, int a) {
        List<Recipe> sortedRecipes = sortListOfRecipesBasedOnNumberOfIngredientsInStorage(storage, recipes);
        List<Recipe> bestMatchingRecipes = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            try {
                bestMatchingRecipes.add(sortedRecipes.get(i));
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
        return bestMatchingRecipes;
    }

    /**
     * method that returns a matching percentage based on the number of ingredients in the supplied recipe that this storage also contains.
     * @param storage supplied storage
     * @param recipe supplied recipe
     * @return returns the matching percentage as a double
     */

    double getMatchingPercentage(Storage storage, Recipe recipe) {
        double count = 0;
        for (Ingredient ingredient : storage.getIngredients()) {
            if (recipe.containsIngredient(ingredient)) count++;
        }
        double match = count / recipe.getIngredients().size();
        return match;
    }

    /**
     * method that is supplied this recipe and storage and gets the ingredients from this storage and the ingredients from this recipe and returns the ingredients from the recipe that the storage contains in a list
     * @param recipe supplied recipe
     * @param storage supplied storage
     * @return
     */

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

    /**
     * method that is supplied this storage and gets all the ingredients in this storage and returns the all the available ingredients are not added to this storage
     * @param storage supplied storage
     * @return returns a list of all the available ingredients that has not been added in the storage
     */

    List<Ingredient> getIngredientsNotInStorage(Storage storage){
        List<Ingredient> ingredients = dataAccessFacade.getAllIngredients();
        List<Ingredient> ingredientsNotInStorage = new ArrayList<>();
        for (Ingredient i : ingredients) {
            if (!storage.containsIngredient(i))
                ingredientsNotInStorage.add(i);
        }
        return ingredientsNotInStorage;
    }


}
