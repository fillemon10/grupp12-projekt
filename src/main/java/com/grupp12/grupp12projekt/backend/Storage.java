package com.grupp12.grupp12projekt.backend;

import java.util.*;

public class Storage {
    private int ID;
    private int storageCode;
    private List<Ingredient> ingredients;

    public Storage(int ID, int storageCode, List<Ingredient> ingredients) {
        this.ID = ID;
        this.storageCode = storageCode;
        this.ingredients = ingredients;
        this.addIngredient(new Ingredient(1, "fisk"));
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
