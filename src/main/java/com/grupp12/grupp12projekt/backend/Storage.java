package com.grupp12.grupp12projekt.backend;

import java.util.List;

public class Storage {
    private int ID;
    private int storageCode;
    private List<Ingredient> ingredients;

    public Storage(int ID, int storageCode)
    {
        this.ID = ID;
        this.storageCode = storageCode;
    }

    public void addIngredient(Ingredient ingredient){
        ingredients.add(ingredient);
    }


    public void removeIngredient(Ingredient ingredient){
        ingredients.remove(ingredient);
    }

    public List<Ingredient> getContents(){
        return ingredients;
    }

}
