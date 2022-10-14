package com.grupp12.grupp12projekt.controllers;

import com.grupp12.grupp12projekt.Model;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LogInController extends AnchorPane {

    @FXML
    private AnchorPane logIn;
    @FXML
    private AnchorPane signUp;
    @FXML
    private TextField logInUname;
    @FXML
    private TextField logInPword;
    @FXML
    private TextField signUpUname;
    @FXML
    private TextField signUpPword;


    private NavigationController navigationController;
    private Model model;

    public LogInController() {
        navigationController = navigationController.getInstance();
        model = model.getInstance();
    }

    @FXML
    public void clickedOnSignUpPage() {
        signUp.toFront();
    }

    @FXML
    public void clickedOnLogInPage() {
        logIn.toFront();
    }

    @FXML
    public void clickedOnSignUp() {
        model.createNewUser(signUpUname.getText(), signUpPword.getText());
        navigationController.logInOrSignUp();
    }

    @FXML
    public void clickedOnLogIn() {
        model.logInUser(logInUname.getText(), logInPword.getText());
        navigationController.logInOrSignUp();
    }
}
