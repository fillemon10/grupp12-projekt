package com.grupp12.grupp12projekt.backend.dataAccess;

import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;

@Document(collection = "recipeIngredientJunction", schemaVersion = "1.0")
public class RecipeIngredientJunction {
    @Id
    private int r;
    private int i;

    public int getI() {
        return i;
    }
    public int getR() {
        return r;
    }
    public void setI(int i) {
        this.i = i;
    }
    public void setR(int r) {
        this.r = r;
    }
    public int getIngredientId() {
        return i;
    }
    public int getRecipeId() {
        return r;
    }
    public void setIngredientId(int i) {
        this.i = i;
    }
    public void setRecipeId(int r) {
        this.r = r;
    }

}
