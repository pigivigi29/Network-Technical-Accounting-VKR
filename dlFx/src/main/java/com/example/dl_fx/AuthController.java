package com.example.dl_fx;

import com.example.dl_fx.httpRequests.HttpRequests;
import com.example.dl_spring.dto.AuthorizedUserDto;
import com.fasterxml.jackson.databind.JsonNode;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import com.fasterxml.jackson.databind.ObjectMapper;


public class AuthController implements Initializable {
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
    public void loadWeatherForecast() throws IOException {
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
        AuthorizedUserDto authorizedUserDto = new AuthorizedUserDto(login.getText(), password.getText());
        String uri = "login";
        HttpRequests.TOKEN = HttpRequests.AuthRequest(authorizedUserDto, uri);
        loadWeatherForecast();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        label.setText("This is a second controller");
    }
}
