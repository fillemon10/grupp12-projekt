package com.grupp12.grupp12projekt;

import com.grupp12.grupp12projekt.Controller.HomePageController;
import com.grupp12.grupp12projekt.Controller.NavigationbarController;
import com.grupp12.grupp12projekt.Controller.StorageController;
import com.grupp12.grupp12projekt.backend.Storage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App2good2go extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App2good2go.class.getResource("root-page.fxml"));
        fxmlLoader.setController(NavigationbarController.getInstance());
        Scene scene = new Scene(fxmlLoader.load(), 780 ,500);
        stage.setTitle("2good2go");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}