package com.grupp12.grupp12projekt;

import com.grupp12.grupp12projekt.backend.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Model implements Observable {
    private User currentUser;
    private Storage storage;
    private static RecipeSearch recipeSearch;
    private static Model instance;
    private List<Recipe> recipes;
    private List<Observer> observers = new ArrayList<>();

    public static Model getInstance() {
        if (instance == null)
            instance = new Model();
        return instance;
    }

    //Empty constructor
    private Model() {
        //In order to test GUI before real database is connected
        makeDefaultDatabase();

        if (recipeSearch == null)
            recipeSearch = new RecipeSearch();
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public void setRecipeSearch(RecipeSearch recipeSearch) {
        this.recipeSearch = recipeSearch;
    }

    public List<Ingredient> getMatchingIngredients(Recipe recipe) {
        return recipeSearch.getMatchingIngredients(recipe, this.storage);
    }

    public double getMatchingPercentage(Recipe recipe) {
        return recipeSearch.getMatchingPercentage(storage, recipe);
    }

    public List<Ingredient> findIngredients(String s) {
        return recipeSearch.findIngredients(s);
    }

    public void filterByIngredient(Ingredient ingredient) {
        //TODO make methods void for Observer pattern
        recipes = recipeSearch.filterByIngredient(ingredient);
        notifyObservers();
    }

    @Override
    public void addObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        this.observers.remove(o);
    }

    public void notifyObservers() {
        this.observers.forEach(x -> x.onNotify(this));
    }

    //TEST - remove later
    private void makeDefaultDatabase() {
        Ingredient butter = new Ingredient(1, "Butter");
        Ingredient milk = new Ingredient(2, "Milk");
        Ingredient salt = new Ingredient(3, "Salt");
        Ingredient sugar = new Ingredient(4, "Sugar");
        Ingredient flour = new Ingredient(5, "Flour");
        Ingredient eggs = new Ingredient(6, "Eggs");
        Ingredient water = new Ingredient(0, "Water");
        Ingredient bakingSoda = new Ingredient(9, "Baking soda");

        List<Ingredient> pancakesIngredients = new ArrayList<>();
        pancakesIngredients.add(butter);
        pancakesIngredients.add(milk);
        pancakesIngredients.add(salt);
        pancakesIngredients.add(sugar);
        pancakesIngredients.add(flour);
        pancakesIngredients.add(eggs);
        Recipe pancakes = new Recipe(123, "Pancakes", pancakesIngredients, "7");

        List<Ingredient> stickBreadIngredients = new ArrayList<>();
        stickBreadIngredients.add(flour);
        stickBreadIngredients.add(water);
        stickBreadIngredients.add(bakingSoda);

        Recipe stickBread = new Recipe(938, "Stick bread", stickBreadIngredients, "1");

        //Set up Database with pancakes and stick bread as recipes
        Database instance = Database.getInstance();

        //Add recipes to db
        instance.addRecipe(pancakes);
        instance.addRecipe(stickBread);

        //Add ingredients to db
        instance.addIngredient(butter);
        instance.addIngredient(milk);
        instance.addIngredient(salt);
        instance.addIngredient(sugar);
        instance.addIngredient(flour);
        instance.addIngredient(eggs);
        instance.addIngredient(water);
        instance.addIngredient(bakingSoda);
    }
}
