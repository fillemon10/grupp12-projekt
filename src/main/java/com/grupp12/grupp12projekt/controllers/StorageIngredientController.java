package com.grupp12.grupp12projekt.controllers;
import com.grupp12.grupp12projekt.Model;
import com.grupp12.grupp12projekt.Observer;
import com.grupp12.grupp12projekt.backend.Ingredient;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class StorageIngredientController extends AnchorPane implements Initializable {
    private StorageController parentcontroller;
    private Ingredient ingredient;
    private Model model;

    @FXML
    private Label ingredientName;

    @FXML
    private ImageView  deleteButton;

    public StorageIngredientController(Ingredient ingredient, StorageController storageController) {

        this.ingredient = ingredient;
        this.parentcontroller = storageController;
        model = model.getInstance();



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ingredientName.setText(ingredient.getName());

    }

    @FXML
    public void onClick(){
        model.deleteStorageIngredient(ingredient);




    }



}
