package com.grupp12.grupp12projekt.backend;

import java.util.List;


public class Recipe {
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

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean containsIngredient(Ingredient ingredient) {
        for (Ingredient recipeIngredient :
                ingredients) {
            if (recipeIngredient.getID() == ingredient.getID())
                return true;
        }
        return false;
    }
}
