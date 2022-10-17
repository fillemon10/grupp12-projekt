//package com.Backend;
//
//import com.grupp12.grupp12projekt.backend.Database;
//import com.grupp12.grupp12projekt.backend.Ingredient;
//import com.grupp12.grupp12projekt.backend.Recipe;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class DatabaseTest {
//    Ingredient butter = new Ingredient(1, "Butter");
//    Ingredient milk = new Ingredient(2, "Milk");
//    Ingredient salt = new Ingredient(3, "Salt");
//    Ingredient sugar = new Ingredient(4, "Sugar");
//    Ingredient flour = new Ingredient(5, "Flour");
//    Ingredient eggs = new Ingredient(6, "Eggs");
//    Ingredient water = new Ingredient(0, "Water");
//    Ingredient bakingSoda = new Ingredient(9, "Baking soda");
//
//    Recipe makePancakes() {
//        List<Ingredient> ingredients = new ArrayList<Ingredient>();
//        ingredients.add(butter);
//        ingredients.add(milk);
//        ingredients.add(salt);
//        ingredients.add(sugar);
//        ingredients.add(flour);
//        ingredients.add(eggs);
//        return new Recipe(123, "Pancakes", ingredients, "7");
//    }
//
//    Recipe makeStickBread() {
//        List<Ingredient> stickBreadIngredients = new ArrayList<Ingredient>();
//        stickBreadIngredients.add(flour);
//        stickBreadIngredients.add(water);
//        stickBreadIngredients.add(bakingSoda);
//
//        return new Recipe(938, "Stick bread", stickBreadIngredients, "1");
//    }
//
//    boolean databaseContainsRecipe(Recipe recipe, Database db) {
//        boolean contains = false;
//
//        for (Recipe r :
//                db.getAllRecipes()) {
//            if (r == recipe) {
//                contains = true;
//                break;
//            }
//        }
//
//        return contains;
//    }
//
//    boolean databaseContainsIngredient(Ingredient ingredient, Database db) {
//        boolean contains = false;
//
//        for (Ingredient i :
//                db.getAllIngredients()) {
//            if (i == ingredient) {
//                contains = true;
//                break;
//            }
//        }
//
//        return contains;
//    }
//
//    @Test
//    public void getInstanceTest() {
//        Database db = Database.getInstance();
//        Database db2 = Database.getInstance();
//
//        assertEquals(db, db2);
//    }
//
//    @Test
//    public void addRecipeTest() {
//        Database db = Database.getInstance();
//        Recipe pancakes = makePancakes();
//        Recipe stickBread = makeStickBread();
//        db.addRecipe(pancakes);
//        boolean containsPancakes = databaseContainsRecipe(pancakes, db);
//        boolean containsStickBread = databaseContainsRecipe(stickBread, db);
//
//        assertTrue(containsPancakes);
//        assertFalse(containsStickBread);
//
//        db.addRecipe(stickBread);
//        containsStickBread = databaseContainsRecipe(stickBread, db);
//
//        assertTrue(containsStickBread);
//    }
//
//    @Test
//    public void getAllRecipesTest() {
//        Database db = Database.getInstance();
//        Database db2 = Database.getInstance();
//
//        Recipe pancakes = makePancakes();
//        db.addRecipe(pancakes);
//
//        Recipe stickBread = makeStickBread();
//        db2.addRecipe(stickBread);
//
//        assertEquals(db.getAllRecipes(), db2.getAllRecipes());
//    }
//
//    @Test
//    public void addIngredientTest() {
//        Database instance = Database.getInstance();
//        instance.addIngredient(butter);
//
//        boolean containsButter = databaseContainsIngredient(butter, instance);
//        boolean containsWater = databaseContainsIngredient(water, instance);
//
//        assertTrue(containsButter);
//        assertFalse(containsWater);
//
//        instance.addIngredient(water);
//        containsWater = databaseContainsIngredient(water, instance);
//
//        assertTrue(containsWater);
//    }
//
//    @Test
//    public void getAllIngredientsTest() {
//        Database db = Database.getInstance();
//        Database db2 = Database.getInstance();
//
//        db.addIngredient(flour);
//        db2.addIngredient(bakingSoda);
//
//        assertEquals(db.getAllRecipes(), db2.getAllRecipes());
//
//        ArrayList<Ingredient> ingredients = new ArrayList<>();
//        ingredients.add(flour);
//        ingredients.add(bakingSoda);
//
//        assertEquals(db.getAllIngredients(), ingredients);
//    }
//}
