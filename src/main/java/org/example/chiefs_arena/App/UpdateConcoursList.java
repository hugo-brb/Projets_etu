package org.example.chiefs_arena.App;

import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.example.chiefs_arena.user.ConcoursList;

import java.util.Arrays;

public class UpdateConcoursList
{
	public static void update(ConcoursList concours, VBox container, GridPane main)
	{
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
			if (main != null)
			{
				main.getChildren().clear();
				concours.getConcours().forEach(c -> {
					addConcoursInMain(c, main);
					Label label = new Label(c.getNom());
					label.getStyleClass().add("text");
					container.getChildren().add(label);
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

	private static final ImageView calendar = new ImageView();

	private static final HBox footer = new HBox();
	static
	{
		footer.getChildren().addAll(
			new ImageView(),
			new ImageView(),
			new ImageView()
		);
	}

	private static int concours_index = 0;

	public static void addConcoursInMain(Concours concours, GridPane container)
	{
		HBox header = new HBox();
		HBox left = new HBox();

		Label date = new Label(concours.getDateDebut().toString());
		left.getChildren().addAll(calendar, date);

		String category_name = (concours.getCategories().isEmpty() ? null : concours.getCategories().get(0).getNom());
		Label category = new Label();
		header.getChildren().addAll(left, category);

		String desc = concours.getDescription();
		if (desc.length() > 100) desc = desc.substring(0, 100) + "...";
		Text text_desc = new Text(concours.getDescription());
		text_desc.getStyleClass().add("text");
		text_desc.setWrappingWidth(234);

		Separator ligner = new Separator();

		VBox box = new VBox();
		box.setStyle("-fx-background-radius: 10; -fx-background-color: white;");
		box.getChildren().addAll(header, text_desc, ligner, footer);

		container.getChildren().add(box);
		concours_index++;
		System.out.println(concours_index);
	}
}