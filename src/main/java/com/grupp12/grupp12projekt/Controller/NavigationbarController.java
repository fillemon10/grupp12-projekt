package com.grupp12.grupp12projekt.Controller;
import com.grupp12.grupp12projekt.Model;
import javafx.fxml.FXML;

public class NavigationbarController implements IController {

    private Model model;

    @Override
    public void initialize() {
        model = Model.getInstance();

    }
}