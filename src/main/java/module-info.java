module com.example.banking {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.banking to javafx.fxml;
    exports com.example.banking;
}