module com.grupp12.grupp12projekt {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.opencsv;
    requires junit;
    requires org.testng;


    opens com.grupp12.grupp12projekt to javafx.fxml;
    exports com.grupp12.grupp12projekt;
    exports com.grupp12.grupp12projekt.backend;
    opens com.grupp12.grupp12projekt.backend to javafx.fxml;
}