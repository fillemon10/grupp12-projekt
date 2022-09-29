package com.grupp12.grupp12projekt;

import com.grupp12.grupp12projekt.backend.*;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

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

    public User loadUserFromFile(){
        try {
            File myObj = new File("src/main/resources/loginDetails.txt");
            Scanner myReader = new Scanner(myObj);
            String username = myReader.nextLine();
            String password = myReader.nextLine();
            myReader.close();
            return new User(0, username, password, 0, null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void login(){
        User user = loadUserFromFile();
        if(user != null){
            //user = database.findUser(user);
            currentUser = user;
        }
    }


    ArrayList<Recipe> filterByIngredient(Ingredient ingredient) {
        return recipeSearch.filterByIngredient(ingredient);
    }
}
