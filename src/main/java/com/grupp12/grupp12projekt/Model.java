package com.grupp12.grupp12projekt;

import com.grupp12.grupp12projekt.backend.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Model {
    private User currentUser;
    private Storage storage;
    private RecipeSearch recipeSearch;

    private Database database;

    public Model(User currentUser, Storage storage, RecipeSearch recipeSearch){
        this.currentUser = currentUser;
        this.storage = storage;
        this.recipeSearch = recipeSearch;
    }

    List<Ingredient> getMatchingIngredients(Recipe recipe){
        return recipeSearch.getMatchingIngredients(recipe, this.storage);
    }

    public void saveUser(){
        try {
            FileWriter myWriter = new FileWriter("src/main/resources/loginDetails.txt");
            myWriter.write(currentUser.getUsername() + "\n" + currentUser.getPassword());
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
