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
        FXMLLoader fxmlLoader = new FXMLLoader(ChiefsArenaApplication.class.getResource("home-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 843, 800);
        stage.setTitle("Chief's Arena");
        //stage.getIcons().add(new Image("/org/example/chiefs_arena/img/Logo_ChiefsArena_transparentBlack.png"));

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}