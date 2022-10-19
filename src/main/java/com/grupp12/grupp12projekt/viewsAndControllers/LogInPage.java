package com.grupp12.grupp12projekt.viewsAndControllers;

import com.grupp12.grupp12projekt.App2good2go;
import com.grupp12.grupp12projekt.backend.Model;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
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
    private static LogInPage instance;

    public static LogInPage getInstance() {
        if (instance == null) instance = new LogInPage();
        return instance;
    }

    public LogInPage() {
        navigationController = NavigationController.getInstance();
        model = Model.getInstance();

        FXMLLoader fxmlLoader = new FXMLLoader(App2good2go.class.getResource("logInPage.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
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
        clearFields();
    }

    @FXML
    private void clickedOnLogInPage() {
        errorLabel.setVisible(false);
        logIn.toFront();
        clearFields();
    }

    @FXML
    private void clickedOnSignUp() {
        try {
            model.createNewUser(signUpUname.getText(), signUpPword.getText());
            navigationController.logInOrSignUp();
        } catch (IllegalArgumentException e) {
            errorLabel.setText(e.getMessage());
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
            errorLabel.setVisible(true);
        }
    }

    void clearFields() {
        logInUname.clear();
        logInPword.clear();
        signUpUname.clear();
        signUpPword.clear();
    }
}
