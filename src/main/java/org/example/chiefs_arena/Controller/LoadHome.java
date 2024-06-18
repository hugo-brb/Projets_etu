package org.example.chiefs_arena.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class LoadHome
{
	@FXML
	FlowPane root;

	@FXML
	public void initialize() throws IOException
	{
		VBox home = FXMLLoader.load(getClass().getResource("home-view.fxml"));
		root.getChildren().add(home);
	}
}