package com.grupp12.grupp12projekt.backend;

import com.grupp12.grupp12projekt.Observable;
import com.grupp12.grupp12projekt.Observer;
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
    private static List<Observer> observers;
    private static Authentication authentication;
    private static StorageHandler storageHandler;
    private static RecipeSearch recipeSearch;


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

    /**
     * method for getting the latest updated storage from the database
     * @return returns this storage
     */

    public Storage getStorage() {
        this.storage = storageHandler.getStorageFromDatabase(currentUser.getStorageID());
        return this.storage;
    }

    /**
     * method for getting all the ingredients in a storage
     * @return returns a list of all the ingredients in this storage
     */

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
     * @return returns a list containing the best recipe matches recipes based on the supplied recipes and storage
     */

    public List<Recipe> get20bestMatchingRecipes(List<Recipe> recipes) {
        return recipeSearch.getBestMatchingRecipes(this.storage, recipes, 20);
    }


    /**
     * method that is supplied with this recipe and checks which of the ingredients in the supplied recipe that the storage also contains and returns a list of matching ingredients.
     * @param recipe supplied recipe
     * @return a list of matching ingredients
     */
    public List<Ingredient> getMatchingIngredients(Recipe recipe) {
        return recipeSearch.getMatchingIngredients(recipe, this.storage);
    }

    /**
     * method that returns a  matching percentage based on the number of ingredients in the supplied recipe that this storage also contains.
     * @param recipe
     * @return
     */

    public double getMatchingPercentage(Recipe recipe) {
        return recipeSearch.getMatchingPercentage(this.storage, recipe);
    }

    /**
     * method that returns all list of all the recipes in the program
     * @return returns a list of all the recipes in the program
     */

    public List<Recipe> getAllRecipes() {
        return recipeSearch.getAllRecipes();
    }

    public List<Recipe> getFilteredRecipes() {
        return filteredRecipes;
    }

    /**
     * method that is supplied a string and returns all ingredients in the program that matches the supplied string. The method used in the find recipe page when the user
     * @param s
     * @return
     */

    public List<Ingredient> findIngredients(String s) {
        return recipeSearch.findIngredients(s);
    }

    /**
     * method that filters the recipe search based on a supplied ingredient and returns a list of recipes that contains the supplied ingredient
     * @param ingredient supplied ingredient
     */

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

    public void notifyObservers() {
        this.observers.forEach(x -> x.onNotify());
    }

    /**
     * method for creating/registering a new user of the program
     * @param signUpUname supplied username for registration
     * @param signUpPword supplied password for registration
     */

    public void createNewUser(String signUpUname, String signUpPword) {
        authentication.registerUser(signUpUname, signUpPword);
        addNewStorageToDatabase();
        logInUser(signUpUname, signUpPword);
    }

    /**
     * method for the log in of a user based on supplied username and password
     * @param logInUname supplied username
     * @param logInPword supplied password
     */

    public void logInUser(String logInUname, String logInPword) {
        User user = authentication.loginUser(logInUname, logInPword);
        this.currentUser = user;
        this.storage = storageHandler.getStorageFromDatabase(currentUser.getStorageID());
    }


    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * method for adding this ingredient to a storage
     * @param ingredient supplied ingredient to add to the storage
     */

    public void addIngredientToStorage(Ingredient ingredient) {
        storage.addIngredient(ingredient);
        storageHandler.updateStorageInDatabase(storage);
        notifyObservers();
    }


    private void addNewStorageToDatabase() {
        storage = new Storage();
        List<Ingredient> ingredients = new ArrayList<Ingredient>();
        storage.setIngredients(ingredients);
        storageHandler.addNewStorageToDatabase(storage);
    }

    public int getCurrentUsersStorageID() {
        return currentUser.getStorageID();
    }

    /**
     * method that returns available ingredients that has not been added to this storage
     * @return a list of available ingredients that can be added to this storage
     */

    public List<Ingredient> getIngredientsNotInStorage() {
        return recipeSearch.getIngredientsNotInStorage(this.storage);
    }

    /**
     * method for logging out a user from the program
     */

    public void logout(){
        this.currentUser = null;
        this.storage = null;
    }
}
