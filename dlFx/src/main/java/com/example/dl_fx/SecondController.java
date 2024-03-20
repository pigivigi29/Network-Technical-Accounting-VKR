package com.example.dl_fx;

import com.example.dl_fx.httpRequests.HttpRequests;
import com.example.dl_spring.model.User;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ResourceBundle;
import com.fasterxml.jackson.databind.ObjectMapper;


public class SecondController implements Initializable {
    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private Button button2;
    @FXML
    private TextField login;
    @FXML
    private TextField password;

    @FXML
    public void loadWeatherForecast(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("MainController.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = (Stage) button.getScene().getWindow();
        stage.setTitle("Authorization page");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void sendRequest() throws IOException, URISyntaxException, InterruptedException {
        String requestString = "{\n\"name\": \"" + login.getText() + "\",\n" +
                "\"password\": \"" + password.getText() + "\"\n}";
        String uri = "http://localhost:8080/api/page";
        JsonNode rootNode = HttpRequests.PostRequest(requestString, uri);
        ObjectMapper objectMapper = new ObjectMapper();
        ((ObjectNode) rootNode).remove("enabled");
        ((ObjectNode) rootNode).remove("authorities");
        User user = objectMapper.treeToValue(rootNode, User.class);
        user.setPassword("****");
        label.setText(user.toString());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        label.setText("This is a second controller");
    }
}
