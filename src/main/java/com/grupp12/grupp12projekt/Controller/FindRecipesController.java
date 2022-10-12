package com.grupp12.grupp12projekt.Controller;

import com.grupp12.grupp12projekt.App2good2go;
import com.grupp12.grupp12projekt.Model;
import com.grupp12.grupp12projekt.Observable;
import com.grupp12.grupp12projekt.Observer;
import com.grupp12.grupp12projekt.backend.Ingredient;
import com.grupp12.grupp12projekt.backend.Recipe;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindRecipesController extends VBox implements IController, Observer {
    private Model model;

    @FXML
    private ImageView searchButton;
    @FXML
    private TextField searchField;
    @FXML
    private FlowPane recipeCardFlowPane;


    private static FindRecipesController instance;

    public static FindRecipesController getInstance() {
        if (instance == null)
            instance = new FindRecipesController();

        return instance;
    }

    public void setUpRecipes(Model model){
        this.model = model;
        URL receptkorturl = App2good2go.class.getResource("recipelistitem.fxml");
        recipeCardFlowPane.getChildren().clear();
        for(Recipe rec : model.getRecipes()){
           RecipeListItemController recipelistitemcontroller = new RecipeListItemController(rec, model.getStorage());
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(receptkorturl);
                fxmlLoader.setController(recipelistitemcontroller);
                AnchorPane cardAnchor = fxmlLoader.load();
                recipeCardFlowPane.getChildren().add(cardAnchor);
            }
            catch (IOException exception) {
                throw new RuntimeException(exception);
            }
    }
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

    @FXML
    public void initialize(){
        setUpRecipes(this.model);

    }

    @FXML
    public void onSearchButtonClicked() {
        String searchFieldText = searchField.getText();
        List<Ingredient> ingredients = model.findIngredients(searchFieldText);
        //TODO: update view
    }

    @FXML
    public void onIngredientItemClicked() {

        //filterByIngredient(ingredient);
    }

    private void filterByIngredient(Ingredient ingredient) {
        model.filterByIngredient(ingredient);
    }

    @Override
    public void onNotify(Object observable) {
    }
}
