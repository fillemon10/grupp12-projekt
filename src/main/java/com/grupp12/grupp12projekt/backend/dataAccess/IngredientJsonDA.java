package com.grupp12.grupp12projekt.backend.dataAccess;

import com.grupp12.grupp12projekt.backend.Ingredient;
import com.grupp12.grupp12projekt.backend.User;
import io.jsondb.JsonDBTemplate;

import java.util.ArrayList;
import java.util.List;

public class IngredientJsonDA implements IDataAccess<Ingredient> {
    private JsonDBTemplate connection = ConnectionJson.getConnection();
    private List<Ingredient> ingredients = new ArrayList<>();
    @Override
    public Ingredient getById(long id) {
        String jxQuery = String.format("/.[id='%s']", id);
        return connection.find(jxQuery, Ingredient.class).get(0);
    }

    @Override
    public List<Ingredient> getAll() {
        ingredients = connection.findAll(Ingredient.class);
        return ingredients;
    }

    @Override
    public void add(Ingredient ingredient) {

    }

    @Override
    public void update(Ingredient ingredient) {

    }

    @Override
    public void delete(Ingredient ingredient) {

    }
}

