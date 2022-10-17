package com.grupp12.grupp12projekt.controllers;

import com.grupp12.grupp12projekt.Model;
import com.grupp12.grupp12projekt.backend.Ingredient;
import com.grupp12.grupp12projekt.backend.Recipe;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

import java.io.IOException;

public class RecipeDetailController {
    private NavigationController navigationController;
    private Model model;

    @FXML
    private FlowPane listOfIngredients;
    @FXML
    private Label recipeName;
    @FXML
    private Label amountMatchingIngredients;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private ImageView closeButton;
    @FXML
    private TextField text;



    public RecipeDetailController(Recipe recipe) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("recipeDetailView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        this.model = Model.getInstance();
        this.navigationController = navigationController.getInstance();

        recipeName.setText(recipe.getName());
        amountMatchingIngredients.setText("You have " + model.getMatchingIngredients(recipe).size() + " out of " + recipe.getIngredients().size() + "ingredients.");
        progressBar.setProgress(model.getMatchingPercentage(recipe));
        setListOfIngredients(recipe);
    }

    private void setListOfIngredients(Recipe recipe) {
        listOfIngredients.getChildren().clear();
        listOfIngredients.getChildren().add(new Label("what you have:"));
        for (Ingredient ingredient: model.getMatchingIngredients(recipe)) {
            listOfIngredients.getChildren().add(new Label(ingredient.getName()));
        }
        listOfIngredients.getChildren().add(new Label("what you DONT have:"));
        for (Ingredient ingredient: model.getNonMatchingIngredients(recipe)) {
            listOfIngredients.getChildren().add(new Label(ingredient.getName()));
        }
    }

    public void onClickCloseButton() {
        //navigationController.closeDetailView();
    }

}
