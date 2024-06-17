package com.example.chiefarena;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import java.io.IOException;

public class AboController {
    @FXML
    private VBox leftVBox;
    @FXML
    private VBox middleVBox;
    @FXML
    private VBox rightVBox;
    @FXML
    private ImageView userIcon;
    @FXML
    private ImageView notifIcon;
    @FXML
    private ImageView aboIcon;


    @FXML
    protected void onLeftVBoxMouseEntered(){
        leftVBox.setStyle("-fx-border-color: blue");
    }
    @FXML
    protected void onMiddleVBoxMouseEntered(){
        middleVBox.setStyle("-fx-border-color: blue");
    }
    @FXML
    protected void onRightVBoxMouseEntered(){
        rightVBox.setStyle("-fx-border-color: blue");
    }
    @FXML
    protected void onUserMouseEntered(){
        userIcon.setStyle("-fx-background-color: black");
    }
    @FXML
    protected void onNotifMouseEntered(){
        notifIcon.setStyle("-fx-background-color: black");
    }
    @FXML
    protected void onUserIconClicked() throws IOException {
        ChiefArena.showAccountView();
    }
    @FXML
    protected void onNotifIconClicked() throws IOException {
        ChiefArena.showNotifView();
    }

    @FXML
    protected void onElementMouseExited() {
        leftVBox.setStyle("-fx-border: none");
        middleVBox.setStyle("-fx-border: none");
        rightVBox.setStyle("-fx-border: none");
        userIcon.setStyle("-fx-background-color: none");
        notifIcon.setStyle("-fx-background-color: none");
        aboIcon.setStyle("-fx-background-color: none");
    }
}