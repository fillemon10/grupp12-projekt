package Views;

import com.grupp12.grupp12projekt.App2good2go;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class HomePage extends VBox {
    @FXML
    private ImageView searchButton;
    @FXML
    private TextField searchField;

    private static HomePage instance = new HomePage();

    public static HomePage getInstance() {
        return instance;
    }

    private HomePage() {
        FXMLLoader fxmlLoader = new FXMLLoader(App2good2go.class.getResource("com.grupp12.grupp12projekt/home-page.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

}
