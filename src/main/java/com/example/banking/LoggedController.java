package com.example.banking;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class LoggedController implements Initializable {
    @FXML
    private Button logoutButton;
    @FXML
    private Label welcomeLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logoutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               DBConnection.changeScene(event,"start.fxml","Log in!",null,null);

            }
        });
    }

    public void setUserInformation(String username,String option){
        welcomeLabel.setText("Welcome" + username + "!");
    }
}
