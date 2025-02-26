module com.iescelia {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.iescelia to javafx.fxml;
    exports com.iescelia;
}
