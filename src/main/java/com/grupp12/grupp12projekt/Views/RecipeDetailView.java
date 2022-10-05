package com.grupp12.grupp12projekt.Views;

import com.grupp12.grupp12projekt.Controller.RecipeDetailController;
import com.grupp12.grupp12projekt.backend.Recipe;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class RecipeDetailView extends AnchorPane{
    private RecipeDetailController controller;
    private Recipe recipe;


    @FXML
    private ScrollPane listOfIngredients;
    @FXML
    private Label recipeName;
    @FXML
    private Label amountMatchingIngredients;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private ImageView closeButton;

    public RecipeDetailView(Recipe recipe, RecipeDetailController controller){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("recipeDetailView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        this.recipe = recipe;
        this.controller = controller;

        recipeName.setText(recipe.getName());
        amountMatchingIngredients.setText("You have " + controller.getMatchingIngredients(recipe).size() + " out of " + recipe.getContents().size() + "ingredients." );
        progressBar.setProgress(controller.getMatchingPercentage(recipe));
    }

}
