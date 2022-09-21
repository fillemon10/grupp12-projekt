module com.grupp12.grupp12projekt {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.opencsv;


    opens com.grupp12.grupp12projekt to javafx.fxml;
    exports com.grupp12.grupp12projekt;
}