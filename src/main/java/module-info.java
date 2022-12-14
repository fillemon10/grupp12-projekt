module com.grupp12.grupp12projekt {
    requires javafx.controls;
    requires javafx.fxml;
    requires jsondb.core;

    opens com.grupp12.grupp12projekt to javafx.fxml;
    exports com.grupp12.grupp12projekt;
    exports com.grupp12.grupp12projekt.backend;
    opens com.grupp12.grupp12projekt.backend to javafx.fxml;
    exports com.grupp12.grupp12projekt.backend.dataAccess;
    opens com.grupp12.grupp12projekt.backend.dataAccess to javafx.fxml;
    exports com.grupp12.grupp12projekt.viewsAndControllers;
    opens com.grupp12.grupp12projekt.viewsAndControllers to javafx.fxml;
}