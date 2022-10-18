package com.grupp12.grupp12projekt.viewsAndControllers;

import com.grupp12.grupp12projekt.App2good2go;
import com.grupp12.grupp12projekt.Model;
import com.grupp12.grupp12projekt.Observer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StorageSettingsPage extends AnchorPane implements Observer, Initializable {
    @FXML
    private Label usersStorageID;
    @FXML
    private TextField otherUsersStorageID;
    @FXML
    private AnchorPane rootpane;
    private Model model;
    private static StorageSettingsPage instance;

    public static StorageSettingsPage getInstance() {
        if (instance == null)
            instance = new StorageSettingsPage();
        return instance;
    }

    private StorageSettingsPage(){
        model = model.getInstance();
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
        updateStorageID();
    }

    @FXML
    private void onClickSyncStorage(){
       model.setCurrentUserStorageId(Integer.parseInt(otherUsersStorageID.getText()));

    }

    @Override
    public void onNotify() {
        updateStorageID();
    }

    private void updateStorageID(){
        usersStorageID.setText(String.valueOf(model.getCurrentUsersStorageID()));
    }
}

