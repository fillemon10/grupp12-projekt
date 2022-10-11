package com.grupp12.grupp12projekt.backend.dataAccess;

import com.grupp12.grupp12projekt.backend.Recipe;
import com.grupp12.grupp12projekt.backend.User;
import io.jsondb.JsonDBTemplate;

import java.util.ArrayList;
import java.util.List;

public class JsonDBRecipeDataAccess implements IDataAccess<Recipe> {

    private JsonDBTemplate connection = new JsonDBConnection().getConnection();
    private List<User> recipes = new ArrayList<>();
    @Override
    public Recipe getByID(long id) {
        return null;
    }

    @Override
    public List<Recipe> getAll() {
        return null;
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

