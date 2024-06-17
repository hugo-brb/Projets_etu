package com.example.chiefarena;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ChiefArena extends Application {
    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        primaryStage.setTitle("Account Settings");
        showAccountView();
    }

    public static void showAccountView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ChiefArena.class.getResource("account-view.fxml"));;
        openStartingView(fxmlLoader);
    }

    public static void showNotifView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ChiefArena.class.getResource("notif-view.fxml"));
        openStartingView(fxmlLoader);
    }

    public static void showAboView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ChiefArena.class.getResource("abo-view.fxml"));
        openStartingView(fxmlLoader);
    }
    private static void openStartingView(FXMLLoader fxmlLoader) throws IOException {
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 900, 500);
        String css = ChiefArena.class.getResource("index.css").toExternalForm();
        scene.getStylesheets().add(css);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
