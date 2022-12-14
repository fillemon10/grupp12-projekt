package com.grupp12.grupp12projekt.viewsAndControllers;

import com.grupp12.grupp12projekt.App2good2go;
import com.grupp12.grupp12projekt.backend.Model;
import com.grupp12.grupp12projekt.backend.Ingredient;
import com.grupp12.grupp12projekt.backend.Recipe;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Class that creates detail views of all the listed recipes in the Find Recipes page that contains detailed information of the recipes.
 */
public class DetailViewPage extends AnchorPane implements Initializable {
    private NavigationController navigationController;
    private Model model;
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
    @FXML
    private TextField text;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private FlowPane ingredientsPane;
    @FXML
    private Label ratingLabel;


    /**
     * Constructor for creating the detail view page
     * @param recipe the supplied recipe
     */
    public DetailViewPage(Recipe recipe) {
        this.model = Model.getInstance();
        this.navigationController = NavigationController.getInstance();
        this.recipe = recipe;

        FXMLLoader fxmlLoader = new FXMLLoader(App2good2go.class.getResource("detailViewPage.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        recipeName.setText(recipe.getName());
        amountMatchingIngredients.setText("You have " + model.getMatchingIngredients(recipe).size() + " out of " + recipe.getIngredients().size() + " ingredients.");
        progressBar.setProgress(model.getMatchingPercentage(recipe));
        ratingLabel.setText("Rating: " + recipe.getRating()+ "/5");
        setUpIngredients();
    }

    private void setUpIngredients(){
        ingredientsPane.getChildren().clear();
        for (Ingredient i : recipe.getIngredients()) {
            ingredientsPane.getChildren().add(new DetailViewIngredientItem(i));
        }
    }

    @FXML
    private void onClickCloseButton() {
        this.navigationController.dismissLightbox();
    }

    @FXML
    private void mouseTrap(Event event) {
        event.consume();
    }

}
