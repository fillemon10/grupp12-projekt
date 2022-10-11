package com.grupp12.grupp12projekt.backend.dataAccess;

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
}
