package com.example.chiefarena;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import java.io.IOException;

public class AccountController {
    @FXML
    private ImageView accountIcon;
    @FXML
    private ImageView notifIcon;
    @FXML
    private ImageView aboIcon;
    @FXML
    private Button modify;
    @FXML
    private TextField user;
    @FXML
    private TextField username;
    @FXML
    private TextField tfMail;
    @FXML
    private PasswordField pfPassword;
    @FXML
    private Button save;
    @FXML
    private Button delete;

    @FXML
    protected void onUserMouseEntered(){
        accountIcon.setStyle("-fx-background-color: black");
    }
    @FXML
    protected void onNotifMouseEntered(){
        notifIcon.setStyle("-fx-background-color: black");
    }

    @FXML
    protected void onNotifIconClicked() throws IOException {
        ChiefArena.showNotifView();
    }
    @FXML
    protected void onAboIconClicked() throws IOException {
        ChiefArena.showAboView();
    }
    @FXML
    protected void setUser(){
        user.setText("");
    }
    @FXML
    protected void setUsername(){
        username.setText("");
    }
    @FXML
    protected void setUserIdentity(){
        user.setText("User");
        username.setText("Username");
    }
    @FXML
    protected void deleteUserInfos(){
        tfMail.setText("");
        pfPassword.setText("");
    }

    @FXML
    protected void onElementMouseExited() {
        accountIcon.setStyle("-fx-background-color: none");
        notifIcon.setStyle("-fx-background-color: none");
        aboIcon.setStyle("-fx-background-color: none");
    }
}
