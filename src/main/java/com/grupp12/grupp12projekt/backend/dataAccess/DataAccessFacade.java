package com.grupp12.grupp12projekt.backend.dataAccess;

import com.grupp12.grupp12projekt.backend.Ingredient;
import com.grupp12.grupp12projekt.backend.Recipe;
import com.grupp12.grupp12projekt.backend.Storage;
import com.grupp12.grupp12projekt.backend.User;

import java.util.List;

/**
 * Facade class for the database that increases the level of abstraction
 */

public class DataAccessFacade {
    private static DataAccessFacade instance;
    private IngredientJsonDA ingredientDataAccess;
    private RecipeJsonDA recipeDataAccess;
    private UserJsonDA userDataAccess;
    private StorageJsonDA storageDataAccess;
    private DataAccessFacade() {
        ingredientDataAccess = new IngredientJsonDA();
        recipeDataAccess = new RecipeJsonDA();
        userDataAccess = new UserJsonDA();
        storageDataAccess = new StorageJsonDA();
    }
    public static DataAccessFacade getInstance() {
        if (instance == null) {
            instance = new DataAccessFacade();
        }
        return instance;
    }

    /**
     * method for getting users from the database
     * @return returns a list of all users
     */
    public List<User> getAllUsers() {
        return userDataAccess.getAll();
    }

    /**
     * method for getting recipes from the database
     * @return returns a list of all recipes
     */
    public List<Recipe> getAllRecipes() {
        return recipeDataAccess.getAll();
    }

    /**
     * method for getting ingredients from the database
     * @return returns a list of all ingredients
     */
    public List<Ingredient> getAllIngredients() {
        return ingredientDataAccess.getAll();
    }

    /**
     * method for getting all the existing storages from the database
     * @return returns a list of all storages
     */
    public List<Storage> getAllStorages() {
        return storageDataAccess.getAll();
    }

    /**
     * method for adding a new user to the database that is supplied a username and password
     * @param username supplied username
     * @param password supplied username
     */
    public void addUserToDatabase(String username, String password) {
        User userToAdd = new User();
        userToAdd.setUsername(username);
        userToAdd.setPassword(password);
        userToAdd.setId(userDataAccess.getLastId()+1);
        userToAdd.setStorageID(storageDataAccess.getLastId()+1);
        userDataAccess.add(userToAdd);
    }

    /**
     * method for adding a storage to the database that is supplied with a storage.
     * @param storage supplied storage
     */
    public void addStorageToDatabase(Storage storage) {
        storageDataAccess.add(storage);
    }


    /**
     * method for updating a supplied storage in the database whenever updates are made in a storage
     * @param storage supplied storage
     */
    public void updateStorageInDatabase(Storage storage) {
        storageDataAccess.update(storage);

    }
    public void setStorageID(User user) {
        userDataAccess.update(user);
    }

}
