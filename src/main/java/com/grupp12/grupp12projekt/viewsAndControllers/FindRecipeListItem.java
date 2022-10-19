package com.grupp12.grupp12projekt.viewsAndControllers;

import com.grupp12.grupp12projekt.App2good2go;
import com.grupp12.grupp12projekt.backend.Model;
import com.grupp12.grupp12projekt.backend.Ingredient;
import com.grupp12.grupp12projekt.backend.Recipe;
import com.grupp12.grupp12projekt.backend.RecipeSearch;
import com.grupp12.grupp12projekt.backend.Storage;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class FindRecipeListItem extends AnchorPane implements Initializable {

    private Model model;
    private Recipe recipe;
    private Storage storage;
    private RecipeSearch recipeSearch;

    private List<Recipe> recipes;
    private Ingredient ingredient;
    private NavigationController navigationController;

    @FXML
    private ImageView recipeImage;
    @FXML
    private Label recipeName;
    @FXML
    private Label recipeIngredientPercentageMessage;
    @FXML
    private ProgressBar percentageBar;


    public FindRecipeListItem(Recipe recipe) {
        this.recipe = recipe;
        this.navigationController = NavigationController.getInstance();
        this.model = Model.getInstance();

        FXMLLoader fxmlLoader = new FXMLLoader(App2good2go.class.getResource("findRecipeListItem.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.setOnMouseClicked(this::onClick);
        this.recipeName.setText(this.recipe.getName());
        recipeIngredientPercentageMessage.setText("You have " + model.getMatchingIngredients(recipe).size() + " out of " + recipe.getIngredients().size() + " ingredients.");
        this.percentageBar.setProgress(model.getMatchingPercentage(recipe));
    }

    @FXML
    private void onClick(Event event) {
        navigationController.displayLightbox(new DetailViewPage(this.recipe));
    }

}
