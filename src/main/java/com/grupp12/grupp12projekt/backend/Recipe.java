package com.grupp12.grupp12projekt.backend;

import java.util.List;


public class Recipe {
    private int ID;
    private String name;
    private List<Ingredient> ingredients;
    private String rating;
    private int matchingPercentage;

    public int getMatchingPercentage() {
        return matchingPercentage;
    }

    public void setMatchingPercentage(int matchingPercentage) {
        this.matchingPercentage = matchingPercentage;
    }



    public Recipe(int ID, String name, List<Ingredient> ingredients, String rating) {
        this.ID = ID;
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

    public int getID(){
        return ID;
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
