package org.example.chiefs_arena;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import org.example.chiefs_arena.user.Handler;
import org.example.chiefs_arena.user.User;

import java.io.IOException;

/**
 * Contrôleur pour la gestion de la connexion et de l'inscription des utilisateurs.
 */
public class LoginController {

	@FXML
	private VBox login;
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private HBox error_box;
	@FXML
	private Button btnGoAccount;
	@FXML
	private Button btnGoLogin;

	@FXML
	private PasswordField register_password_field;
	@FXML
	private HBox register_error_box;
	@FXML
	private TextField register_name;
	@FXML
	private TextField register_prenom;
	@FXML
	private TextField register_mail;
	@FXML
	private TextField register_username;
	@FXML
	private VBox register_page;
	@FXML
	private VBox register2_page;

	private Label error = new Label("Nom d'utilisateur ou mot de passe incorrect");
	private Text error_message = new Text();

	/**
	 * Méthode appelée lors de la tentative de connexion.
	 *
	 * @param e l'événement de la souris
	 * @throws IOException si le fichier FXML de la scène suivante n'est pas trouvé
	 */
	@FXML
	public void login(MouseEvent e) throws IOException {
		if (Handler.login(username.getText(), password.getText())) {
			navigateToScene("home-view.fxml", username);
		} else {
			displayError(error_box, error, "Nom d'utilisateur ou mot de passe incorrect", "-fx-text-fill: #ef233c;");
		}
	}

	/**
	 * Méthode appelée pour passer à l'étape suivante de l'inscription.
	 *
	 * @param e l'événement de la souris
	 * @throws IOException si le fichier FXML de la scène suivante n'est pas trouvé
	 */
	@FXML
	public void register_next(MouseEvent e) throws IOException {
		error_message.setWrappingWidth(500);
		error_message.setStyle("-fx-fill: #ef233c");
		error_message.setTextAlignment(TextAlignment.CENTER);
		register_error_box.getChildren().removeAll(error_message);

		if (validateRegistrationFields()) {
			createUser();
			navigateToScene("home-view.fxml", register_name);
		}
	}

	/**
	 * Méthode appelée pour aller à la scène de création de compte.
	 *
	 * @param event l'événement d'action
	 * @throws IOException si le fichier FXML de la scène suivante n'est pas trouvé
	 */
	public void goCreateAccount(javafx.event.ActionEvent event) throws IOException {
		navigateToScene("register.fxml", btnGoAccount);
	}

	/**
	 * Méthode appelée pour aller à la scène de connexion.
	 *
	 * @param event l'événement d'action
	 * @throws IOException si le fichier FXML de la scène suivante n'est pas trouvé
	 */
	public void goLogin(javafx.event.ActionEvent event) throws IOException {
		navigateToScene("login.fxml", btnGoLogin);
	}

	/**
	 * Valide les champs d'inscription.
	 *
	 * @return vrai si tous les champs sont valides, faux sinon
	 */
	private boolean validateRegistrationFields() {
		if (register_name.getText().isBlank()) {
			displayError(register_error_box, error_message, "Vous devez entrer un nom", null);
		} else if (register_prenom.getText().isBlank()) {
			displayError(register_error_box, error_message, "Vous devez entrer un prénom", null);
		} else if (register_username.getText().isBlank()) {
			displayError(register_error_box, error_message, "Vous devez entrer un nom d'utilisateur", null);
		} else if (register_mail.getText().isBlank()) {
			displayError(register_error_box, error_message, "Vous devez entrer un mail", null);
		} else if (!Handler.isPasswordValid(register_password_field.getText())) {
			displayError(register_error_box, error_message,
					"• Votre mot de passe doit contenir 8 caractères" +
							"\n• au moins une lettre minuscule et majuscule" +
							"\n• un chiffre" +
							"\n• un caractère spécial", null);
		} else {
			return true;
		}
		return false;
	}

	/**
	 * Crée un nouvel utilisateur et enregistre les informations.
	 */
	private void createUser() {
		User user = new User();
		user.setName(register_name.getText());
		user.setPrenom(register_prenom.getText());
		user.setUsername(register_username.getText());
		user.setMail(register_mail.getText());
		user.setPassword(register_password_field.getText());
		user.save();
	}

	/**
	 * Affiche un message d'erreur dans une boîte de dialogue.
	 *
	 * @param errorBox la boîte de dialogue d'erreur
	 * @param errorLabel le label de l'erreur
	 * @param message le message de l'erreur
	 * @param style le style à appliquer au message
	 */
	private void displayError(HBox errorBox, Label errorLabel, String message, String style) {
		if (style != null) {
			errorLabel.setStyle(style);
		}
		errorLabel.setText(message);
		if (!errorBox.getChildren().contains(errorLabel)) {
			errorBox.getChildren().add(errorLabel);
		}
	}

	/**
	 * Affiche un message d'erreur dans une boîte de dialogue.
	 *
	 * @param errorBox la boîte de dialogue d'erreur
	 * @param errorText le texte de l'erreur
	 * @param message le message de l'erreur
	 * @param style le style à appliquer au message
	 */
	private void displayError(HBox errorBox, Text errorText, String message, String style) {
		if (style != null) {
			errorText.setStyle(style);
		}
		errorText.setText(message);
		if (!errorBox.getChildren().contains(errorText)) {
			errorBox.getChildren().add(errorText);
		}
	}

	/**
	 * Change la scène de l'application.
	 *
	 * @param fxml le fichier FXML de la nouvelle scène
	 * @param sourceNode le nœud source
	 * @throws IOException si le fichier FXML de la scène suivante n'est pas trouvé
	 */
	private void navigateToScene(String fxml, javafx.scene.Node sourceNode) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
		Stage window = (Stage) sourceNode.getScene().getWindow();
		Scene scene = new Scene(fxmlLoader.load());
		window.setScene(scene);
		window.show();
	}
}
