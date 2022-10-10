package com.grupp12.grupp12projekt.Controller;

import com.grupp12.grupp12projekt.App2good2go;
import com.grupp12.grupp12projekt.Model;
import com.grupp12.grupp12projekt.Observable;
import com.grupp12.grupp12projekt.Observer;
import com.grupp12.grupp12projekt.backend.Ingredient;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;

public class FindRecipesController extends VBox implements IController, Observer {
    private Model model;
    @FXML
    private ImageView searchButton;
    @FXML
    private TextField searchField;

    private static FindRecipesController instance;

    public static FindRecipesController getInstance() {
        if (instance == null)
            instance = new FindRecipesController();

        return instance;
    }

    private FindRecipesController() {
        model = Model.getInstance();

        FXMLLoader fxmlLoader = new FXMLLoader(App2good2go.class.getResource("find-recipes-page.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @FXML
    public void onSearchButtonClicked() {
        String searchFieldText = searchField.getText();
        List<Ingredient> ingredients = model.findIngredients(searchFieldText);
        //TODO: update view
    }

    @FXML
    public void onIngredientItemClicked() {

        //filterByIngredient(ingredient);
    }

    private void filterByIngredient(Ingredient ingredient) {
        model.filterByIngredient(ingredient);
    }

    @Override
    public void onNotify(Object observable) {
    }
}
