package com.grupp12.grupp12projekt.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.FileNotFoundException;

public class Controller {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() throws FileNotFoundException {
        //String recipe = csvReader.getRecipe(1,0); //modifierar modellen
        //welcomeText.setText(recipe); //uppdaterar viewn
    }
}