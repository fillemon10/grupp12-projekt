package com.grupp12.grupp12projekt.backend;

import javafx.scene.image.Image;

import java.net.IDN;
import java.util.List;

public class Recipe {
    private int ID;
    private String name;
    private List<Ingredient> ingredients;
    private String rating;
    //private Image img;
    //private String instructions;


    public Recipe(int ID, String name, List<Ingredient> ingredients, String rating, Image img, String instructions) {
        this.ID = ID;
        this.name = name;
        this.ingredients = ingredients;
        this.rating = rating;
        //this.img = img;
        //this.instructions = instructions;
    }

}
