package com.grupp12.grupp12projekt.Controller;

import com.grupp12.grupp12projekt.Model;
import com.grupp12.grupp12projekt.backend.Ingredient;
import com.grupp12.grupp12projekt.backend.Recipe;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;

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

    public RecipeDetailController() {
        this.model = Model.getInstance();
    }

    public void onClickCloseButton(Event event){
        //close recipeDetail
    }

    public List<Ingredient> getMatchingIngredients(Recipe recipe) {
        return model.getMatchingIngredients(recipe);
    }


    public double getMatchingPercentage(Recipe recipe) {
        return model.getMatchingPercentage(recipe);
    }
}
