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
    public HBox btnHome;
    public HBox mes_concours;

    @FXML
    public void actionCreateEvent(javafx.scene.input.MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("create-view.fxml"));

        Stage fenetre = (Stage) btnCreate.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());

        fenetre.setScene(scene);
        fenetre.show();
    }

    @FXML
    public void actionGoHome(javafx.scene.input.MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home-view.fxml"));

        Stage fenetre = (Stage) btnHome.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());

        fenetre.setScene(scene);
        fenetre.show();
    }

    @FXML
    public void actionGoMyConcours(javafx.scene.input.MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("concours.fxml"));

        Stage fenetre = (Stage) mes_concours.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());

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