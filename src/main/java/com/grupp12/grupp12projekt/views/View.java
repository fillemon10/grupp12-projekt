package com.grupp12.grupp12projekt.views;

import com.grupp12.grupp12projekt.App2good2go;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class View {
    public void renderView(String viewName){
        FXMLLoader fxmlLoader = new FXMLLoader(App2good2go.class.getResource(String.format("com.grupp12.grupp12projekt/%s.fxml",viewName)));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    };


}
