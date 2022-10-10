package com.grupp12.grupp12projekt.Controller;

import com.grupp12.grupp12projekt.Model;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;

import java.net.URL;
import java.util.ResourceBundle;

public class NavigationController implements IController, Initializable {
    private Model model;
    private static NavigationController instance;

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
    @FXML
    private AnchorPane lightBox;

    private NavigationController() {
        model = Model.getInstance();
    }

    public static NavigationController getInstance() {
        if (instance == null)
            instance = new NavigationController();

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

    @FXML
    private void closeDetailView(Event event){
        lightBox.toBack();
    }

    private void setRecipeSearchPage() {
        Region r = FindRecipesController.getInstance();
        contentScrollPane.setContent(r);
    }

    private void setStoragePage() {
        Region r = StorageController.getInstance();
        contentScrollPane.setContent(r);
    }


}
