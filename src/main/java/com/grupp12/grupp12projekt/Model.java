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
    private static RecipeSearch recipeSearch;
    private static Model instance;
    private List<Recipe> recipes;
    private List<Recipe> filteredRecipes;
    private List<Observer> observers;
    private Authentication authentication;

    private StorageHandler storageHandler;

    public static Model getInstance() {
        if (instance == null)
            instance = new Model();
        return instance;
    }

    //Empty constructor
    private Model() {
        //In order to test GUI before real database is connected
        //makeDefaultDatabase();
        authentication = Authentication.getInstance();
        storageHandler = StorageHandler.getInstance();

        observers = new ArrayList<>();

        if (recipeSearch == null)
            recipeSearch = new RecipeSearch();

    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public void setCurrentUserStorageId(int id){
        this.currentUser.setStorageID(id);
        this.storage = storageHandler.getStorageFromDatabase(currentUser.getStorageID());
        notifyObservers();
    }

    public Storage getStorage() {
        this.storage = storageHandler.getStorageFromDatabase(currentUser.getStorageID());
        return this.storage;
    }

    public List<Ingredient> getStorageContent(){
        storage = getStorage();
        return this.storage.getIngredients();
    }

    public void setRecipeSearch(RecipeSearch recipeSearch) {
        this.recipeSearch = recipeSearch;
    }

    public void deleteStorageIngredient(Ingredient ingredient){
        this.storage.removeIngredient(ingredient);
        notifyObservers();
    }

    public List<Recipe> get20bestMatchingRecipes(){
        recipes = recipeSearch.get20bestMatchingRecipes(this.storage);
        return recipes;
    }


    public List<Ingredient> getMatchingIngredients(Recipe recipe) {
        return recipeSearch.getMatchingIngredients(recipe, this.storage);
    }
    public List<Ingredient> getNonMatchingIngredients(Recipe recipe){
        return recipeSearch.getNonMatchingIngredients(recipe, this.storage);
    }

    public double getMatchingPercentage(Recipe recipe) {
        return recipeSearch.getMatchingPercentage(this.storage, recipe);
    }

    public List<Recipe> getRecipes() {
        return recipeSearch.getAllRecipes();
    }

    public List<Recipe> getFilteredRecipes() {
        return filteredRecipes;
    }

    public List<Ingredient> findIngredients(String s) {
        return recipeSearch.findIngredients(s);
    }

    public void filterByIngredient(Ingredient ingredient) {
        //TODO make methods void for Observer pattern
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

    public void notifyObservers() {
        this.observers.forEach(x -> x.onNotify());
    }


    public void createNewUser(String signUpUname, String signUpPword) {
        authentication.registerUser(signUpUname, signUpPword);
        logInUser(signUpUname, signUpPword);
    }


    public void logInUser(String logInUname, String logInPword) {
        User user = authentication.loginUser(logInUname, logInPword);
        if(user != null){
            this.currentUser = user;
            this.storage = storageHandler.getStorageFromDatabase(currentUser.getStorageID());
        }
    }

    public User getCurrentUser(){
        return currentUser;
    }

    public void addIngredientToStorage(Ingredient ingredient){
        storage.addIngredient(ingredient);
        storageHandler.updateStorageInDatabase(storage);
        notifyObservers();
    }

    public void addStorageToDatabase(Storage storage){
        storageHandler.addStorageToDatabase(storage);
    }

    public int getCurrentUsersStorageID(){
        return currentUser.getStorageID();
    }

}
