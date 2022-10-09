package com.grupp12.grupp12projekt.Controller;

import com.grupp12.grupp12projekt.Model;
import com.grupp12.grupp12projekt.backend.Ingredient;
import com.grupp12.grupp12projekt.backend.Recipe;
import com.grupp12.grupp12projekt.backend.RecipeSearch;
import com.grupp12.grupp12projekt.backend.Storage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RecipeListItemController extends AnchorPane implements IController{
    Recipe recipe;
    Storage storage;
    RecipeSearch recipeSearch;

    List<Recipe> recipes;

    Ingredient ingredient;





    @FXML
    ImageView recipeImage;
    @FXML
    Label recipeName;
    @FXML
    Label recipeIngredientPercentageMessage;
    @FXML
    ProgressBar percentageBar;


    public RecipeListItemController(Recipe recipe, Storage storage, RecipeSearch recipeSearch) {
        this.recipe = recipe;
        this.storage = storage;
        this.recipeSearch = recipeSearch;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("recipelistitem.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

    }

    public void setUpRecipes(){
        for(Recipe rec : recipes){
            AnchorPane ap = new AnchorPane(new RecipeListItemController(rec, storage, recipeSearch));
            recipeName.setText(rec.getName());
            recipeIngredientPercentageMessage.setText("Du har " + recipeSearch.getMatchingPercentage(storage, rec) + "% av ingredienserna.");
            percentageBar.setProgress((recipeSearch.getMatchingPercentage(storage, rec)/100));

        }

    }



    public void initialize() {

        setUpRecipes();



    }



}
