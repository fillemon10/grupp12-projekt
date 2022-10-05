package com.grupp12.grupp12projekt.Controller;

import com.grupp12.grupp12projekt.App2good2go;
import com.grupp12.grupp12projekt.Model;
import com.grupp12.grupp12projekt.backend.Ingredient;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;

public class HomePageController extends VBox implements IController {
    private Model model;
    @FXML
    private ImageView searchButton;
    @FXML
    private TextField searchField;

    private static HomePageController instance;

    public static HomePageController getInstance() {
        if (instance == null)
            instance = new HomePageController();

        return instance;
    }

    private void HomePageController() {
        model = Model.getInstance();

        FXMLLoader fxmlLoader = new FXMLLoader(App2good2go.class.getResource("com.grupp12.grupp12projekt/home-page.fxml"));
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
}
