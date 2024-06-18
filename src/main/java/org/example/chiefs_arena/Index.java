package org.example.chiefs_arena;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.awt.event.MouseEvent;
import java.io.IOException;

public class Index
{
	@FXML
	private FlowPane root;

	@FXML
	public void initialize() throws IOException
	{
		VBox home = FXMLLoader.load(getClass().getResource("home-view.fxml"));
		FlowPane container = (FlowPane) root.getChildren().get(1);
		//container.setPadding(new Insets(5.0, 5.0, 5.0, 5.0));
		container.getChildren().add(home);
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
}