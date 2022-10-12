package com.Backend;

import com.grupp12.grupp12projekt.backend.Ingredient;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class IngredientTest {
    Ingredient ingredient = new Ingredient(123, "Flour");

    @Test
    public void getNameTest() {
        assertEquals(ingredient.getName(), "Flour");
    }

    @Test
    public void getIDTest() {
        assertEquals(ingredient.getID(), 123);
    }
}
