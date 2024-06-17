package com.example.chiefarena;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import java.io.IOException;

public class NotifController {
    @FXML
    private ImageView accountIcon;
    @FXML
    private ImageView notifIcon;
    @FXML
    private ImageView aboIcon;

    @FXML
    protected void onAccountIconClicked() throws IOException {
        ChiefArena.showAccountView();
    }

    @FXML
    protected void onAboIconClicked() throws IOException {
        ChiefArena.showAboView();
    }



}
