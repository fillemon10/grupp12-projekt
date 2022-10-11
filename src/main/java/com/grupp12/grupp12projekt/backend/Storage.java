package com.grupp12.grupp12projekt.backend;

import java.util.*;

public class Storage {
    private int id;
    private int storageCode;
    private List<Ingredient> ingredients;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStorageCode() {
        return storageCode;
    }

    public void setStorageCode(int storageCode) {
        this.storageCode = storageCode;
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

    public List<Ingredient> getContents() {
        return ingredients;
    }

}
