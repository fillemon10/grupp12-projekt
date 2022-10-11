package com.grupp12.grupp12projekt.Controller;

import com.grupp12.grupp12projekt.Model;
import com.grupp12.grupp12projekt.backend.Ingredient;
import com.grupp12.grupp12projekt.backend.Recipe;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.List;

public class RecipeDetailController implements IController {
    private Model model;

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

        recipeName.setText(recipe.getName());
        amountMatchingIngredients.setText("You have " + model.getMatchingIngredients(recipe).size() + " out of " + recipe.getContents().size() + "ingredients.");
        progressBar.setProgress(model.getMatchingPercentage(recipe));
    }

    public void onClickCloseButton(Event event) {
        //navigationContoller.closeDetailView();
    }

}
