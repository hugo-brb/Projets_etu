package org.example.chiefs_arena;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import org.example.chiefs_arena.user.Abonnement;
import org.example.chiefs_arena.user.Handler;
import org.example.chiefs_arena.user.User;

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
	public void login() throws IOException
	{
		if (Handler.login(username.getText(), password.getText()))
		{
			((Stage) username.getScene().getWindow()).setScene(FXMLLoader.load(getClass().getResource("home-view.fxml")));
		}
	}

	@FXML
	private PasswordField register_password_field;
	@FXML
	private HBox register_error_box;

	@FXML
	private TextField register_name;
	@FXML
	private TextField register_username;

	@FXML
	private VBox register_page;
	@FXML
	private VBox register2_page;

	Text error_message = new Text();

	private User user = new User();

	@FXML
	public void register_next() throws IOException
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
		else if (register_username.getText().isBlank())
		{
			error_message.setText("Vous devez entrer un nom d'utilisateur");
			register_error_box.getChildren().add(error_message);
		}
		else if (!Handler.isPasswordValid(register_password_field.getText()))
		{
			error_message.setText("• Votre mot de passe doit contenir 8 caractère\n • au moins une lettre miniscule et majuscule\n • un chiffre\n • un caractère spécial");
			register_error_box.getChildren().add(error_message);
		}
		else
		{
			user.setName(register_name.getText());
			user.setUsername(register_username.getText());
			//ajouter le champ mail
			user.setMail("chiefs_arena@gmail.com");
			user.setPassword(register_password_field.getText());
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register2.fxml"));
			Stage window = (Stage) register_name.getScene().getWindow();
			Scene scene = new Scene(fxmlLoader.load());
			window.setScene(scene);
			window.show();
		}
	}


	@FXML
	private CheckBox notif_pc;
	@FXML
	private CheckBox notif_mail;

	@FXML
	public void register_account() throws IOException
	{
		user.setComputer_notif(notif_pc.isSelected());
		user.setMail_notif(notif_mail.isSelected());
		user.setAbonnement(Abonnement.STANDARD);
		user.save();


		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home-view.fxml"));
		Stage window = (Stage) notif_mail.getScene().getWindow();
		Scene scene = new Scene(fxmlLoader.load());
		window.setScene(scene);
		window.show();
	}
}