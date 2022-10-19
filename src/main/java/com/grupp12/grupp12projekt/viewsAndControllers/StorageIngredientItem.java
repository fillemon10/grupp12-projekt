package com.grupp12.grupp12projekt.viewsAndControllers;

import com.grupp12.grupp12projekt.App2good2go;
import com.grupp12.grupp12projekt.Model;
import com.grupp12.grupp12projekt.backend.Ingredient;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StorageIngredientItem extends AnchorPane implements Initializable {
    private Ingredient ingredient;
    private Model model;
    @FXML
    private Label ingredientName;

    @FXML
    private ImageView deleteButton;

    public StorageIngredientItem(Ingredient ingredient) {
        this.ingredient = ingredient;
        this.model = Model.getInstance();

        FXMLLoader fxmlLoader = new FXMLLoader(App2good2go.class.getResource("storageIngredientItem.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ingredientName.setText(ingredient.getName());

    }

    @FXML
    private void onClickDeleteStorageIngredient() {
        model.deleteStorageIngredient(ingredient);
    }

}