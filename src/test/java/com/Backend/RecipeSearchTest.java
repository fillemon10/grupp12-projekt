package com.Backend;

import com.grupp12.grupp12projekt.Model;
import com.grupp12.grupp12projekt.backend.*;
import com.grupp12.grupp12projekt.backend.Ingredient;
import com.grupp12.grupp12projekt.backend.Recipe;
import com.grupp12.grupp12projekt.backend.Storage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.List;

public class RecipeSearchTest {
    private Model model = Model.getInstance();

    private RecipeSearch recipeSearch = RecipeSearch.getInstance();

    @Test
    public void filterByIngredientTest() {
        Ingredient turkey = new Ingredient();
        turkey.setId(324);
        turkey.setName("turkey");
        List<Recipe> recipes = recipeSearch.filterByIngredient(turkey);
        assertTrue(recipes.size() > 0);
    }
    @Test
    public void getAllRecipesTest(){
        List<Recipe> recipes = recipeSearch.getAllRecipes();
        assertTrue(recipes.size() > 0);
    }
    @Test
    public void getAllIngredientsTest(){
        List<Ingredient> ingredients = recipeSearch.getAllIngredients();
        assertTrue(ingredients.size() > 0);
    }
    @Test
    public void findIngredientTest(){
       List<Ingredient> findIngredientList =  recipeSearch.findIngredients("al");
       assertTrue(findIngredientList.size() > 0);


    }
    @Test
    public void get20BestMatchingRecipesTest(){
        List<Recipe> bestMatchingRecipes = model.get20bestMatchingRecipes(model.getAllRecipes());
        assertTrue(bestMatchingRecipes.size() == 20);
    }

    @Test
    public void getMatchingPercentageTest(){
        List<Ingredient> i =  recipeSearch.findIngredients("turkey");
        Recipe r =  recipeSearch.getAllRecipes().get(241);
        Storage s = new Storage();
        s.setIngredients(i);
        double match = recipeSearch.getMatchingPercentage(s,r);
        assertTrue(match == 0.25);
    }
    @Test
    public void getMatchingIngredientsTest(){
        List<Ingredient> i =  recipeSearch.findIngredients("turkey");
        Recipe r =  recipeSearch.getAllRecipes().get(241);
        Storage s = new Storage();
        s.setIngredients(i);
        assertTrue(recipeSearch.getMatchingIngredients(r, s).size() == 1);


    }
    @Test
    public void getIngredientsNotInStorage(){

        List<Ingredient> i =  recipeSearch.findIngredients("turkey");
        Storage s = new Storage();
        s.setIngredients(i);
        List<Ingredient> ingredientsNotInStorage = recipeSearch.getIngredientsNotInStorage(s);
        assertTrue(ingredientsNotInStorage.size() == 323);



    }




}
//
//
//    @Test
//    public void getMatchingIngredientsTest() {
//        Recipe recipe = makePancakes();
//
//        List<Ingredient> ingredients2 = new ArrayList<Ingredient>();
//
//        ingredients2.add(butter);
//        ingredients2.add(milk);
//        Ingredient cheese = new Ingredient(7, "Cheese");
//        Ingredient chicken = new Ingredient(8, "Chicken");
//
//        ingredients2.add(cheese);
//        ingredients2.add(chicken);
//
//        Storage storage = new Storage(123, 1234, ingredients2);
//
//        List<Ingredient> ingredients3 = new ArrayList<Ingredient>();
//        ingredients3.add(butter);
//        ingredients3.add(milk);
//        assertEquals(recipeSearch.getMatchingIngredients(recipe, storage), ingredients3);
//
//    }
//
//    @Test
//    public void getIngredientsToRecipeTest() {
//        Recipe recipe = makePancakes();
//        List<Ingredient> ingredients = new ArrayList<Ingredient>();
//        ingredients.add(butter);
//        ingredients.add(milk);
//        ingredients.add(salt);
//        ingredients.add(sugar);
//        ingredients.add(flour);
//        ingredients.add(eggs);
//        assertEquals(recipeSearch.getIngredientsToRecipe(recipe), ingredients);
//    }
//
///*    @Test
//    public void recipeContainsTest() {
//        Recipe pancakes = makePancakes();
//        Ingredient flour = new Ingredient(5, "Flour");
//        Ingredient jam = new Ingredient(9123, "Jam");
//        assertTrue(recipeSearch.recipeContains(pancakes, flour));
//        assertFalse(recipeSearch.recipeContains(pancakes, jam));
//    }*/
//
//    @Test
//    public void filterByIngredientTest() {
//        setUpTestDatabase();
//        Recipe stickBread = makeStickBread();
//        Recipe pancakes = makePancakes();
//
//        List<Recipe> filteredRecipes = recipeSearch.filterByIngredient(water);
//
//        //Check if filteredRecipes contains recipe
//        boolean containsStickBread = false;
//        boolean containsPancakes = false;
//        for (Recipe recipe :
//                filteredRecipes) {
//            if(recipe.getId() == stickBread.getId())
//                containsStickBread = true;
//            if(recipe.getId() == pancakes.getId())
//                containsPancakes = true;
//        }
//
//        assertTrue(containsStickBread);
//        assertFalse(containsPancakes);
//    }
//
//    @Test
//    public void findIngredientsTest() {
//        RecipeSearch recipeSearch = new RecipeSearch();
//
//        Database instance = Database.getInstance();
//        instance.addIngredient(butter);
//        instance.addIngredient(milk);
//        instance.addIngredient(salt);
//        instance.addIngredient(sugar);
//        instance.addIngredient(flour);
//        instance.addIngredient(eggs);
//        instance.addIngredient(water);
//        instance.addIngredient(bakingSoda);
//
//        List<Ingredient> ingredients = recipeSearch.findIngredients("er");
//
//        boolean containsButter = false;
//        boolean containsWater = false;
//        boolean containsEggs = false;
//        for (Ingredient i :
//                ingredients) {
//            if(i.getID() == butter.getID())
//                containsButter = true;
//            if(i.getID() == water.getID())
//                containsWater = true;
//            if(i.getID() == eggs.getID())
//                containsEggs = true;
//        }
//
//        assertTrue(containsButter);
//        assertTrue(containsWater);
//        assertFalse(containsEggs);
//    }
//
//    @Test
//    public void getNonMatchingIngredientsTest(){
//        RecipeSearch recipeSearch = new RecipeSearch();
//
//        Ingredient butter = new Ingredient(1, "Butter");
//        Ingredient milk = new Ingredient(2, "Milk");
//        Ingredient salt = new Ingredient(3, "Salt");
//        Ingredient sugar = new Ingredient(4, "Sugar");
//        Ingredient flour = new Ingredient(5, "Flour");
//        Ingredient eggs = new Ingredient(6, "Eggs");
//        List<Ingredient> ingredients = new ArrayList<Ingredient>();
//        ingredients.add(butter);
//        ingredients.add(milk);
//        ingredients.add(salt);
//        ingredients.add(sugar);
//        ingredients.add(flour);
//        ingredients.add(eggs);
//        Recipe recipe = new Recipe(123, "Pancakes", ingredients, "7");
//
//        List<Ingredient> ingredients2 = new ArrayList<Ingredient>();
//
//        ingredients2.add(butter);
//        ingredients2.add(milk);
//        Ingredient cheese = new Ingredient(7, "Cheese");
//        Ingredient chicken = new Ingredient(8, "Chicken");
//
//        ingredients2.add(cheese);
//        ingredients2.add(chicken);
//
//
//        Storage storage = new Storage(124, 1234, ingredients2);
//
//        List<Ingredient> ingredients3 = new ArrayList<Ingredient>();
//
//
//        ingredients3.add(salt);
//        ingredients3.add(sugar);
//        ingredients3.add(flour);
//        ingredients3.add(eggs);
//        //assertEquals(recipeSearch.getNonMatchingIngredients(recipe, storage), ingredients3);
//        assertEquals(ingredients3, recipeSearch.getNonMatchingIngredients(recipe, storage));
//    }

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

