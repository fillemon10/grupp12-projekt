package com.Backend;

import com.grupp12.grupp12projekt.backend.Ingredient;
import com.grupp12.grupp12projekt.backend.Recipe;
import com.grupp12.grupp12projekt.backend.User;
import com.grupp12.grupp12projekt.backend.dataAccess.JsonDBUserDataAccess;
import com.grupp12.grupp12projekt.backend.dataAccess.IDataAccess;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Long.parseLong;

public class UserTest {
    User myUser = new User();
    Ingredient butter = new Ingredient(123, "Butter");
    Ingredient milk = new Ingredient(123, "Milk");
    List<Ingredient> ingredients = new ArrayList<Ingredient>();

    /*@Test
    public void addRecipeToFavoritesList() {
        ingredients.add(butter);
        ingredients.add(milk);

        Recipe recipe = new Recipe(123, "Butter and milk", ingredients, "7");
        //myUser.addRecipeToFavorite(recipe);

        assertTrue(myUser.getFavorites().contains(recipe));
    }

    @Test
    public void removeRecipeFromFavoritesList() {
        ingredients.add(butter);
        ingredients.add(milk);

        Recipe recipe = new Recipe(123, "Butter and milk", ingredients, "7");
        //myUser.addRecipeToFavorite(recipe);
        //myUser.removeRecipeFromFavorites(recipe);

        assertFalse(myUser.getFavorites().contains(recipe));
    } */

    @Test
    public void getUser() {
        IDataAccess<User> userDataAccess = new JsonDBUserDataAccess();
        User userToAdd = new User();
        userToAdd.setId(1);
        userToAdd.setUsername("TestUser");
        userToAdd.setPassword("TestPassword");
        userToAdd.setStorageID(1);
        ArrayList<Recipe> favorites = new ArrayList<Recipe>();
        userToAdd.setFavorites(favorites);
        try {
            if (userDataAccess.getByID(userToAdd.getId()) == null) {
                userDataAccess.add(userToAdd);
            }
        } catch (Exception e) {
            userDataAccess.add(userToAdd);
        }
        User userToFind = userDataAccess.getByID(1);
        assertEquals("TestUser", userToFind.getUsername());
    }

}
