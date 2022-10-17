package com.grupp12.grupp12projekt.views;

import com.grupp12.grupp12projekt.App2good2go;
import com.grupp12.grupp12projekt.Model;
import com.grupp12.grupp12projekt.backend.Ingredient;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class DetailViewIngredientItem extends AnchorPane {
    Model model;

    @FXML
    private ImageView recipeCheckbox;
    @FXML
    Label ingredientNameLabel;

    public DetailViewIngredientItem(Ingredient ingredient) {
        this.model = Model.getInstance();

        FXMLLoader fxmlLoader = new FXMLLoader(App2good2go.class.getResource("detailViewIngredientItem.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        ingredientNameLabel.setText(ingredient.getName());
        if(model.getStorage().containsIngredient(ingredient))
            recipeCheckbox.setImage(new Image(String.valueOf(App2good2go.class.getResource("Icons/check_box_FILL0_wght400_GRAD0_opsz48.png"))));

    }
}
