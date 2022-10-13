package com.grupp12.grupp12projekt.backend.dataAccess;

import com.grupp12.grupp12projekt.backend.Recipe;
import com.grupp12.grupp12projekt.backend.User;
import io.jsondb.JsonDBTemplate;

import java.util.ArrayList;
import java.util.List;

public class RecipeJsonDA implements IDataAccess<Recipe> {

    private JsonDBTemplate connection = ConnectionJson.getConnection();
    private List<User> recipes = new ArrayList<>();
    @Override
    public Recipe getById(long id) {
        String jxQuery = String.format("/.[id='%s']", id);
        return connection.find(jxQuery, Recipe.class).get(0);
    }

    @Override
    public List<Recipe> getAll() {
        return connection.findAll(Recipe.class);
    }

    @Override
    public void add(Recipe recipe) {
    }

    @Override
    public void update(Recipe recipe, String[] params) {

    }

    @Override
    public void delete(Recipe recipe) {

    }
}

