package org.example.chiefs_arena;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class AppController {
    @FXML
    public HBox btnCreate;

    @FXML
    public void actionCreateEvent(javafx.scene.input.MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("create-view.fxml"));
        fxmlLoader.setController(this);

        Stage fenetre = (Stage) btnCreate.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 843, 800);

        fenetre.setScene(scene);
        fenetre.show();
    }
}