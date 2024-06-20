package org.example.chiefs_arena;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.chiefs_arena.App.*;
import org.example.chiefs_arena.exception.ConcoursDejaExistant;
import org.example.chiefs_arena.user.ConcoursList;
import org.example.chiefs_arena.user.Handler;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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

    @FXML
    private Label username;
    @FXML
    private Label welcome;
    @FXML
    private GridPane concours_info_list;

    public void initialize() throws IOException {
        String username = Handler.getInstance().getUser().getUsername();
        this.username.setText(username);
        if (welcome != null) welcome.setText("Bienvenue, " + username);
        ConcoursList concours = Handler.getInstance().getAllConcours();
        UpdateConcoursList.update(concours, concours_content_wrapper, concours_info_list);
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

    /** Création d'un concours */
    @FXML
    private TextField contest_name;
    @FXML
    private TextArea contest_desc;
    @FXML
    private ComboBox contest_cat;

    @FXML
    public void create(ActionEvent e) throws ConcoursDejaExistant
    {
        if (contest_name.getText().isBlank())
        {
            return;
        }
        if (contest_desc.getText().isBlank() || contest_desc.getText().length() > 1000)
        {
            return;
        }
        ConcoursList all_concours = Handler.getInstance().getAllConcours();
        if (all_concours == null) all_concours = new ConcoursList();
        all_concours.addConcours(
                new Concours(
                        contest_name.getText(),
                        contest_desc.getText(),
                        new Date(System.currentTimeMillis()),
                        new Date(System.currentTimeMillis()),
                        new Lieu(
                                "lieu-1",
                                    100
                        ),
                        Arrays.asList(new Categorie(
                                "nom",
                                Arrays.asList("sous-categorie")
                        )),
                        Arrays.asList(new Partenaire(
                            "id",
                            "nom",
                            999999999,
                            "contraintes"
                        )),
                        Arrays.asList(new Personne(
                                1,
                                "nom",
                                "prenom",
                                94,
                                "role"
                        )),
                        new Classement()
                    )
        );
        all_concours.save();
        UpdateConcoursList.update(all_concours, concours_content_wrapper, concours_info_list);
    }
}