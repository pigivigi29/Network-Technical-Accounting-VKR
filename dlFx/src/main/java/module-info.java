module dlFx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires dlSpring;
    requires com.fasterxml.jackson.databind;

    opens com.example.dl_fx to javafx.fxml;
    exports com.example.dl_fx;
}