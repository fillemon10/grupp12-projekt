package com.grupp12.grupp12projekt.controllers;

import com.grupp12.grupp12projekt.App2good2go;
import com.grupp12.grupp12projekt.Model;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class StorageSettings extends AnchorPane{
    @FXML
    private Label usersStorageID;
    @FXML
    private TextField otherUsersStorageID;
    @FXML
    private AnchorPane rootpane;
    private Model model;
    private static StorageSettings instance;

    public static StorageSettings getInstance() {
        if (instance == null)
            instance = new StorageSettings();
        return instance;
    }

    private StorageSettings(){
        model = model.getInstance();
        usersStorageID.setText(String.valueOf(model.getCurrentUsersStorageID()));

            FXMLLoader fxmlLoader = new FXMLLoader(App2good2go.class.getResource("StorageSettings.fxml"));
            fxmlLoader.setRoot(this);
            fxmlLoader.setController(this);

            try {
                fxmlLoader.load();
            } catch (IOException exception) {
                throw new RuntimeException(exception);
            }
    }

    @FXML
    private void onClickSyncStorage(){
       //model.setNewStorageID(Integer.parseInt(otherUsersStorageID.getText()));
    }
}
