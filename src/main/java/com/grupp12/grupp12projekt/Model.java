package com.grupp12.grupp12projekt;

import com.grupp12.grupp12projekt.backend.*;
import com.grupp12.grupp12projekt.backend.Ingredient;
import com.grupp12.grupp12projekt.backend.Recipe;
import com.grupp12.grupp12projekt.backend.Storage;
import com.grupp12.grupp12projekt.backend.User;

import java.util.ArrayList;
import java.util.List;


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

        observers = new ArrayList<>();
    }

    public void setCurrentUserStorageId(int id) {
        this.currentUser.setStorageID(id);
        this.storage = storageHandler.getStorageFromDatabase(currentUser.getStorageID());
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

    public void deleteStorageIngredient(Ingredient ingredient) {
        this.storage.removeIngredient(ingredient);
        storageHandler.updateStorageInDatabase(storage);
        notifyObservers();
    }

    public List<Recipe> get20bestMatchingRecipes(List<Recipe> recipes) {
        return recipeSearch.get20bestMatchingRecipes(this.storage, recipes);
    }

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
}
