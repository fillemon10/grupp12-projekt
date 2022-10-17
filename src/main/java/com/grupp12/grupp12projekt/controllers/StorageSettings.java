package com.grupp12.grupp12projekt.controllers;

import com.grupp12.grupp12projekt.Model;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class StorageSettings {
    @FXML
    private Label usersStorageID;
    @FXML
    private TextField otherUsersStorageID;
    @FXML
    private AnchorPane rootpane;
    private Model model;

    public StorageSettings(){
        model = model.getInstance();
        usersStorageID.setText(String.valueOf(model.getCurrentUser().getStorageID()));
    }

    @FXML
    private void onClickSyncStorage(){
        model.setNewStorageID(Integer.parseInt(otherUsersStorageID.getText()));
    }
}
