module dlFx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires dlSpring;
    requires com.fasterxml.jackson.databind;
    requires spring.web;

    opens com.example.dl_fx to javafx.fxml;

    exports com.example.dl_fx;
    exports com.example.dl_fx.controller;
    opens com.example.dl_fx.controller to javafx.fxml;
}