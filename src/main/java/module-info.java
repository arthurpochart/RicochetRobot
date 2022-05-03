module com.app.richetrobot {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.app.richetrobot to javafx.fxml;
    exports com.app.richetrobot;
}