package com.example.chiefarena;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;

public class AccountController {
    @FXML
    private Button accountIcon;
    @FXML
    private Button notifIcon;
    @FXML
    private Button aboIcon;
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
}
