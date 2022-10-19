package com.Backend;

import com.grupp12.grupp12projekt.Model;
import com.grupp12.grupp12projekt.backend.Ingredient;
import com.grupp12.grupp12projekt.backend.Storage;
import org.junit.jupiter.api.Test;

import java.util.List;


public class StorageTest {
    private Model model = Model.getInstance();
    @Test
    public void getStorageTest(){
        model.logInUser("username", "password");
        model.getStorage();
    }

    @Test
    public void addStorageTest(){
        Storage storage = new Storage();
        storage.setId(12);
        List<Ingredient> ingredients = model.getAllRecipes().get(3).getIngredients();
        storage.setIngredients(ingredients);

        model.addNewStorageToDatabase();
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
