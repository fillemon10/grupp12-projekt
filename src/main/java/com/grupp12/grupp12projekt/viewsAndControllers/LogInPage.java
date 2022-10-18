package com.grupp12.grupp12projekt.viewsAndControllers;

import com.grupp12.grupp12projekt.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class LogInPage extends AnchorPane implements Initializable {

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
    @FXML
    private Label errorLabel;


    private static NavigationController navigationController;
    private static Model model;

    public LogInPage() {
        navigationController = NavigationController.getInstance();
        model = Model.getInstance();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errorLabel.setVisible(false);

        logInPword.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                clickedOnLogIn();
            }
        });

        signUpPword.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                clickedOnSignUp();
            }
        });

    }

    @FXML
    private void clickedOnSignUpPage() {
        errorLabel.setVisible(false);
        signUp.toFront();
    }

    @FXML
    private void clickedOnLogInPage() {
        errorLabel.setVisible(false);
        logIn.toFront();
    }

    @FXML
    private void clickedOnSignUp() {
        try {
            model.createNewUser(signUpUname.getText(), signUpPword.getText());
            navigationController.logInOrSignUp();
        } catch (IllegalArgumentException e) {
            errorLabel.setText(e.getMessage());
            errorLabel.toFront();
            errorLabel.setVisible(true);
        }
    }

    @FXML
    private void clickedOnLogIn() {
        try {
            model.logInUser(logInUname.getText(), logInPword.getText());
            navigationController.logInOrSignUp();
        } catch (IllegalArgumentException e) {
            errorLabel.setText(e.getMessage());
            errorLabel.toFront();
            errorLabel.setVisible(true);
        }
    }
}
