package com.grupp12.grupp12projekt.viewsAndControllers;

import com.grupp12.grupp12projekt.App2good2go;
import com.grupp12.grupp12projekt.Model;
import com.grupp12.grupp12projekt.Observer;
import com.grupp12.grupp12projekt.backend.Ingredient;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StoragePage extends VBox implements Initializable, Observer {
    @FXML
    private FlowPane storageFlowPane;

    private Model model;
    private static StoragePage instance;

    public static StoragePage getInstance() {
        if (instance == null)
            instance = new StoragePage();
        return instance;
    }

    private StoragePage() {
        this.model = Model.getInstance();
        model.addObserver(this);
        FXMLLoader fxmlLoader = new FXMLLoader(App2good2go.class.getResource("storagePage.fxml"));
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
        updateStorageList();
    }

    public void updateStorageList(){
        storageFlowPane.getChildren().clear();
        for (Ingredient i : model.getStorageContent()) {
            storageFlowPane.getChildren().add(new StorageIngredientItem(i));
        }
    }

    @Override
    public void onNotify() {
        updateStorageList();
    }
}
