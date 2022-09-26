package com.grupp12.grupp12projekt.backend.BackendTests;

import com.grupp12.grupp12projekt.backend.Ingredient;
import com.grupp12.grupp12projekt.backend.Storage;
import org.junit.Test;


import static org.junit.Assert.assertFalse;

public class StorageTest {
    @Test
    public void addIngredientToStorage() {
        Ingredient butter = new Ingredient(123, "Butter");
        Ingredient milk = new Ingredient(123, "Milk");
        Storage myStorage = new Storage(124, 1234);
        myStorage.addIngredient(butter);
        myStorage.addIngredient(milk);
        myStorage.removeIngredient(butter);

        assertFalse(myStorage.getContents().contains(butter));

    }

}
