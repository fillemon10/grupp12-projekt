package com.Backend;

import com.grupp12.grupp12projekt.backend.Recipe;
import com.grupp12.grupp12projekt.backend.Storage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.grupp12.grupp12projekt.backend.Model;

public class ModelTest {
    Model model = Model.getInstance();



    @Test
    public void getStorageContentTest(){
        model.logInUser("1","1");
        assertTrue(model.getStorageContent().size() > 0);


    }

    @Test
    public void get20bestMatchingRecipesTest(){
        model.logInUser("1","1");

        assertTrue(model.get20bestMatchingRecipes(model.getAllRecipes()).size() == 20);



    }

    @Test
    public void getMatchingIngredientsTest(){
        model.logInUser("1","1");
        Recipe r =  model.getAllRecipes().get(241);
        assertTrue(model.getMatchingIngredients(r).size() > 0);


    }

    @Test
    public void getMatchingPercentageTest(){
        model.logInUser("1","1");
        Recipe r =  model.getAllRecipes().get(241);
        assertEquals(0.25, model.getMatchingPercentage(r));
    }

    @Test
    public void getFilteredRecipesTest(){
        model.logInUser("1","1");
        assertTrue(model.getFilteredRecipes().size() > 0);
    }

    @Test
    public void findIngredientsTest(){
        model.logInUser("1","1");
        assertTrue(model.findIngredients("al").size() > 0);

    }

    @Test
    public void getCurrentUsersStorageIDTest(){
        model.logInUser("1","1");
        assertTrue(model.getCurrentUsersStorageID() > 0);
    }

    @Test
    public void getIngredientsNotInStorageTest(){
        model.logInUser("1","1");
        assertTrue(model.getIngredientsNotInStorage().size() > 0);


    }







}
