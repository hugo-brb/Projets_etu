package org.example.chiefs_arena;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;

public class AppController {
    @FXML
    public HBox btnCreate;

    @FXML
    public void actionCreateEvent(javafx.scene.input.MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("create.fxml"));
        fxmlLoader.setController(this);

        Stage fenetre = (Stage) btnCreate.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 843, 800);

        fenetre.setScene(scene);
        fenetre.show();
    }

    /**
     * controller pour la left bar
     */
    @FXML
    public void mouse_entered(MouseEvent e)
    {
        ((Node) e.getSource()).setCursor(Cursor.HAND);
    }

    @FXML
    public void mouse_exited(MouseEvent e)
    {
        ((Node) e.getSource()).setCursor(Cursor.HAND);
    }
}