package com.grupp12.grupp12projekt.backend.dataAccess;

import com.grupp12.grupp12projekt.backend.Ingredient;
import com.grupp12.grupp12projekt.backend.Recipe;
import com.grupp12.grupp12projekt.backend.Storage;
import com.grupp12.grupp12projekt.backend.User;

import java.util.ArrayList;
import java.util.List;

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

    public IngredientJsonDA getIngredientDataAccess() {
        return ingredientDataAccess;
    }

    public RecipeJsonDA getRecipeDataAccess() {
        return recipeDataAccess;
    }

    public UserJsonDA getUserDataAccess() {
        return userDataAccess;
    }

    public StorageJsonDA getStorageDataAccess() {
        return storageDataAccess;
    }

    public List<User> getAllUsers() {
        return userDataAccess.getAll();
    }

    public Ingredient getIngredientById(int id) {
        return ingredientDataAccess.getById(id);
    }

    public List<Recipe> getAllRecipes() {
        return recipeDataAccess.getAll();
    }
    public List<Ingredient> getAllIngredients() {
        return ingredientDataAccess.getAll();
    }

    public Recipe getRecipeById(int id) {
        return recipeDataAccess.getById(id);
    }
    public void addUserToDatabase(String username, String password) {
        User userToAdd = new User();
        userToAdd.setUsername(username);
        userToAdd.setPassword(password);
        userDataAccess.add(userToAdd);
    }
    public void addStorageToDatabase(Storage storage) {
        storageDataAccess.add(storage);
    }
    public Storage getStorageByStorageCode(int storageCode) {
        return storageDataAccess.getByStorageCode(storageCode);
    }
}