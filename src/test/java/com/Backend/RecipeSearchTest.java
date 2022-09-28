import com.grupp12.grupp12projekt.backend.Ingredient;
import com.grupp12.grupp12projekt.backend.Recipe;
import com.grupp12.grupp12projekt.backend.RecipeSearch;
import com.grupp12.grupp12projekt.backend.Storage;
import org.junit.Test;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class RecipeSearchTest {

    @Test
    public void getMatchingIngredientsTest() {
        RecipeSearch recipeSearch = new RecipeSearch();
        
        Ingredient butter = new Ingredient(1, "Butter");
        Ingredient milk = new Ingredient(2, "Milk");
        Ingredient salt = new Ingredient(3, "Salt");
        Ingredient sugar = new Ingredient(4, "Sugar");
        Ingredient flour = new Ingredient(5, "Flour");
        Ingredient eggs = new Ingredient(6, "Eggs");
        List<Ingredient> ingredients = new ArrayList<Ingredient>();
        ingredients.add(butter);
        ingredients.add(milk);
        ingredients.add(salt);
        ingredients.add(sugar);
        ingredients.add(flour);
        ingredients.add(eggs);
        Recipe recipe = new Recipe(123, "Pancakes", ingredients, "7");

        List<Ingredient> ingredients2 = new ArrayList<Ingredient>();

        ingredients2.add(butter);
        ingredients2.add(milk);
        Ingredient cheese = new Ingredient(7, "Cheese");
        Ingredient chicken = new Ingredient(8, "Chicken");

        ingredients2.add(cheese);
        ingredients2.add(chicken);


        Storage storage = new Storage(123, 1234, ingredients2);

        List<Ingredient> ingredients3 = new ArrayList<Ingredient>();
        ingredients3.add(butter);
        ingredients3.add(milk);
        assertEquals(recipeSearch.getMatchingIngredients(recipe, storage), ingredients3);

    }

    @Test
    public void getNonMatchingIngredientsTest(){
        RecipeSearch recipeSearch = new RecipeSearch();

        Ingredient butter = new Ingredient(1, "Butter");
        Ingredient milk = new Ingredient(2, "Milk");
        Ingredient salt = new Ingredient(3, "Salt");
        Ingredient sugar = new Ingredient(4, "Sugar");
        Ingredient flour = new Ingredient(5, "Flour");
        Ingredient eggs = new Ingredient(6, "Eggs");
        List<Ingredient> ingredients = new ArrayList<Ingredient>();
        ingredients.add(butter);
        ingredients.add(milk);
        ingredients.add(salt);
        ingredients.add(sugar);
        ingredients.add(flour);
        ingredients.add(eggs);
        Recipe recipe = new Recipe(123, "Pancakes", ingredients, "7");

        List<Ingredient> ingredients2 = new ArrayList<Ingredient>();

        ingredients2.add(butter);
        ingredients2.add(milk);
        Ingredient cheese = new Ingredient(7, "Cheese");
        Ingredient chicken = new Ingredient(8, "Chicken");

        ingredients2.add(cheese);
        ingredients2.add(chicken);


        Storage storage = new Storage(124, 1234, ingredients2);

        List<Ingredient> ingredients3 = new ArrayList<Ingredient>();

        
        ingredients3.add(salt);
        ingredients3.add(sugar);
        ingredients3.add(flour);
        ingredients3.add(eggs);
        //assertEquals(recipeSearch.getNonMatchingIngredients(recipe, storage), ingredients3);
        assertEquals(ingredients3, recipeSearch.getNonMatchingIngredients(recipe, storage));
    }



}
