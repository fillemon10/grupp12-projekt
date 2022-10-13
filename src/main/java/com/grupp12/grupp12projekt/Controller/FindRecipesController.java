package com.grupp12.grupp12projekt.Controller;

import com.grupp12.grupp12projekt.App2good2go;
import com.grupp12.grupp12projekt.Model;
import com.grupp12.grupp12projekt.Observer;
import com.grupp12.grupp12projekt.backend.Ingredient;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class FindRecipesController extends VBox implements IController, Observer, Initializable {
    private Model model;
    @FXML
    private ImageView searchButton;
    @FXML
    private ComboBox<String> searchComboBox;

    private static FindRecipesController instance;

    public static FindRecipesController getInstance() {
        if (instance == null)
            instance = new FindRecipesController();

        return instance;
    }

    private FindRecipesController() {
        model = Model.getInstance();

        FXMLLoader fxmlLoader = new FXMLLoader(App2good2go.class.getResource("find-recipes-page.fxml"));
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
        //        searchComboBox.setOnAction(e -> onIngredientItemClicked(ingredients, searchComboBox.getValue()));
    }

    @FXML
    public void onSearchButtonClicked() {
        matchComboValueToIngredients();
    }

    @FXML
    public void buttonPressed(KeyEvent e) {
        if (e.getCode() == KeyCode.ENTER)
            matchComboValueToIngredients();
    }

    private void matchComboValueToIngredients() {
        String searchFieldText = "" + searchComboBox.getValue();
/*        if(searchComboBox.getValue() == null)
            searchFieldText = "er";*/
        List<Ingredient> ingredients = model.findIngredients(searchFieldText);
        populateSearchField(ingredients);
    }

    private void populateSearchField(List<Ingredient> ingredients) {
        searchComboBox.getItems().clear();

        for (Ingredient i :
                ingredients) {
            searchComboBox.getItems().add(i.getName());
        }

        searchComboBox.setOnAction(e -> onIngredientItemClicked(ingredients, searchComboBox.getValue()));
    }

    private void onIngredientItemClicked(List<Ingredient> ingredients, String ingredient) {
        for (Ingredient i :
                ingredients) {
            if (i.getName() == ingredient)
                filterByIngredient(i);
        }
    }

    private void filterByIngredient(Ingredient ingredient) {
        model.filterByIngredient(ingredient);
        System.out.println(ingredient.getName());
    }

    @Override
    public void onNotify(Object observable) {

    }

}
