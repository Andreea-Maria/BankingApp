package com.example.banking;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {
    @FXML
    private Button signUpButton;
    @FXML
    private Button loginButton;
    @FXML
    private RadioButton adminButton;
    @FXML
    private RadioButton clientButton;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordField;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ToggleGroup toggleGroup = new ToggleGroup();
        adminButton.setToggleGroup(toggleGroup);
        clientButton.setToggleGroup(toggleGroup);

        adminButton.setSelected(true);

        signUpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String toggleName = ((RadioButton) toggleGroup.getSelectedToggle()).getText();

                if(!usernameTextField.getText().trim().isEmpty() && !passwordField.getText().trim().isEmpty()){
                        DBConnection.signUpUser(event,usernameTextField.getText(),passwordField.getText(),toggleName);
                } else {
                    System.out.println("Please fill in all information!");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Please fill in all information to sign up!");
                    alert.show();
                }
            }
        });

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBConnection.changeScene(event,"start.fxml","Log in!",null,null);

            }
        });

    }
}
