package org.example.chiefs_arena.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    private Button userIcon;
    @FXML
    private Button notifIcon;
    @FXML
    private Button aboIcon;

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
    protected void onAccountIconClicked() throws IOException {
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
    }
}