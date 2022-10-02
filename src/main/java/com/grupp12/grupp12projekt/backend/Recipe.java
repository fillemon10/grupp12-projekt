package com.grupp12.grupp12projekt.backend;

import java.util.List;


public class Recipe {
    private int ID;
    private String name;
    private List<Ingredient> ingredients;
    private String rating;

    public double getMatchingprocentage() {
        return matchingprocentage;
    }

    public void setMatchingprocentage(double matchingprocentage) {
        this.matchingprocentage = matchingprocentage;
    }

    public double matchingprocentage = 0;


    public List<Ingredient> getIngredients() {
        return ingredients;
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

    public boolean containsIngredient(Ingredient ingredient) {
        for (Ingredient recipeIngredient :
                ingredients) {
            if (recipeIngredient.getID() == ingredient.getID())
                return true;
        }
        return false;
    }
}
