package com.grupp12.grupp12projekt.backend;

import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;

import java.util.*;

@Document(collection = "storages", schemaVersion = "1.0")
public class Storage {
    @Id
    private int id;
    private List<Ingredient> ingredients;

    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public List<Ingredient> getIngredients() {
        return ingredients;
    }
    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public void removeIngredient(Ingredient ingredient) {
        ingredients.remove(ingredient);
    }

    public void containsIngredient(Ingredient ingredient) {
        ingredients.contains(ingredient);
    }

}
