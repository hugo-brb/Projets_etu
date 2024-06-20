package org.example.chiefs_arena;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.chiefs_arena.App.*;
import org.example.chiefs_arena.exception.DescriptionTropLongue;
import org.example.chiefs_arena.user.ConcoursList;
import org.example.chiefs_arena.user.Handler;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

public class AppController {
    @FXML
    private HBox btnCreate, btnHome, mes_concours, btnParam;
    @FXML
    private Pane pParam, btnNotif, btnAbo;
    @FXML
    private VBox concours_content_wrapper;
    @FXML
    private TextField contest_name;
    @FXML
    private Label username, welcome;
    @FXML
    private GridPane concours_info_list;
    @FXML
    private TextArea contest_desc;
    @FXML
    private MenuButton contest_cat;

    @FXML
    private Label paramUsername;
    @FXML
    private Label paramNom;
    @FXML
    private TextField paramMail;
    @FXML
    private PasswordField paramMdp;

    @FXML
    private TextField nomField, prenomField, ageField, nomJury, prenomJury, ageJury, idSponso, nomSponso, contributionSponso, contrainteSponso;
    @FXML
    private VBox cuisiniersContainer, juryContainer, sponsorContainner;
    @FXML
    private Button creerParticipantButton, creerJuryButton, creerSponsorButton;
    @FXML
    private FlowPane root;
    @FXML
    private VBox leftbar;
    @FXML
    private Button addCuisinierButton;

    @FXML
    private Label mainTitle;
    @FXML
    private Label mainDesc;
    @FXML
    private Label mainDate;

    @FXML
    public void actionCreateEvent(MouseEvent event) throws IOException {
        changeScene("create-view.fxml", concours_content_wrapper);
    }

    @FXML
    public void actionGoHome(MouseEvent event) throws IOException {
        changeScene("home-view.fxml", btnHome);
    }

    @FXML
    public void actionGoMyConcours(MouseEvent event) throws IOException {
        changeScene("concours-view.fxml", mes_concours);
    }

    @FXML
    public void actionGoAnalyse() throws IOException {
        changeScene("analyse-view.fxml", concours_content_wrapper);
    }

    @FXML
    public void actionGoParam() throws IOException {
        changeScene("param.fxml", btnParam);
    }

    @FXML
    public void actionGoUser() throws IOException {
        changeScene("param.fxml", pParam);
    }

    @FXML
    public void actionGoNotif() throws IOException {
        changeScene("notif.fxml", btnNotif);
    }

    @FXML
    public void actionGoAbo() throws IOException {
        changeScene("abo.fxml", btnAbo);
    }

    @FXML
    public void initialize() throws IOException {
        String userName = Handler.getInstance().getUser().getPrenom();
        ConcoursList concours = Handler.getInstance().getAllConcours();

        if (username != null) username.setText(userName);
        if (welcome != null) welcome.setText("Bienvenue, " + userName);
        if (concours_content_wrapper != null) {
            UpdateConcoursList.update(concours, concours_content_wrapper, concours_info_list);
        }

        initParam();
    }

    @FXML
    public void initParam(){
        if (paramUsername != null) paramUsername.setText(Handler.getInstance().getUser().getUsername());
        if (paramNom != null) paramNom.setText(STR."\{Handler.getInstance().getUser().getName().toUpperCase()} \{Handler.getInstance().getUser().getPrenom()}");
        if (paramMail != null) paramMail.setText(Handler.getInstance().getUser().getMail());
        if (paramMdp != null) paramMdp.setText(Handler.getInstance().getUser().getPassword());
    }

    @FXML
    public void search_concours(KeyEvent event) {
        String searchTerm = ((TextField) event.getSource()).getText();
        Handler.getInstance().getAllConcours().getConcours().stream()
                .filter(c -> c.getNom().equalsIgnoreCase(searchTerm))
                .forEach(c -> System.out.println("Concours trouvé : " + c.getNom()));
    }

    @FXML
    public void create(ActionEvent e) throws DescriptionTropLongue, IOException {
        if (contest_name.getText().isBlank() || contest_desc.getText().isBlank() || contest_desc.getText().length() > 1000) {
            return;
        }

        Concours concours = new Concours(
                contest_name.getText(),
                contest_desc.getText(),
                new Date(System.currentTimeMillis()),
                new Date(System.currentTimeMillis()),
                new Lieu("lieu-1", 100),
                Arrays.asList(new Categorie("nom", Arrays.asList("sous-categorie"))),
                Arrays.asList(new Partenaire("id", "nom", 999999999, "contraintes")),
                Arrays.asList(new Personne(1, "nom", "prenom", 94, "role")),
                new Classement()
        );

        ConcoursList allConcours = Handler.getInstance().getAllConcours();
        if (allConcours == null) {
            allConcours = new ConcoursList();
        }
        allConcours.addConcours(concours);
        UpdateConcoursList.update(allConcours, concours_content_wrapper, concours_info_list);
        allConcours.save();
        changeScene("home-view.fxml", btnHome);
    }

    @FXML
    private void creerParticipant() {
        try {
            String nom = nomField.getText();
            String prenom = prenomField.getText();
            int age = Integer.parseInt(ageField.getText());

            Participant participant = new Participant(1, nom, prenom, age, Participant.class.getSimpleName());
            showAlert("Succès", "Participant créé : " + participant.getNom() + " " + participant.getPrenom() + ", Âge: " + participant.getAge());

            addCuisinier(nom, prenom, age);
            Stage s = (Stage) nomField.getScene().getWindow();
            s.close();
        } catch (NumberFormatException e) {
            showAlert("Erreur de saisie", "Veuillez entrer un âge valide.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void openAddParticipantWindow() {
        openModalWindow("participant.fxml", "Ajouter un Participant");
    }

    @FXML
    public void addCuisinier(String nom, String prenom, int age) {
        cuisiniersContainer.getChildren().add(new Label(nom + " " + prenom + ", Âge: " + age));
    }

    @FXML
    private void creerJury() {
        try {
            String nom = nomJury.getText();
            String prenom = prenomJury.getText();
            int age = Integer.parseInt(ageJury.getText());

            Jury jury = new Jury(1, nom, prenom, age, Jury.class.getSimpleName());
            showAlert("Succès", "Jury créé : " + jury.getNom() + " " + jury.getPrenom() + ", Âge: " + jury.getAge());

            addJury(nom, prenom, age);
            closeWindow(nomJury);
        } catch (NumberFormatException e) {
            showAlert("Erreur de saisie", "Veuillez entrer un âge valide.");
        }
    }

    @FXML
    private void openAddJuryWindow() {
        openModalWindow("jury.fxml", "Ajouter un Jury");
    }

    @FXML
    public void addJury(String nom, String prenom, int age) {
        juryContainer.getChildren().add(new Label(nom + " " + prenom + ", Âge: " + age));
    }

    @FXML
    private void creerSponsor() {
        try {
            String id = idSponso.getText();
            String nom = nomSponso.getText();
            int contribution = Integer.parseInt(contributionSponso.getText());
            String contrainte = contrainteSponso.getText();

            Partenaire partenaire = new Partenaire(id, nom, contribution, contrainte);
            showAlert("Succès", "Sponsor créé : " + partenaire.getNom() + ", contribution: " + partenaire.getContribution() + ", contrainte: " + partenaire.getContraintes());

            addSponsor(nom, contribution, contrainte);
            closeWindow(idSponso);
        } catch (NumberFormatException e) {
            showAlert("Erreur de saisie", "Veuillez entrer une contribution valide.");
        }
    }

    @FXML
    private void openAddSponsorWindow() {
        openModalWindow("sponsor.fxml", "Ajouter un Sponsor");
    }

    @FXML
    public void addSponsor(String nom, int contribution, String contrainte) {
        sponsorContainner.getChildren().add(new Label(nom + ", contribution: " + contribution + ", Contrainte: " + contrainte));
    }

    private void changeScene(String fxml, Node sourceNode) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
        Stage stage = (Stage) sourceNode.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    private void openModalWindow(String fxml, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle(title);
            window.setScene(new Scene(loader.load()));
            window.showAndWait();
            Image icon = new Image(getClass().getResourceAsStream("/org/example/chiefs_arena/img/icone.png"));
            window.getIcons().add(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeWindow(TextField field) {
        Stage stage = (Stage) field.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handleMenuItemClick(ActionEvent event) {
        MenuItem clickedItem = (MenuItem) event.getSource();
        contest_cat.setText(clickedItem.getText());
    }
}
