package com.Backend;

import com.grupp12.grupp12projekt.backend.Ingredient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class IngredientTest {
    Ingredient ingredient = new Ingredient();
    ingredient.setName("Test");
    ingredient.setId(123);

    @Test
    public void getNameTest() {
        assertEquals(ingredient.getName(), "Flour");
    }

    @Test
    public void getIDTest() {
        assertEquals(ingredient.getId(), 123);
    }
}
