package com.Backend;

import com.grupp12.grupp12projekt.backend.Ingredient;
import com.grupp12.grupp12projekt.backend.Recipe;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RecipeTest {

    private List<Ingredient> ingredients = new ArrayList<Ingredient>();
    private Ingredient butter = new Ingredient(1, "Butter");
    private Ingredient milk = new Ingredient(2, "Milk");



    @Test
    public void checkIfContains() {
        ingredients.add(butter);
        ingredients.add(milk);
        Recipe recipe = new Recipe(123, "Butter and milk", ingredients, "7");

        assertTrue(recipe.containsIngredient(butter));

    }

    @Test
    public void checkIfNotContains() {
        ingredients.add(butter);
        ingredients.add(milk);
        Recipe recipe = new Recipe(123, "Butter and milk", ingredients, "7");

        Ingredient salt = new Ingredient(3, "Salt");

        assertFalse(recipe.containsIngredient(salt));
    }

}
