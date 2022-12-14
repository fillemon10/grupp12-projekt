package com.grupp12.grupp12projekt.backend;

import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;

import java.util.List;

/**
 * Class for the storage instances
 */

@Document(collection = "storages", schemaVersion = "1.0")
public class Storage {
    @Id
    private int id;
    private List<Ingredient> ingredients;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * method for adding the supplied ingredient to this storage
     * @param ingredient supplied ingredient
     */

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    /**
     * method for removing this ingredient from this storage
     * @param ingredient
     */

    public void removeIngredient(Ingredient ingredient) {
        ingredients.remove(ingredient);
    }

    public boolean containsIngredient(Ingredient ingredient) {
        for (Ingredient i :
                ingredients) {
            if (i.getId() == ingredient.getId())
                return true;
        }
        return false;
    }

}
