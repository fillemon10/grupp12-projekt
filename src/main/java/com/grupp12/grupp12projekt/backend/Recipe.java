package com.grupp12.grupp12projekt.backend;

import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;

import java.util.List;

@Document(collection = "recipes", schemaVersion = "1.0")
public class Recipe {
    @Id
    private int id;
    private String name;
    private List<Ingredient> ingredients;
    private String rating;
    public double matchingPercentage = 0;

    public double getMatchingPercentage() {
        return matchingPercentage;
    }

    public void setMatchingPercentage(double matchingPercentage) {
        this.matchingPercentage = matchingPercentage;
    }



    public Recipe(int id, String name, List<Ingredient> ingredients, String rating) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.rating = rating;



        //this.img = img
        //this.instructions = instructions
        //this.time = time
    }

    public List<Ingredient> getContents(){
        return ingredients;
    }

    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public List<Ingredient> getIngredients() {
        return ingredients;
    }
    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
    public String getRating() {
        return rating;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }

    public boolean containsIngredient(Ingredient ingredient) {
        for (Ingredient recipeIngredient :
                ingredients) {
            if (recipeIngredient.getId() == ingredient.getId())
                return true;
        }
        return false;
    }
}
