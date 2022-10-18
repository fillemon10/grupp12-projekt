package com.grupp12.grupp12projekt.viewsAndControllers;

import com.grupp12.grupp12projekt.App2good2go;
import com.grupp12.grupp12projekt.Model;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NavigationController implements Initializable {
    private Model model;
    private static NavigationController instance;

    @FXML
    private ScrollPane contentScrollPane;

    @FXML
    private ScrollPane recipesPane;
    @FXML
    private Label storageButton;
    @FXML
    private Label recipeSearchButton;
    @FXML
    private Label storageSettingsButton;
    @FXML
    private Label recipeSettingsButton;
    @FXML
    private AnchorPane lightBox;
    @FXML
    private AnchorPane logInPane;

    private NavigationController() {
        model = Model.getInstance();

    }

    public static NavigationController getInstance() {
        if (instance == null) instance = new NavigationController();

        return instance;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        storageButton.setOnMouseClicked(this::onStorageButtonPressed);
        recipeSearchButton.setOnMouseClicked(this::onRecipeSearchButtonPressed);
        storageSettingsButton.setOnMouseClicked(this::onStorageSettingsButtonPressed);
        setLogInPage();
    }



    private void setLogInPage() {
        AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(App2good2go.class.getResource("logInPage.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        logInPane.getChildren().setAll(pane);
        logInPane.setVisible(true);
        logInPane.toFront();
    }

    public void logInOrSignUp() {
        logInPane.toBack();
        logInPane.setVisible(false);
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
    private void onStorageSettingsButtonPressed(Event event) {
        setStorageSettingsPage();
    }

    @FXML
    private void closeDetailView(Event event) {
        dismissLightbox();
    }

    private void setRecipeSearchPage() {
        Region r = FindRecipesPage.getInstance();
        model.clearObservers();
        model.addObserver(FindRecipesPage.getInstance());
        contentScrollPane.setContent(r);
    }

    private void setStoragePage() {
        Region r = StoragePage.getInstance();
        model.clearObservers();
        model.addObserver(StoragePage.getInstance());
        contentScrollPane.setContent(r);
    }

    private void setStorageSettingsPage() {
        Region r = StorageSettingsPage.getInstance();
        model.clearObservers();
        model.addObserver(StorageSettingsPage.getInstance());
        contentScrollPane.setContent(r);

    }

    public void displayLightbox(AnchorPane pane) {
        lightBox.getChildren().clear();
        lightBox.getChildren().add(pane);
        AnchorPane.setBottomAnchor(pane, 50.0);
        AnchorPane.setLeftAnchor(pane, 50.0);
        AnchorPane.setRightAnchor(pane, 50.0);
        AnchorPane.setTopAnchor(pane, 50.0);
        lightBox.toFront();
        lightBox.setVisible(true);
    }

    public void dismissLightbox() {
        lightBox.toBack();
        lightBox.setVisible(false);
    }
}
