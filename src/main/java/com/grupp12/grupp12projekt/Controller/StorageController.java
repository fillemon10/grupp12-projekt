package com.grupp12.grupp12projekt.Controller;

import com.grupp12.grupp12projekt.App2good2go;
import com.grupp12.grupp12projekt.Model;
import com.grupp12.grupp12projekt.backend.Ingredient;
import com.grupp12.grupp12projekt.backend.Recipe;
import com.grupp12.grupp12projekt.backend.Storage;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class StorageController extends AnchorPane implements IController, Initializable {
    @FXML
    private AnchorPane rootPane;
    @FXML
    private FlowPane mystorgaeflowpane;

    private Model model;
    private static StorageController instance;

    public static StorageController getInstance() {
        if (instance == null)
            instance = new StorageController();
        return instance;
    }

    private StorageController() {
        this.model = Model.getInstance();

        FXMLLoader fxmlLoader = new FXMLLoader(App2good2go.class.getResource("storage-view.fxml"));
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
        URL recipeURL = App2good2go.class.getResource("added-ingridient-item-in-storage.fxml");
        mystorgaeflowpane.getChildren().clear();
        List<Ingredient> ingredients = model.getStorageContent();
        for(Ingredient i: ingredients){
            StorageIngredientController storageIngredientController = new StorageIngredientController(i, this);
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(recipeURL);
                fxmlLoader.setController(storageIngredientController);
                AnchorPane cardAnchor = fxmlLoader.load();
                mystorgaeflowpane.getChildren().add(cardAnchor);
            }
            catch (IOException exception) {
                throw new RuntimeException(exception);
            }
        }
    }




    }










