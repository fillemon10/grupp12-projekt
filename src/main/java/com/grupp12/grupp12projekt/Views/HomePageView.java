package com.grupp12.grupp12projekt.Views;

import com.grupp12.grupp12projekt.App2good2go;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class HomePageView extends VBox {
    @FXML
    private ImageView searchButton;
    @FXML
    private TextField searchField;

    private static HomePageView instance;

    public static HomePageView getInstance() {
        if (instance == null)
            instance = new HomePageView();

        return instance;
    }

    private HomePageView() {
    }

    @FXML
    public void onSearchButtonClicked() {
        String searchFieldText = searchField.getText();

    }
}
