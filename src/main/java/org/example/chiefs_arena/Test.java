package org.example.chiefs_arena;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class Test
{
	@FXML
	private FlowPane root;

	@FXML
	public void initialize() throws IOException
	{
		VBox leftbar = FXMLLoader.load(getClass().getResource("components/leftbar.fxml"));
		VBox home = FXMLLoader.load(getClass().getResource("home-view.fxml"));
		root.getChildren().addAll(leftbar, home);
		//root.getChildren().add(home);
	}
}