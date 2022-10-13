package com.grupp12.grupp12projekt.views;



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

public class RecipeListItemView extends AnchorPane {

    @FXML
    ImageView recipeImage;
    @FXML
    Label recipeName;
    @FXML
    Label recipeIngredientPercentageMessage;
    @FXML
    ProgressBar percentageBar;



    public RecipeListItemView(Recipe recipe, Storage storage, RecipeSearch recipeSearch){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("recipelistitem.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        recipeName.setText(recipe.getName());
        recipeIngredientPercentageMessage.setText("Du har " + recipeSearch.getMatchingPercentage(storage, recipe) + "% av ingredienserna.");


    }







}
