package com.grupp12.grupp12projekt.controllers;

import com.grupp12.grupp12projekt.App2good2go;
import com.grupp12.grupp12projekt.Model;
import com.grupp12.grupp12projekt.Observer;
import com.grupp12.grupp12projekt.backend.Ingredient;
import com.grupp12.grupp12projekt.backend.Recipe;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FindRecipesController extends VBox implements Observer, Initializable {
    private Model model;
    private List<Ingredient> filteredIngredients;
    @FXML
    private ImageView searchButton;
    @FXML
    private FlowPane recipeCardFlowPane;
    @FXML
    private ComboBox<String> searchComboBox;

    @FXML
    private Button clearFiltersButton;

    private static FindRecipesController instance;

    public static FindRecipesController getInstance() {
        if (instance == null) instance = new FindRecipesController();

        return instance;
    }

    private FindRecipesController() {
        model = Model.getInstance();
        model.addObserver(this);
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
        //Updates the value of the Combo Box as soon as something is entered
/*        searchComboBox.getEditor().textProperty().addListener((observableValue, s, t1) -> {
            if (!isIngredient(t1) && !(t1.equals(""))) {
                matchComboValueToIngredients();
            }
        });
        //Selects the Ingredient chosen, but has some bugs
        searchComboBox.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> {
            if (isIngredient(t1)) onIngredientItemClicked(searchComboBox.getSelectionModel().getSelectedItem());
        });*/

        //recipeCardFlowPane.prefHeightProperty().bind(recipeCardScrollPane.heightProperty());
        //recipeCardFlowPane.prefWidthProperty().bind(recipeCardScrollPane.widthProperty());

        searchComboBox.setOnAction(e -> searchComboAction());
        updateRecipeList(model.getRecipes());
    }

    private void updateRecipeList(List<Recipe> recipes) {
        recipes = model.get20bestMatchingRecipes(recipes);
        recipeCardFlowPane.getChildren().clear();
        for (Recipe recipe : recipes) {
            recipeCardFlowPane.getChildren().add(new RecipeListItemController(recipe));
        }
    }

    @FXML
    public void onClearFiltersButtonClicked(){
        updateRecipeList(model.getRecipes());
        searchComboBox.getEditor().clear();
    }

    @FXML
    public void onSearchButtonClicked() {
        matchComboValueToIngredients();
    }

    private void searchComboAction() {
        String comboValue = searchComboBox.getValue();
        if (!searchComboBox.getItems().contains(comboValue)) matchComboValueToIngredients();
        else {
            onIngredientItemClicked(comboValue);
        }
    }

    private void matchComboValueToIngredients() {
        String searchFieldText = searchComboBox.getEditor().getText();
        filteredIngredients = model.findIngredients(searchFieldText);
        populateSearchField();
    }

    private void populateSearchField() {
        searchComboBox.getItems().clear();

        for (Ingredient i : filteredIngredients) {
            searchComboBox.getItems().add(i.getName());
        }
        searchComboBox.show();
    }

    private void onIngredientItemClicked(String ingredient) {
        for (Ingredient i : filteredIngredients) {
            if (i.getName() == ingredient) filterByIngredient(i);
        }
    }

    private void filterByIngredient(Ingredient ingredient) {
        model.filterByIngredient(ingredient);
    }

    @Override
    public void onNotify() {
        updateRecipeList(model.getFilteredRecipes());
/*        for (Recipe r :
                model.getFilteredRecipes()) {
            System.out.println(r.getName());
        }*/
    }

/*    private boolean isIngredient(String s) {
        boolean isIngredient = false;
        for (Ingredient i : filteredIngredients) {
            if (i.getName().equals(s)) {
                isIngredient = true;
                break;
            }
        }
        return isIngredient;
    }*/

}