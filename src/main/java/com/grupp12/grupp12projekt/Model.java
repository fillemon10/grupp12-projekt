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
    private Authentication authentication;

    public static Model getInstance() {
        if (instance == null)
            instance = new Model();
        return instance;
    }

    //Empty constructor
    private Model() {
        //In order to test GUI before real database is connected
        makeDefaultDatabase();
        makeDefaultStorage();

        if (recipeSearch == null)
            recipeSearch = new RecipeSearch();
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Storage getStorage() {
        return storage;
    }

    public List<Ingredient> getStorageContent(){
        return this.storage.getContents();
    }
    public void setRecipeSearch(RecipeSearch recipeSearch) {
        this.recipeSearch = recipeSearch;
    }

    public void deleteStorageIngredient(Ingredient ingredient){
        this.storage.removeIngredient(ingredient);
        notifyObservers();
    }





    public List<Ingredient> getMatchingIngredients(Recipe recipe) {
        return recipeSearch.getMatchingIngredients(recipe, this.storage);
    }

    public double getMatchingPercentage(Recipe recipe) {
        Ingredient butter = new Ingredient(1, "Butter");
        Ingredient eggs = new Ingredient(6, "Eggs");
        List<Ingredient> storageIngredients = new ArrayList<>();
        storageIngredients.add(butter);
        storageIngredients.add(eggs);
        Storage storage1 = new Storage(1, 2, storageIngredients);


        return recipeSearch.getMatchingPercentage(storage1, recipe);
    }

    public List<Recipe> getRecipes() {
        Ingredient butter = new Ingredient(1, "Butter");
        Ingredient salt = new Ingredient(3, "Salt");
        Ingredient sugar = new Ingredient(4, "Sugar");
        Ingredient flour = new Ingredient(5, "Flour");
        Ingredient eggs = new Ingredient(6, "Eggs");
        Ingredient water = new Ingredient(0, "Water");
        Ingredient bakingSoda = new Ingredient(9, "Baking soda");
        List<Ingredient> ingredienser1 = new ArrayList<>();
        List<Ingredient> ingredienser2 = new ArrayList<>();
        ingredienser1.add(butter);
        ingredienser1.add(salt);
        ingredienser1.add(flour);
        ingredienser1.add(eggs);
        ingredienser2.add(butter);
        ingredienser2.add(sugar);
        ingredienser2.add(water);
        ingredienser2.add(bakingSoda);

        List<Recipe> receptLista = new ArrayList<>();
        Recipe recept1 = new Recipe(1, "recept1", ingredienser1,"7");
        Recipe recept2 = new Recipe(2, "recept2", ingredienser2,"6");
        Recipe recept3 = new Recipe(1, "recept3", ingredienser1,"8");
        receptLista.add(recept1);
        receptLista.add(recept2);
        receptLista.add(recept3);


        return receptLista;
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

    private void makeDefaultStorage() {
        Ingredient butter = new Ingredient(1, "Butter");
        Ingredient milk = new Ingredient(2, "Milk");
        Ingredient salt = new Ingredient(3, "Salt");
        Ingredient sugar = new Ingredient(4, "Sugar");
        Ingredient flour = new Ingredient(5, "Flour");
        Ingredient eggs = new Ingredient(6, "Eggs");
        Ingredient water = new Ingredient(0, "Water");
        Ingredient bakingSoda = new Ingredient(9, "Baking soda");

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(butter);
        ingredients.add(milk);
        ingredients.add(salt);
        ingredients.add(sugar);
        ingredients.add(flour);
        ingredients.add(eggs);
        storage = new Storage(123, 12345, ingredients);
    }



    public void createNewUser(String signUpUname, String signUpPword) {
        //authentication.registerUser(signUpUname, signUpPword);
        logInUser(signUpUname, signUpPword);
    }

    public void logInUser(String logInUname, String logInPword) {
        authentication.loginUser(logInUname, logInPword);
    }
}
