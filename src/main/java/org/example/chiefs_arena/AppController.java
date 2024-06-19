package org.example.chiefs_arena;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.chiefs_arena.user.ConcoursList;
import org.example.chiefs_arena.user.Handler;

import java.io.IOException;
import java.util.Arrays;

public class AppController {
    @FXML
    public HBox btnCreate;
    public HBox btnHome;
    public HBox mes_concours;

    @FXML
    private VBox concours_content_wrapper;

    @FXML
    public void actionCreateEvent(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("create-view.fxml"));

        Stage fenetre = (Stage) concours_content_wrapper.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());

        fenetre.setScene(scene);
        fenetre.show();
    }


    @FXML
    public void actionGoHome(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home-view.fxml"));

        Stage fenetre = (Stage) btnHome.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());

        fenetre.setScene(scene);
        fenetre.show();
    }

    @FXML
    public void actionGoMyConcours(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("concours-view.fxml"));

        Stage fenetre = (Stage) mes_concours.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());

        fenetre.setScene(scene);
        fenetre.show();
    }

    @FXML
    public void actionGoAnalyse() throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("analyse-view.fxml"));

        Stage fenetre = (Stage) concours_content_wrapper.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());

        fenetre.setScene(scene);
        fenetre.show();
    }

    /**
     * controller pour la left bar
     */

    public void initialize() throws IOException {
        ConcoursList concours = Handler.gson.fromJson(Handler.fetch_data(Handler.concours_file), ConcoursList.class);
        concours_content_wrapper.getChildren().clear();
        if (concours == null || concours.getConcours().isEmpty())
        {
            concours_content_wrapper.setSpacing(8d);
            Text no_concours = new Text("Aucun concours");
            Text create = new Text("Commencez à en créer avec Chef's Arena !");
            Arrays.asList(no_concours, create).forEach(text -> {
                text.setWrappingWidth(190);
                text.getStyleClass().add("text");
                concours_content_wrapper.getChildren().add(text);
            });
        }
        else
        {
            concours.getConcours().forEach(c -> {
                Label label = new Label(c.getNom());
                label.getStyleClass().add("text");
                label.addEventHandler(MouseEvent.MOUSE_ENTERED, this::mouse_entered);
                label.addEventHandler(MouseEvent.MOUSE_ENTERED, this::mouse_entered);
                concours_content_wrapper.getChildren().add(label);
            });
        }
    }

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