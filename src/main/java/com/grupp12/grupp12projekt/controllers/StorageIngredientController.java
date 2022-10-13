package com.grupp12.grupp12projekt.controllers;
import com.grupp12.grupp12projekt.backend.Ingredient;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class StorageIngredientController extends AnchorPane implements IController, Initializable {
    private StorageController parentcontroller;
    private Ingredient ingredient;


    @FXML
    private Label ingredientName;

    public StorageIngredientController(Ingredient ingredient, StorageController storageController){


/*        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("added-ingridient-item-in-storage.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }*/
        this.ingredient = ingredient;
        this.parentcontroller = storageController;

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ingredientName.setText(ingredient.getName());
    }
}
