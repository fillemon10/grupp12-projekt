package com.grupp12.grupp12projekt.controllers;

import com.grupp12.grupp12projekt.Model;
import com.grupp12.grupp12projekt.backend.Ingredient;
import com.grupp12.grupp12projekt.backend.Recipe;
import com.grupp12.grupp12projekt.backend.RecipeSearch;
import com.grupp12.grupp12projekt.backend.Storage;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import java.util.List;

public class RecipeListItemController extends AnchorPane {

    private Model model = Model.getInstance();
    private Recipe recipe;
    private Storage storage;
    private RecipeSearch recipeSearch;




    private List<Recipe> recipes;

    private Ingredient ingredient;







    @FXML
    ImageView recipeImage;
    @FXML
    Label recipeName;
    @FXML
    Label recipeIngredientPercentageMessage;
    @FXML
    ProgressBar percentageBar;


    public RecipeListItemController(Recipe recipe, Storage storage) {
        this.recipe = recipe;
        this.storage = storage;

/*
        FXMLLoader fxmlLoader = new FXMLLoader(App2good2go.class.getResource("recipelistitem.fxml"));
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();

        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }*/

    }





    @FXML
    public void initialize() {

        this.recipeName.setText(this.recipe.getName());
        this.recipeIngredientPercentageMessage.setText("Du har " + model.getMatchingPercentage(recipe) + "% av ingredienserna");
        this.percentageBar.setProgress(model.getMatchingPercentage(recipe));

    }



}
