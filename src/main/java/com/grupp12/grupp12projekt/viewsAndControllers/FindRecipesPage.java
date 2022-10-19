package com.grupp12.grupp12projekt.viewsAndControllers;

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
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Class for the find recipes page
 */

public class FindRecipesPage extends VBox implements Observer, Initializable {
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

    private static FindRecipesPage instance;

    public static FindRecipesPage getInstance() {
        if (instance == null) instance = new FindRecipesPage();
        return instance;
    }



    private FindRecipesPage() {
        model = Model.getInstance();
        model.addObserver(this);
        filteredIngredients = new ArrayList<>();

        FXMLLoader fxmlLoader = new FXMLLoader(App2good2go.class.getResource("findRecipePage.fxml"));
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
        searchComboBox.setOnAction(e -> searchComboAction());
        updateRecipeList(model.getAllRecipes());
    }

    /**
     * Method that gets the 20 top matching recipes from the model and adds each of these recipes to the FlowPane in find recipes page.
     * @param recipes recipes are supplied
     */

    void updateRecipeList(List<Recipe> recipes) {
        List<Recipe> bestMatchingRecipes = model.get20bestMatchingRecipes(recipes);
        recipeCardFlowPane.getChildren().clear();
        for (Recipe recipe : bestMatchingRecipes) {
            recipeCardFlowPane.getChildren().add(new FindRecipeListItem(recipe));
        }
    }

    @FXML
    private void onClearFiltersButtonClicked() {
        updateRecipeList(model.getAllRecipes());
        searchComboBox.getEditor().clear();
        searchComboBox.hide();
    }

    @FXML
    private void onSearchButtonClicked() {
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
    }

}