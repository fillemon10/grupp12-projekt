package com.grupp12.grupp12projekt.backend.dataAccess;

import com.grupp12.grupp12projekt.backend.Ingredient;
import com.grupp12.grupp12projekt.backend.Recipe;
import com.grupp12.grupp12projekt.backend.Storage;
import com.grupp12.grupp12projekt.backend.User;

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
    public List<User> getAllUsers() {
        return userDataAccess.getAll();
    }
    public List<Recipe> getAllRecipes() {
        return recipeDataAccess.getAll();
    }
    public List<Ingredient> getAllIngredients() {
        return ingredientDataAccess.getAll();
    }
    public void addUserToDatabase(String username, String password) {
        User userToAdd = new User();
        userToAdd.setUsername(username);
        userToAdd.setPassword(password);
        userToAdd.setId(userDataAccess.getLastId()+1);
        userToAdd.setStorageID(storageDataAccess.getLastId()+1);
        userDataAccess.add(userToAdd);
    }
    public void addStorageToDatabase(Storage storage) {
        storageDataAccess.add(storage);
    }
    public List<Storage> getAllStorages() {
        return storageDataAccess.getAll();
    }
    public void updateStorageInDatabase(Storage storage) {
        storageDataAccess.update(storage);
    }
    public void setStorageID(User user) {
        userDataAccess.update(user);
    }

}
