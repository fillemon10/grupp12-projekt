package com.grupp12.grupp12projekt.Controller;

import com.grupp12.grupp12projekt.App2good2go;
import com.grupp12.grupp12projekt.Model;
import com.grupp12.grupp12projekt.backend.Ingredient;
import com.grupp12.grupp12projekt.backend.Storage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StorageController extends AnchorPane implements IController {
    @FXML
    private AnchorPane rootPane;
    @FXML
    private FlowPane mystorgaeflowpane;

    private Model model = Model.getInstance();
    private static StorageController instance;

    public static StorageController getInstance() {
        if (instance == null)
            instance = new StorageController();
        return instance;
    }

    private StorageController() {
        updatemystoragelist();

        FXMLLoader fxmlLoader = new FXMLLoader(App2good2go.class.getResource("storage-view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private void updatemystoragelist(){
        //funkar inte än
        mystorgaeflowpane.getChildren().clear();
        List<Ingredient> ingredients =model.getStorageContent();
        ingredients.add(new Ingredient(1,"Fisk"));
        for (Ingredient i: ingredients) {
            AddedStorageIngridientsController addedStorageIngridientsController = new AddedStorageIngridientsController(i,this);


            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("added-ingridient-item-in-storage.fxml"));
                fxmlLoader.setController(addedStorageIngridientsController);
                AnchorPane ingridientAnchor = fxmlLoader.load();
                mystorgaeflowpane.getChildren().add(ingridientAnchor);

            } catch (IOException exception) {
                throw new RuntimeException(exception);
            }

        }

    }
}
