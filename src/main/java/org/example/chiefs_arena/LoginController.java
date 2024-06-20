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

import java.awt.event.ActionEvent;
import java.io.IOException;

public class LoginController
{
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

	Label error = new Label("Nom d'utilisateur ou mot de passe incorrect");

	@FXML
	public void login(MouseEvent e) throws IOException
	{
		if (Handler.login(username.getText(), password.getText()))
		{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home-view.fxml"));
			Stage window = (Stage) username.getScene().getWindow();
			Scene scene = new Scene(fxmlLoader.load());
			window.setScene(scene);
			window.show();
		}
		else
		{
			error.setStyle("-fx-text-fill: #ef233c;");
			error_box.getChildren().remove(error);
			error_box.getChildren().add(error);
		}
	}

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

	Text error_message = new Text();

	@FXML
	public void register_next(MouseEvent e) throws IOException
	{
		error_message.setWrappingWidth(500);
		error_message.setStyle("-fx-fill: #ef233c");
		error_message.setTextAlignment(TextAlignment.CENTER);
		register_error_box.getChildren().removeAll(error_message);
		if (register_name.getText().isBlank())
		{
			error_message.setText("Vous devez entrer un nom");
			register_error_box.getChildren().add(error_message);
		}
		else if (register_prenom.getText().isBlank())
		{
			error_message.setText("Vous devez entrer un prénom");
			register_error_box.getChildren().add(error_message);
		}
		else if (register_username.getText().isBlank())
		{
			error_message.setText("Vous devez entrer un nom d'utilisateur");
			register_error_box.getChildren().add(error_message);
		}
		else if (register_mail.getText().isBlank())
		{
			error_message.setText("Vous devez entrer un mail");
			register_error_box.getChildren().add(error_message);
		}
		else if (!Handler.isPasswordValid(register_password_field.getText()))
		{
			error_message.setText("• Votre mot de passe doit contenir 8 caractère" +
					"\n • au moins une lettre miniscule et majuscule" +
					"\n • un chiffre" +
					"\n • un caractère spécial");
			register_error_box.getChildren().add(error_message);
		}
		else
		{
			User user = new User();
			user.setName(register_name.getText());
			user.setPrenom(register_prenom.getText());
			user.setUsername(register_username.getText());
			user.setMail(register_mail.getText());
			user.setPassword(register_password_field.getText());
			user.save();

			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home-view.fxml"));
			Stage window = (Stage) register_name.getScene().getWindow();
			Scene scene = new Scene(fxmlLoader.load());
			window.setScene(scene);
			window.show();
		}
	}

	public void goCreateAccount(javafx.event.ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register.fxml"));

		Stage fenetre = (Stage) btnGoAccount.getScene().getWindow();
		Scene scene = new Scene(fxmlLoader.load());

		fenetre.setScene(scene);
		fenetre.show();
	}

	public void goLogin(javafx.event.ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));

		Stage fenetre = (Stage) btnGoLogin.getScene().getWindow();
		Scene scene = new Scene(fxmlLoader.load());

		fenetre.setScene(scene);
		fenetre.show();
	}
}