package org.example.chiefs_arena.App;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.example.chiefs_arena.user.ConcoursList;
import org.example.chiefs_arena.user.Handler;

import java.util.Arrays;

public class UpdateConcoursList
{
	public static void update(VBox container)
	{
		ConcoursList concours = Handler.getInstance().getAllConcours();
		container.getChildren().clear();
		if (concours == null || concours.getConcours().isEmpty())
		{
			container.setSpacing(8d);
			Text no_concours = new Text("Aucun concours");
			Text create = new Text("Commencez à en créer avec Chef's Arena !");
			Arrays.asList(no_concours, create).forEach(text -> {
				text.setWrappingWidth(190);
				text.getStyleClass().add("text");
				container.getChildren().add(text);
			});
		}
		else
		{
			concours.getConcours().forEach(c -> {
				Label label = new Label(c.getNom());
				label.getStyleClass().add("text");
				container.getChildren().add(label);
			});
		}
	}
}