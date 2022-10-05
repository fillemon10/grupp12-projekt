package com.grupp12.grupp12projekt.Controller;

import com.grupp12.grupp12projekt.Model;
import com.grupp12.grupp12projekt.backend.Ingredient;
import com.grupp12.grupp12projekt.backend.Recipe;

import java.util.List;

public class RecipeDetailController {
    private Model model;

    public RecipeDetailController(Model model){
        this.model = model;
    }

    public List<Ingredient> getMatchingIngredients(Recipe recipe){
        return model.getMatchingIngredients(recipe);
    }


    public double getMatchingPrecentage(Recipe recipe) {
        return  model.getMatchingPrecentage(recipe);
    }
}
