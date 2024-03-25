package com.example.dl_fx;

import com.example.dl_fx.httpRequests.HttpRequests;
import com.example.dl_spring.model.User;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private Button button2;

    @FXML
    public void loadWeatherForecast() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("AuthController.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = (Stage) button.getScene().getWindow();
        stage.setTitle("Authorization page");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void sendRequest() throws URISyntaxException, IOException, InterruptedException {
        String uri = "api/page/1";
        JsonNode rootNode = HttpRequests.GetRequest(uri);
        ObjectMapper objectMapper = new ObjectMapper();
        ((ObjectNode) rootNode).remove("enabled");
        ((ObjectNode) rootNode).remove("authorities");
        User user = objectMapper.treeToValue(rootNode, User.class);
        user.setPassword("****");
        System.out.println(user);
        label.setText(user.toString());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        label.setText("This is a first controller");
    }
}
