package com.grupp12.grupp12projekt;

import com.grupp12.grupp12projekt.viewsAndControllers.NavigationController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App2good2go extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App2good2go.class.getResource("rootPage.fxml"));
        fxmlLoader.setController(NavigationController.getInstance());
        Scene scene = new Scene(fxmlLoader.load(), 780, 500);
        stage.setTitle("2good2go");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        App2good2go.launch();
    }
}

