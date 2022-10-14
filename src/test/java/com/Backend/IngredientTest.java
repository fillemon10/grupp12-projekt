package com.Backend;

import com.grupp12.grupp12projekt.backend.Ingredient;
import com.grupp12.grupp12projekt.backend.Recipe;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class IngredientTest {
    private Ingredient ingredient = new Ingredient();

    @Test
    public void getNameTest() {
        ingredient.setName("Test");
        assertEquals("Test", ingredient.getName());
    }

    @Test
    public void getIDTest() {
        ingredient.setId(1);
        assertEquals(1, ingredient.getId());
    }
}
