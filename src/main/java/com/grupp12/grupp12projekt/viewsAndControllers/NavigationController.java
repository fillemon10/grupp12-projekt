package com.grupp12.grupp12projekt.viewsAndControllers;

import com.grupp12.grupp12projekt.backend.Model;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Navigation controller class that handles the navigation of the program
 */

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


    /**
     * method for removing the login pane when login or sign up is successful
     */
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



        logInPane.setVisible(true);
        logInPane.toFront();
    }

    private void setFindRecipePage() {
        Region r = FindRecipesPage.getInstance();
        contentScrollPane.setContent(r);
        contentScrollPane.setVvalue(0);
    }

    private void setStoragePage() {
        Region r = StoragePage.getInstance();
        contentScrollPane.setContent(r);
    }

    private void setStorageSettingsPage() {
        Region r = StorageSettingsPage.getInstance();
        contentScrollPane.setContent(r);
    }

    /**
     * method for displaying the lightbox for the detail view in find recipes
     *
     * @param pane supplied anchor pane that is displayed in the light box.
     */
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

    /**
     * method for dismissing the lightbox for the detail view in find recipes
     */

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
