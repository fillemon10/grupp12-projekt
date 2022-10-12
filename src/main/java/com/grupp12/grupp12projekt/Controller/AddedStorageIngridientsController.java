package com.grupp12.grupp12projekt.Controller;
import com.grupp12.grupp12projekt.Model;
import com.grupp12.grupp12projekt.backend.Ingredient;
import com.grupp12.grupp12projekt.backend.Storage;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.util.List;

public class AddedStorageIngridientsController extends AnchorPane implements IController{
    private StorageController parentcontroller;
    private Ingredient ingredient;


    @FXML
    private Label ingridientName;

    public AddedStorageIngridientsController(Ingredient ingredient, StorageController storageController){


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("added-ingridient-item-in-storage.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        this.ingredient = ingredient;
        this.parentcontroller = storageController;


        ingridientName.setText(ingredient.getName());


    }

}
