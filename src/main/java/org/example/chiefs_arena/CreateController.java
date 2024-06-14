package org.example.chiefs_arena;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;


public class CreateController {
    @FXML
    private TextField nomField;
    @FXML
    private TextArea descriptionField;
    @FXML
    private ComboBox<String> categorieComboBox;
    @FXML
    private ComboBox<String> lieuComboBox;
    @FXML
    private TextField lieuSearchField;
    @FXML
    private ImageView mapImageView;

    @FXML
    private void initialize() {
        // Initialize combo boxes, load map image, etc.
    }

    @FXML
    private void handleAjouterCuisinier() {
        // Logic to add a cook
    }

    @FXML
    private void handleAjouterJury() {
        // Logic to add a jury member
    }

    @FXML
    private void handleAjouterSponsor() {
        // Logic to add a sponsor
    }
}
