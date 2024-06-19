package org.example.chiefs_arena;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class ChiefsArenaApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene =  new Scene(FXMLLoader.load(getClass().getResource("home-view.fxml")));
        stage.setTitle("Chief's Arena");

        Image icon = new Image(getClass().getResourceAsStream("/org/example/chiefs_arena/img/icone.png"));
        stage.getIcons().add(icon);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}