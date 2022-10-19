package com.grupp12.grupp12projekt;

import com.grupp12.grupp12projekt.backend.*;
import com.grupp12.grupp12projekt.backend.Ingredient;
import com.grupp12.grupp12projekt.backend.Recipe;
import com.grupp12.grupp12projekt.backend.Storage;
import com.grupp12.grupp12projekt.backend.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Model class that handles the logic for the entire program.
 */



public class Model implements Observable {
    private User currentUser;
    private Storage storage;
    private static Model instance;
    private List<Recipe> filteredRecipes;
    private List<Observer> observers;
    private Authentication authentication;
    private StorageHandler storageHandler;
    private RecipeSearch recipeSearch;


    public static Model getInstance() {
        if (instance == null) instance = new Model();
        return instance;
    }

    private Model() {
        authentication = Authentication.getInstance();
        storageHandler = StorageHandler.getInstance();
        recipeSearch = RecipeSearch.getInstance();
        filteredRecipes = getAllRecipes();

        observers = new ArrayList<>();
    }

    /**
     * method for setting a users Storage ID which is used for the synchronization of storages.
     * @param id is supplied
     */

    public void setCurrentUserStorageId(int id) {
        this.storage = storageHandler.getStorageFromDatabase(id);
        this.currentUser.setStorageID(id);
        authentication.setStorageID(currentUser);
        notifyObservers();
    }

    public Storage getStorage() {
        this.storage = storageHandler.getStorageFromDatabase(currentUser.getStorageID());
        return this.storage;
    }

    public List<Ingredient> getStorageContent() {
        storage = getStorage();
        return this.storage.getIngredients();
    }

    /**
     * method for deleting/removing an ingredient from storage which is used in the storage ingredient item class.
     * @param ingredient that will be deleted from the storage is supplied
     */

    public void deleteStorageIngredient(Ingredient ingredient) {
        this.storage.removeIngredient(ingredient);
        storageHandler.updateStorageInDatabase(storage);
        notifyObservers();
    }

    /**
     * method that is supplied with a list of recipes and returns a list of recipes with the 20 best matching recipes which is used in the find recipes class.
     * @param recipes supplied recipes
     * @return returns the top 20 best recipe matches recipes based on the supplied recipes and storage
     */

    public List<Recipe> get20bestMatchingRecipes(List<Recipe> recipes) {
        return recipeSearch.get20bestMatchingRecipes(this.storage, recipes);
    }


    /**
     * method that is supplied with this recipe and checks which of the ingredients in the supplied recipe that the storage also contains and returns a list of matching ingredients.
     * @param recipe supplied recipe
     * @return a list of matching ingredients
     */
    public List<Ingredient> getMatchingIngredients(Recipe recipe) {
        return recipeSearch.getMatchingIngredients(recipe, this.storage);
    }

    public double getMatchingPercentage(Recipe recipe) {
        return recipeSearch.getMatchingPercentage(this.storage, recipe);
    }

    public List<Recipe> getAllRecipes() {
        return recipeSearch.getAllRecipes();
    }

    public List<Recipe> getFilteredRecipes() {
        return filteredRecipes;
    }

    public List<Ingredient> findIngredients(String s) {
        return recipeSearch.findIngredients(s);
    }

    public void filterByIngredient(Ingredient ingredient) {
        filteredRecipes = recipeSearch.filterByIngredient(ingredient);
        notifyObservers();
    }

    @Override
    public void addObserver(Observer o) {
        this.observers.add(o);

    }

    @Override
    public void removeObserver(Observer o) {
        this.observers.remove(o);
    }

    public void clearObservers() {
        this.observers.clear();
    }

    public void notifyObservers() {
        this.observers.forEach(x -> x.onNotify());
    }

    public void createNewUser(String signUpUname, String signUpPword) {
        authentication.registerUser(signUpUname, signUpPword);
        addNewStorageToDatabase();
        logInUser(signUpUname, signUpPword);
    }


    public void logInUser(String logInUname, String logInPword) {
        User user = authentication.loginUser(logInUname, logInPword);
        this.currentUser = user;
        this.storage = storageHandler.getStorageFromDatabase(currentUser.getStorageID());
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void addIngredientToStorage(Ingredient ingredient) {
        storage.addIngredient(ingredient);
        storageHandler.updateStorageInDatabase(storage);
        notifyObservers();
    }

    public void addNewStorageToDatabase() {
        storage = new Storage();
        List<Ingredient> ingredients = new ArrayList<Ingredient>();
        storage.setIngredients(ingredients);
        storageHandler.addNewStorageToDatabase(storage);
    }

    public int getCurrentUsersStorageID() {
        return currentUser.getStorageID();
    }

    public List<Ingredient> getIngredientsNotInStorage() {
        return recipeSearch.getIngredientsNotInStorage(this.storage);
    }

    public void logout(){
        this.currentUser = null;
        this.storage = null;
    }
}
