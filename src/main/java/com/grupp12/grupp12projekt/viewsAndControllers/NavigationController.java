package com.grupp12.grupp12projekt.viewsAndControllers;

import com.grupp12.grupp12projekt.App2good2go;
import com.grupp12.grupp12projekt.Model;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    private Label logoutButton;
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
        logoutButton.setOnMouseClicked(this::logOut);
        setLogInPage();
    }




    void logInOrSignUp() {
        logInPane.toBack();
        logInPane.setVisible(false);

        setFindRecipePage();
    }

    @FXML
    private void onStorageButtonPressed(Event event) {
        setStoragePage();
    }

    @FXML
    private void onRecipeSearchButtonPressed(Event event) {
        setFindRecipePage();

    }

    @FXML
    private void onStorageSettingsButtonPressed(Event event) {
        setStorageSettingsPage();
    }

    @FXML
    private void closeDetailView(Event event) {
        dismissLightbox();
    }

    private void setLogInPage() {
        AnchorPane pane = LogInPage.getInstance();

        logInPane.getChildren().clear();
        logInPane.getChildren().add(pane);
        AnchorPane.setBottomAnchor(pane, 0.0);
        AnchorPane.setLeftAnchor(pane, 0.0);
        AnchorPane.setRightAnchor(pane, 0.0);
        AnchorPane.setTopAnchor(pane, 0.0);
        LogInPage.getInstance().clearFields();

/*        AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(App2good2go.class.getResource("logInPage.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        logInPane.getChildren().setAll(pane);*/

        logInPane.setVisible(true);
        logInPane.toFront();
    }

    private void setFindRecipePage() {
        Region r = FindRecipesPage.getInstance();
       // model.clearObservers();
        //model.addObserver(FindRecipesPage.getInstance());
        contentScrollPane.setContent(r);
        contentScrollPane.setVvalue(0);
    }

    private void setStoragePage() {
        Region r = StoragePage.getInstance();
        //model.clearObservers();
        //model.addObserver(StoragePage.getInstance());
        contentScrollPane.setContent(r);
    }

    private void setStorageSettingsPage() {
        Region r = StorageSettingsPage.getInstance();
        //model.clearObservers();
        //model.addObserver(StorageSettingsPage.getInstance());
        contentScrollPane.setContent(r);
    }

    void displayLightbox(AnchorPane pane) {
        lightBox.getChildren().clear();
        lightBox.getChildren().add(pane);
        AnchorPane.setBottomAnchor(pane, 50.0);
        AnchorPane.setLeftAnchor(pane, 50.0);
        AnchorPane.setRightAnchor(pane, 50.0);
        AnchorPane.setTopAnchor(pane, 50.0);
        lightBox.toFront();
        lightBox.setVisible(true);
    }

    void dismissLightbox() {
        lightBox.toBack();
        lightBox.setVisible(false);
    }

    @FXML
    private void logOut(Event event){
        setLogInPage();
        model.logout();
    }
}
