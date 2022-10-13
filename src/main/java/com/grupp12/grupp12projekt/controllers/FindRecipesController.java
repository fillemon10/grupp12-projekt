package com.grupp12.grupp12projekt.controllers;

import com.grupp12.grupp12projekt.App2good2go;
import com.grupp12.grupp12projekt.Model;
import com.grupp12.grupp12projekt.Observer;
import com.grupp12.grupp12projekt.backend.Ingredient;
import com.grupp12.grupp12projekt.backend.Recipe;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FindRecipesController extends VBox implements IController, Observer, Initializable {
    private Model model;
    private List<Ingredient> filteredIngredients;
    @FXML
    private ImageView searchButton;
    @FXML
    private FlowPane recipeCardFlowPane;

    @FXML
    private ComboBox<String> searchComboBox;

    private static FindRecipesController instance;

    public static FindRecipesController getInstance() {
        if (instance == null) instance = new FindRecipesController();

        return instance;
    }

    public void setUpRecipes(Model model) {
        this.model = model;
        URL receptkorturl = App2good2go.class.getResource("recipelistitem.fxml");
        recipeCardFlowPane.getChildren().clear();
        for (Recipe rec : model.getRecipes()) {
            RecipeListItemController recipelistitemcontroller = new RecipeListItemController(rec, model.getStorage());
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(receptkorturl);
                fxmlLoader.setController(recipelistitemcontroller);
                AnchorPane cardAnchor = fxmlLoader.load();
                recipeCardFlowPane.getChildren().add(cardAnchor);
            } catch (IOException exception) {
                throw new RuntimeException(exception);
            }
        }
    }

    private FindRecipesController() {
        model = Model.getInstance();
        filteredIngredients = new ArrayList<>();

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
        //searchComboBox.setOnAction(e -> onIngredientItemClicked(ingredients, searchComboBox.getValue()));

        //Updates the value of the Combo Box as soon as something is entered
/*        searchComboBox.getEditor().textProperty().addListener((obs, oldText, newText) -> {
            searchComboBox.setValue(newText);
        });*/

        searchComboBox.setOnAction(e -> searchComboAction());
        //searchComboBox.addEventFilter(Event.ANY, e -> System.out.println(e));
        setUpRecipes(this.model);
    }

    @FXML
    public void onSearchButtonClicked() {
        matchComboValueToIngredients();
    }

/*    @FXML
    public void buttonPressed(KeyEvent e) {
        if (e.getCode() == KeyCode.ENTER) matchComboValueToIngredients();
    }*/

    private void searchComboAction() {
        String comboValue = searchComboBox.getValue();
        if (!searchComboBox.getItems().contains(comboValue))
            matchComboValueToIngredients();
        else {
            onIngredientItemClicked(comboValue);
        }
    }

    private void matchComboValueToIngredients() {
        String searchFieldText = searchComboBox.getValue();
        filteredIngredients = model.findIngredients(searchFieldText);
        populateSearchField();
    }

    private void populateSearchField() {
        searchComboBox.getItems().clear();

        for (Ingredient i : filteredIngredients) {
            searchComboBox.getItems().add(i.getName());
        }

        searchComboBox.show();
        //Does not work for some reason
/*        if (!filteredIngredients.isEmpty()) {
            String firstIngredient = filteredIngredients.get(0).getName();
            searchComboBox.getEditor().setText("Milk");
        }*/

        //searchComboBox.setPromptText(filteredIngredients.get(0).getName());
        //searchComboBox.getSelectionModel().selectFirst();
    }

    private void onIngredientItemClicked(String ingredient) {
        for (Ingredient i : filteredIngredients) {
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
