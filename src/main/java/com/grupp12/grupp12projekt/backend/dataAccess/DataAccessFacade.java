package com.grupp12.grupp12projekt.backend.dataAccess;

import com.grupp12.grupp12projekt.backend.Ingredient;
import com.grupp12.grupp12projekt.backend.Recipe;
import com.grupp12.grupp12projekt.backend.User;

import java.util.List;

public class DataAccessFacade {
    private static DataAccessFacade instance;
    private IngredientJsonDA ingredientDataAccess;
    private RecipeJsonDA recipeDataAccess;
    private UserJsonDA userDataAccess;

    private RecipeIngredientJunctionJsonDA recipeIngredientJunctionDataAccess;

    private DataAccessFacade() {
        ingredientDataAccess = new IngredientJsonDA();
        recipeDataAccess = new RecipeJsonDA();
        userDataAccess = new UserJsonDA();
        recipeIngredientJunctionDataAccess = new RecipeIngredientJunctionJsonDA();
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

    public RecipeIngredientJunctionJsonDA getRecipeIngredientJunctionDataAccess() {
        return recipeIngredientJunctionDataAccess;
    }
    public List<User> getAllUsers() {
        return userDataAccess.getAll();
    }

    public List<RecipeIngredientJunction> getAllByRecipeId(int recipeId) {
        return recipeIngredientJunctionDataAccess.getByRecipeId(recipeId);
    }
    public List<RecipeIngredientJunction> getAllByIngredientId(int ingredientId) {
        return recipeIngredientJunctionDataAccess.getByIngredientId(ingredientId);
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
}
