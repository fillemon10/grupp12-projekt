package com.grupp12.grupp12projekt.viewsAndControllers;

import com.grupp12.grupp12projekt.App2good2go;
import com.grupp12.grupp12projekt.Model;
import com.grupp12.grupp12projekt.Observer;
import com.grupp12.grupp12projekt.backend.Ingredient;
import com.grupp12.grupp12projekt.backend.Recipe;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class StoragePage extends AnchorPane implements Initializable, Observer {
    @FXML
    private AnchorPane rootPane;
    @FXML
    private FlowPane myStorageFlowpane;
    @FXML
    private  FlowPane allIngredientFlowpane;

    private Model model;
    private static StoragePage instance;

    private Map<String, StorageAllIngredientItem> storageAllIngredientItemMap = new HashMap<>();

    public static StoragePage getInstance() {
        if (instance == null)
            instance = new StoragePage();
        return instance;
    }

    private StoragePage() {
        model = Model.getInstance();

        FXMLLoader fxmlLoader = new FXMLLoader(App2good2go.class.getResource("storagePage.fxml"));
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
        for (Ingredient ingredient: model.getAllIngredients()) {
            StorageAllIngredientItem storageAllIngredientItem = new StorageAllIngredientItem(ingredient);
            storageAllIngredientItemMap.put(ingredient.getName(), storageAllIngredientItem);
        }
        updateStorageList();
        updateAllProductsList();
    }

    public void updateStorageList(){
        myStorageFlowpane.getChildren().clear();
        List<Ingredient> ingredients = model.getStorageContent();
        for (Ingredient i : ingredients) {
            myStorageFlowpane.getChildren().add(new StorageIngredientItem(i));
        }
    }

    public void updateAllProductsList(){
        allIngredientFlowpane.getChildren().clear();
        List<Ingredient> allIngredients = model.getAllIngredients();
        StorageAllIngredientItem storageAllIngredientItem;

        for (Ingredient i: allIngredients) {
            storageAllIngredientItem = storageAllIngredientItemMap.get(i.getName());
            allIngredientFlowpane.getChildren().add((storageAllIngredientItem));
    }

}


    @Override
    public void onNotify() {
        updateAllProductsList();
        updateStorageList();
    }
}
