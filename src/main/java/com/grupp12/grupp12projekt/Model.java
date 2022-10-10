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
        if (recipeSearch == null)
            recipeSearch = new RecipeSearch();
        return instance;
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
}
