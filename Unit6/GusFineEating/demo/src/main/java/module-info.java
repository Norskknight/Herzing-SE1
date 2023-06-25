module gfe {
    requires javafx.controls;
    requires javafx.fxml;

    opens gfe to javafx.fxml;
    exports gfe;
}
