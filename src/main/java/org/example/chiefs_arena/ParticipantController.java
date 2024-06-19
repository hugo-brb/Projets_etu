package org.example.chiefs_arena;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import org.example.chiefs_arena.App.Participant;
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

import java.io.Serial;

public class ParticipantController {

    @FXML
    public HBox btnCreate;
    public HBox btnHome;
    public HBox mes_concours;

    @FXML
    private VBox concours_content_wrapper;

    // --------------------------------------

    @FXML
    private TextField nomField;

    @FXML
    private TextField prenomField;

    @FXML
    private TextField ageField;

    @FXML
    private Button creerParticipantButton;

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

// ---------------------------------------------------

    @FXML
    private void creerParticipant() {
        // Récupérer les valeurs des champs
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        int age;

        try {
            age = Integer.parseInt(ageField.getText());
        } catch (NumberFormatException e) {
            // Gestion de l'erreur si l'âge n'est pas un entier valide
            showAlert("Erreur de saisie", "Veuillez entrer un âge valide.");
            return;
        }

        // Créer et retourner une nouvelle instance de Participant
        int Serial = 1;
        Participant participant = new Participant(Serial ,nom, prenom, age );

        // Afficher une confirmation ou traiter l'objet participant
        showAlert("Succès", "Participant créé : " + participant.getNom() + " " + participant.getPrenom() + ", Âge: " + participant.getAge());
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
