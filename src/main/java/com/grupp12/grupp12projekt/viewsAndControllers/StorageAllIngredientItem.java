package com.grupp12.grupp12projekt.viewsAndControllers;
import com.grupp12.grupp12projekt.App2good2go;
import com.grupp12.grupp12projekt.Model;
import com.grupp12.grupp12projekt.backend.Ingredient;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StorageAllIngredientItem extends AnchorPane implements Initializable {
    private Ingredient ingredient;
    private Model model;

    @FXML
    private Label ingredientName;
    @FXML
    ImageView addButton;

    public StorageAllIngredientItem(Ingredient ingredient) {
        this.ingredient = ingredient;
        model = model.getInstance();

        FXMLLoader fxmlLoader = new FXMLLoader(App2good2go.class.getResource("storageAllIngredientsItem.fxml"));
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
    public void onAddClick(){
        model.addIngredientToStorage(ingredient);
    }

}
