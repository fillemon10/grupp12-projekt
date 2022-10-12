package com.Backend;

import com.grupp12.grupp12projekt.backend.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import javax.xml.crypto.Data;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class RecipeSearchTest {
    RecipeSearch recipeSearch = new RecipeSearch();

    Ingredient butter = new Ingredient(1, "Butter");
    Ingredient milk = new Ingredient(2, "Milk");
    Ingredient salt = new Ingredient(3, "Salt");
    Ingredient sugar = new Ingredient(4, "Sugar");
    Ingredient flour = new Ingredient(5, "Flour");
    Ingredient eggs = new Ingredient(6, "Eggs");
    Ingredient water = new Ingredient(0, "Water");
    Ingredient bakingSoda = new Ingredient(9, "Baking soda");

    Recipe makePancakes() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(butter);
        ingredients.add(milk);
        ingredients.add(salt);
        ingredients.add(sugar);
        ingredients.add(flour);
        ingredients.add(eggs);
        return new Recipe(123, "Pancakes", ingredients, "7");
    }

    Recipe makeStickBread() {
        List<Ingredient> stickBreadIngredients = new ArrayList<>();
        stickBreadIngredients.add(flour);
        stickBreadIngredients.add(water);
        stickBreadIngredients.add(bakingSoda);

        return new Recipe(938, "Stick bread", stickBreadIngredients, "1");
    }

    public void setUpTestDatabase() {
        //Set up Database with pancakes and stick bread as recipes
        Database instance = Database.getInstance();
        Recipe pancakes = makePancakes();
        Recipe stickBread = makeStickBread();

        instance.addRecipe(pancakes);
        instance.addRecipe(stickBread);
    }

    @Test
    public void getMatchingPercentageTest() {
        RecipeSearch recipeSearch = new RecipeSearch();

        Ingredient butter = new Ingredient(1, "Butter");
        Ingredient milk = new Ingredient(2, "Milk");
        Ingredient salt = new Ingredient(3, "Salt");
        Ingredient sugar = new Ingredient(4, "Sugar");
        Ingredient flour = new Ingredient(5, "Flour");
        List<Ingredient> recipeIngredients = new ArrayList<Ingredient>();
        recipeIngredients.add(butter);
        recipeIngredients.add(milk);
        recipeIngredients.add(salt);
        Recipe recipe = new Recipe(1, "butter, mil and salt", recipeIngredients, "7");
        List<Ingredient> storageIngredients = new ArrayList<Ingredient>();
        storageIngredients.add(salt);
        storageIngredients.add(sugar);
        storageIngredients.add(flour);
        Storage storage = new Storage(1, 2, storageIngredients);

        int expectedPercentage = 33;

        assertEquals(recipeSearch.getMatchingPercentage(storage, recipe), expectedPercentage);

    }

    @Test
    public void PrioritizeTest(){
        RecipeSearch recipeSearch = new RecipeSearch();
        Ingredient butter = new Ingredient(1, "Butter");
        Ingredient milk = new Ingredient(2, "Milk");
        Ingredient salt = new Ingredient(3, "Salt");
        Ingredient sugar = new Ingredient(4, "Sugar");
        Ingredient flour = new Ingredient(5, "Flour");
        Ingredient cream = new Ingredient(8, "cream");
        Ingredient tomato = new Ingredient(9, "tomato");
        Ingredient cucumber = new Ingredient(10, "cucumber");
        Ingredient chicken = new Ingredient(11, "chicken");
        Ingredient fish = new Ingredient(12, "fish");
        List<Ingredient> recipe1 = new ArrayList<Ingredient>();

        recipe1.add(butter);
        recipe1.add(sugar);
        recipe1.add(salt);
        recipe1.add(tomato);
        recipe1.add(fish);
        recipe1.add(chicken);
        recipe1.add(cucumber);
        Recipe recipeone = new Recipe(1,"2", recipe1, "3");
        List<Ingredient> recipe2 = new ArrayList<Ingredient>();
        recipe2.add(butter);
        recipe2.add(sugar);
        recipe2.add(salt);
        recipe2.add(tomato);
        recipe2.add(fish);
        recipe2.add(chicken);
        recipe2.add(cucumber);
        recipe2.add(cream);
        Recipe recipetwo = new Recipe(2, "3", recipe2, "4");
        List<Ingredient> recipe3 = new ArrayList<Ingredient>();
        recipe3.add(butter);
        recipe3.add(sugar);
        recipe3.add(salt);
        Recipe recipethree = new Recipe(3, "1", recipe3, "7");
        List<Ingredient> Storageingridients = new ArrayList<Ingredient>();
        List<Recipe> allrecipes = new ArrayList<Recipe>();
        allrecipes.add(recipeone);
        allrecipes.add(recipetwo);
        allrecipes.add(recipethree);

        Storageingridients.add(butter);
        Storageingridients.add(sugar);
        Storageingridients.add(salt);
        Storage storage = new Storage(5,2,Storageingridients);
        recipeSearch.prioritize(storage,allrecipes);






    }


    @Test
    public void getMatchingIngredientsTest() {
        Recipe recipe = makePancakes();

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

/*    @Test
    public void recipeContainsTest() {
        Recipe pancakes = makePancakes();
        Ingredient flour = new Ingredient(5, "Flour");
        Ingredient jam = new Ingredient(9123, "Jam");
        assertTrue(recipeSearch.recipeContains(pancakes, flour));
        assertFalse(recipeSearch.recipeContains(pancakes, jam));
    }*/

    @Test
    public void filterByIngredientTest() {
        setUpTestDatabase();
        Recipe stickBread = makeStickBread();
        Recipe pancakes = makePancakes();

        List<Recipe> filteredRecipes = recipeSearch.filterByIngredient(water);

        //Check if filteredRecipes contains recipe
        boolean containsStickBread = false;
        boolean containsPancakes = false;
        for (Recipe recipe :
                filteredRecipes) {
            if(recipe.getID() == stickBread.getID())
                containsStickBread = true;
            if(recipe.getID() == pancakes.getID())
                containsPancakes = true;
        }

        assertTrue(containsStickBread);
        assertFalse(containsPancakes);
    }

    @Test
    public void findIngredientsTest() {
        RecipeSearch recipeSearch = new RecipeSearch();

        Database instance = Database.getInstance();
        instance.addIngredient(butter);
        instance.addIngredient(milk);
        instance.addIngredient(salt);
        instance.addIngredient(sugar);
        instance.addIngredient(flour);
        instance.addIngredient(eggs);
        instance.addIngredient(water);
        instance.addIngredient(bakingSoda);

        List<Ingredient> ingredients = recipeSearch.findIngredients("er");

        boolean containsButter = false;
        boolean containsWater = false;
        boolean containsEggs = false;
        for (Ingredient i :
                ingredients) {
            if(i.getID() == butter.getID())
                containsButter = true;
            if(i.getID() == water.getID())
                containsWater = true;
            if(i.getID() == eggs.getID())
                containsEggs = true;
        }

        assertTrue(containsButter);
        assertTrue(containsWater);
        assertFalse(containsEggs);
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

/*    @Test
    public void getMatchingPercentageTest() {
        RecipeSearch recipeSearch = new RecipeSearch();

        Ingredient butter = new Ingredient(1, "Butter");
        Ingredient milk = new Ingredient(2, "Milk");
        Ingredient salt = new Ingredient(3, "Salt");
        Ingredient sugar = new Ingredient(4, "Sugar");
        Ingredient flour = new Ingredient(5, "Flour");
        List<Ingredient> recipeIngredients = new ArrayList<Ingredient>();
        recipeIngredients.add(butter);
        recipeIngredients.add(milk);
        recipeIngredients.add(salt);
        List<Ingredient> storageIngredients = new ArrayList<Ingredient>();
        storageIngredients.add(salt);
        storageIngredients.add(sugar);
        storageIngredients.add(flour);

        int expectedPercentage = 33;

        assertEquals(recipeSearch.getMatchingPercentage(storageIngredients, recipeIngredients), expectedPercentage);

    }*/
}
