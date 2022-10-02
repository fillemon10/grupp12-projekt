package com.grupp12.grupp12projekt.backend;

import javafx.scene.image.Image;

import java.net.IDN;
import java.util.ArrayList;
import java.util.List;


public class Recipe {
    private int ID;
    private String name;
    private List<Ingredient> ingredients;
    private String rating;

    public double matchingprocentage = 0;

    public double getMatchingprocentage() {
        return matchingprocentage;
    }

    public void setMatchingprocentage(double matchingprocentage) {
        this.matchingprocentage = matchingprocentage;
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


}
