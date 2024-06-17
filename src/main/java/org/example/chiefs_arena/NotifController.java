package com.example.chiefarena;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import java.io.IOException;

public class NotifController {
    @FXML
    private Button accountIcon;
    @FXML
    private Button notifIcon;
    @FXML
    private Button aboIcon;

    @FXML
    protected void onAccountIconClicked() throws IOException {
        ChiefArena.showAccountView();
    }

    @FXML
    protected void onAboIconClicked() throws IOException {
        ChiefArena.showAboView();
    }



}
