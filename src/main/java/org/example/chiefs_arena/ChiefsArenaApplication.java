package org.example.chiefs_arena;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ChiefsArenaApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new FXMLLoader.load(getClass().getRessource("home-view.fxml"));
        stage.setTitle("Chief's Arena");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
