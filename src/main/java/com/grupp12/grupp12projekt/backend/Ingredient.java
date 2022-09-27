package com.grupp12.grupp12projekt.backend;

public class Ingredient {

    private int ID;
    private String name;



    public Ingredient(int ID, String name){

        this.ID = ID;
        this.name = name;

    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }
}
