package com.grupp12.grupp12projekt.backend;

import java.util.*;

public class Storage {
    private int id;
    private int storageCode;
    private List<Ingredient> ingredients;

    public Storage(int id, int storageCode, List<Ingredient> ingredients) {
        this.id = id;
        this.storageCode = storageCode;
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
