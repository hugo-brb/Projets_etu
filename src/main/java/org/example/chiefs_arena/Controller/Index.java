package org.example.chiefs_arena.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.example.chiefs_arena.ChiefsArenaApplication;

import java.awt.event.MouseEvent;
import java.io.IOException;

public class Index
{
	@FXML
	private FlowPane root;

	@FXML
	public void initialize() throws IOException
	{
		VBox home = FXMLLoader.load(ChiefsArenaApplication.class.getResource("home-view.fxml"));
		FlowPane container_wrapper = (FlowPane) root.getChildren().get(1);
		Pane container = (Pane) container_wrapper.getChildren().get(0);
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