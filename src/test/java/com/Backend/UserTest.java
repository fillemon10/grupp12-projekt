package com.Backend;

import com.grupp12.grupp12projekt.backend.Ingredient;
import com.grupp12.grupp12projekt.backend.Recipe;
import com.grupp12.grupp12projekt.backend.User;
import com.grupp12.grupp12projekt.backend.dataAccess.UserJsonDA;
import com.grupp12.grupp12projekt.backend.dataAccess.IDataAccess;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Long.parseLong;

public class UserTest {
    User myUser = new User();
//    Ingredient butter = new Ingredient(123, "Butter");
//    Ingredient milk = new Ingredient(123, "Milk");
//    List<Ingredient> ingredients = new ArrayList<Ingredient>();
//
//    @Test
//    public void addRecipeToFavoritesList() {
//        ingredients.add(butter);
//        ingredients.add(milk);
//
//        Recipe recipe = new Recipe(123, "Butter and milk", ingredients, "7");
//        //myUser.addRecipeToFavorite(recipe);
//
//        assertTrue(myUser.getFavorites().contains(recipe));
//    }
//
//    @Test
//    public void removeRecipeFromFavoritesList() {
//        ingredients.add(butter);
//        ingredients.add(milk);
//
//        Recipe recipe = new Recipe(123, "Butter and milk", ingredients, "7");
//        //myUser.addRecipeToFavorite(recipe);
//        //myUser.removeRecipeFromFavorites(recipe);
//
//        assertFalse(myUser.getFavorites().contains(recipe));
//    }

    @Test
    public void getUser() {
        IDataAccess<User> userDataAccess = new UserJsonDA();
        User userToAdd = new User();
        userToAdd.setId(5);
        userToAdd.setUsername("TestUser");
        userToAdd.setPassword("TestPassword");
        userToAdd.setStorageID(1);
        try {
            if (userDataAccess.getById(userToAdd.getId()) == null) {
                userDataAccess.add(userToAdd);
            }
        } catch (Exception e) {
            userDataAccess.add(userToAdd);
        }
        User userToFind = userDataAccess.getById(1);
        assertEquals("TestUser", userToFind.getUsername());
    }

}
