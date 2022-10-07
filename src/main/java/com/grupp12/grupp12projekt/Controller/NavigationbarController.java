package com.grupp12.grupp12projekt.Controller;

import com.grupp12.grupp12projekt.Model;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;

import java.net.URL;
import java.util.ResourceBundle;

public class NavigationbarController implements IController, Initializable {
    private Model model;
    private static NavigationbarController instance;

    @FXML
    private ScrollPane contentScrollPane;
    @FXML
    private Label storageButton;
    @FXML
    private Label recipeSearchButton;
    @FXML
    private Label favoritesButton;
    @FXML
    private Label shoppingListButton;

    private NavigationbarController() {
        model = Model.getInstance();
    }

    public static NavigationbarController getInstance() {
        if (instance == null)
            instance = new NavigationbarController();

        return instance;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        storageButton.setOnMouseClicked(this::onStorageButtonPressed);
        recipeSearchButton.setOnMouseClicked(this::onRecipeSearchButtonPressed);
        //setStoragePage();
    }

    @FXML
    protected void onStorageButtonPressed(Event event) {
        setStoragePage();
    }

    @FXML
    protected void onRecipeSearchButtonPressed(Event event) {
        setRecipeSearchPage();
    }

    private void setRecipeSearchPage() {
        Region r = HomePageController.getInstance();
        contentScrollPane.setContent(r);
    }

    private void setStoragePage() {
        Region r = StorageController.getInstance();
        contentScrollPane.setContent(r);
    }
}
