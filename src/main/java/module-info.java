module hu.sakk {
    requires javafx.controls;
    requires javafx.fxml;

    opens hu.sakk to javafx.fxml;
    exports hu.sakk;
}
