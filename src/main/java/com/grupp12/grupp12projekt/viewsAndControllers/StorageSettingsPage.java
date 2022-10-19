package com.grupp12.grupp12projekt.viewsAndControllers;

import com.grupp12.grupp12projekt.App2good2go;
import com.grupp12.grupp12projekt.backend.Model;
import com.grupp12.grupp12projekt.Observer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Class for the storage setting page where the user is able to see their own storage ID and can share their storage with another user.
 */

public class StorageSettingsPage extends AnchorPane implements Observer, Initializable {
    @FXML
    private Label usersStorageID;
    @FXML
    private TextField otherUsersStorageID;
    @FXML
    private AnchorPane rootpane;
    @FXML
    private Label errorLabel;
    private Model model;
    private static StorageSettingsPage instance;


    public static StorageSettingsPage getInstance() {
        if (instance == null)
            instance = new StorageSettingsPage();
        return instance;
    }

    private StorageSettingsPage() {
        model = Model.getInstance();
        model.addObserver(this);
        FXMLLoader fxmlLoader = new FXMLLoader(App2good2go.class.getResource("storageSettingsPage.fxml"));
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
        errorLabel.setVisible(false);
        otherUsersStorageID.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                onClickSyncStorage();
            }
        });

        updateStorageID();
    }

    @FXML
    private void onClickSyncStorage() {
        try {
            model.setCurrentUserStorageId(Integer.parseInt(otherUsersStorageID.getText()));
            errorLabel.setVisible(false);
        } catch (IllegalArgumentException e) {
            errorLabel.setText(e.getMessage());
            errorLabel.setVisible(true);
        }

    }

    @Override
    public void onNotify() {
        updateStorageID();
    }

    private void updateStorageID() {
        usersStorageID.setText(String.valueOf(model.getCurrentUsersStorageID()));
    }
}

