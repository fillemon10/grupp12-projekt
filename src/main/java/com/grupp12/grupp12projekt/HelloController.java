package com.grupp12.grupp12projekt;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.FileNotFoundException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() throws FileNotFoundException {
        CSVReader csvReader = new CSVReader();
        String recipe = csvReader.getRecipe(1,0); //model
        welcomeText.setText(recipe); //view
    }
}