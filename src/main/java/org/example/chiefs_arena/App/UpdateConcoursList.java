package org.example.chiefs_arena.App;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import org.example.chiefs_arena.user.ConcoursList;

import java.sql.Time;
import java.util.Arrays;
import java.util.Date;

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

	private static final HBox footer = new HBox();
	static
	{
		footer.getChildren().addAll(
			new ImageView(new Image(UpdateConcoursList.class.getResourceAsStream("/org/example/chiefs_arena/img/share-08-stroke-rounded.png"))),
			new ImageView(new Image(UpdateConcoursList.class.getResourceAsStream("/org/example/chiefs_arena/img/favourite-stroke-rounded.png"))),
			new ImageView(new Image(UpdateConcoursList.class.getResourceAsStream("/org/example/chiefs_arena/img/more-vertical-stroke-rounded.png")))
		);
		footer.setAlignment(Pos.CENTER);
		footer.setSpacing(20);
	}

	private static int i_index = 0;
	private static int j_index = 0;

	public static void addConcoursInMain(Concours concours, GridPane container)
	{
		ImageView calendar = new ImageView(new Image(UpdateConcoursList.class.getResourceAsStream("/org/example/chiefs_arena/img/calendar-03-stroke-rounded.png")));
		HBox header = new HBox();
		HBox left = new HBox();

		Date date = concours.getDateDebut();
		Label label_date = new Label(date.getMonth() + " " + date.getDay() + ", " + date.getYear());
		left.getChildren().addAll(calendar, label_date);

		String category_name = (concours.getCategories().isEmpty() ? null : concours.getCategories().get(0).getNom());
		Label category = new Label();
		header.getChildren().addAll(left, category);

		String desc = concours.getDescription();
		if (desc.length() > 120) desc = desc.substring(0, 120) + "...";
		Text text_desc = new Text(desc);
		text_desc.getStyleClass().add("text");
		text_desc.setTextAlignment(TextAlignment.CENTER);
		text_desc.setWrappingWidth(220);

		Separator ligner = new Separator();

		VBox box = new VBox();
		box.setSpacing(15.0);
		VBox.setMargin(box, new Insets(10.0));
		box.setStyle("-fx-background-radius: 10; -fx-background-color: white; -fx-padding: 15px");
		box.getChildren().addAll(header, text_desc, ligner, footer);

		GridPane.setConstraints(box, i_index, j_index);
		container.getChildren().add(box);
		i_index++;
		if (i_index > 2)
		{
			i_index = 0;
			j_index++;
		}
	}
}