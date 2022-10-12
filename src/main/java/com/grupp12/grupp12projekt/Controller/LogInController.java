package com.grupp12.grupp12projekt.Controller;

import com.grupp12.grupp12projekt.App2good2go;
import com.grupp12.grupp12projekt.Model;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LogInController extends AnchorPane {

    public LogInController() {

        FXMLLoader fxmlLoader = new FXMLLoader(App2good2go.class.getResource("logIn.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
@FXML
    public void clickedOnSignUpPage(Event event){

}
    @FXML
    public void clickedOnLogInPage(Event event){

    }
@FXML
    public void signUp(){}
    @FXML
    public void logIn(){}
}
