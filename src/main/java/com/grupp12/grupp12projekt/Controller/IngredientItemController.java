package com.grupp12.grupp12projekt.Controller;

import com.grupp12.grupp12projekt.backend.Ingredient;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class IngredientItemController {
    Ingredient ingredient;



    @FXML
    ImageView ingredientImage;
    @FXML
    Label ingredientName;


    public IngredientItemController(Ingredient ingredient){

        this.ingredient = ingredient;


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ingredientitem.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }


        ingredientName.setText(ingredient.getName());


    }

}
