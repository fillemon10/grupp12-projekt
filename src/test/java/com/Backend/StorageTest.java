package com.Backend;

import com.grupp12.grupp12projekt.controllers.StorageController;
import com.grupp12.grupp12projekt.controllers.StorageIngredientController;
import com.grupp12.grupp12projekt.backend.Ingredient;
import com.grupp12.grupp12projekt.backend.Storage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class StorageTest {
    ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
    Storage myStorage = new Storage(124, 1234, ingredients);
    Ingredient butter = new Ingredient(123, "Butter");
    Ingredient milk = new Ingredient(123, "Milk");

    @Test
    public void addIngredientToStorage() {
        myStorage.addIngredient(butter);

        assertTrue(myStorage.getContents().contains(butter));
    }

    @Test
    public void removeIngredientFromStorage() {
        myStorage.addIngredient(butter);
        myStorage.addIngredient(milk);
        myStorage.removeIngredient(butter);

        assertFalse(myStorage.getContents().contains(butter));
    }

   /* @Test
    public  void removeingridient(){
        Storage myStorage = new Storage(124, 1234, ingredients);
        Ingredient butter = new Ingredient(123, "Butter");
        Ingredient milk = new Ingredient(123, "Milk");
        StorageController storageController = StorageController.getInstance();

       StorageIngredientController storageIngredientController = new StorageIngredientController(butter, );
        storageIngredientController.onClick();
        assertTrue(myStorage.getContents().contains(butter));

    }

    */


}
