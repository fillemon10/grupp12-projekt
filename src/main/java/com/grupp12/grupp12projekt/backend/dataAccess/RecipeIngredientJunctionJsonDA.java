package com.grupp12.grupp12projekt.backend.dataAccess;

import io.jsondb.JsonDBTemplate;

import java.util.ArrayList;
import java.util.List;

public class RecipeIngredientJunctionJsonDA implements IDataAccess<RecipeIngredientJunction> {
    private JsonDBTemplate connection = ConnectionJson.getConnection();
    private List<RecipeIngredientJunction> junctionList = new ArrayList<>();
    @Override
    public RecipeIngredientJunction getById(long id) {
        return null;
    }
    @Override
    public List<RecipeIngredientJunction> getAll() {
        return null;
    }

    @Override
    public void add(RecipeIngredientJunction recipeIngredientJunction) {

    }

    @Override
    public void update(RecipeIngredientJunction recipeIngredientJunction, String[] params) {

    }

    @Override
    public void delete(RecipeIngredientJunction recipeIngredientJunction) {

    }

    public List<RecipeIngredientJunction> getByRecipeId(long id) {
        String jxQuery = String.format("/.[r='%s']", id);
        return connection.find(jxQuery, RecipeIngredientJunction.class);
    }

    public List<RecipeIngredientJunction> getByIngredientId(long id) {
        String jxQuery = String.format("/.[i='%s']", id);
        return connection.find(jxQuery, RecipeIngredientJunction.class);
    }
}

