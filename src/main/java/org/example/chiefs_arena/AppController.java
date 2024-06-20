package org.example.chiefs_arena;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.chiefs_arena.App.*;
import org.example.chiefs_arena.exception.ConcoursDejaExistant;
import org.example.chiefs_arena.user.ConcoursList;
import org.example.chiefs_arena.user.Handler;

import javax.swing.text.html.ImageView;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

public class AppController {
    @FXML
    public HBox btnCreate;
    public HBox btnHome;
    public HBox mes_concours;
    public HBox btnParam;
    public Pane pParam;
    public Pane btnNotif;
    public Pane btnAbo;

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
    public void actionGoParam() throws  IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("param.fxml"));

        Stage fenetre = (Stage) btnParam.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());

        fenetre.setScene(scene);
        fenetre.show();
    }

    @FXML
    public void actionGoUser() throws  IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("param.fxml"));

        Stage fenetre = (Stage) pParam.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());

        fenetre.setScene(scene);
        fenetre.show();
    }

    @FXML
    public void actionGoNotif() throws  IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("notif.fxml"));

        Stage fenetre = (Stage) btnNotif.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());

        fenetre.setScene(scene);
        fenetre.show();
    }

    @FXML
    public void actionGoAbo() throws  IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("abo.fxml"));

        Stage fenetre = (Stage) btnAbo.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());

        fenetre.setScene(scene);
        fenetre.show();
    }

    @FXML
    private Label username;
    @FXML
    private Label welcome;

    /*
    public void initialize() throws IOException {
        String username = Handler.getInstance().getUser().getUsername();
        this.username.setText(username);
        if (welcome != null) welcome.setText("Bienvenue, " + username);
        UpdateConcoursList.update(concours_content_wrapper);
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

    @FXML
    private TextField contest_name;
    @FXML
    private TextArea contest_desc;
    @FXML
    private ComboBox contest_cat;

    /** Création d'un concours */
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
        UpdateConcoursList.update(concours_content_wrapper);
    }




    // ---------------------- Participant  -----------------------------


    @FXML
    private TextField nomField;

    @FXML
    private TextField prenomField;

    @FXML
    private TextField ageField;

    @FXML
    private Button creerParticipantButton;

    //-----------------------------------
    @FXML
    private FlowPane root;

    @FXML
    private VBox leftbar;

    @FXML
    private Button addCuisinierButton;

    @FXML
    private VBox cuisiniersContainer; // Conteneur pour afficher les cuisiniers ajoutés


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

        // Ajouter le participant à la liste des cuisiniers du contrôleur principal
        addCuisinier(nom, prenom, age);

        // Fermer la fenêtre d'ajout de participant
        Stage stage = (Stage) nomField.getScene().getWindow();
        stage.close();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    //-----------------------------------------------
    @FXML
    private void openAddParticipantWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("participant.fxml"));



            Stage participant = new Stage();
            participant.initModality(Modality.APPLICATION_MODAL);
            participant.setTitle("Ajouter un Participant");
            participant.setScene(new Scene(loader.load()));
            participant.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void addCuisinier(String nom, String prenom, int age) {
        Label label = new Label(nom + " " + prenom + ", Âge: " + age);
        cuisiniersContainer.getChildren().add(label);
    }
}