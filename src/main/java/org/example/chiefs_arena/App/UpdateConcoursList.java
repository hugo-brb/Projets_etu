package org.example.chiefs_arena.App;

import javafx.fxml.FXMLLoader;
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

import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
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

	public static void addConcoursInMain(Concours concours, GridPane container) {
		try {
			FXMLLoader loader = new FXMLLoader(UpdateConcoursList.class.getResource("/org/example/chiefs_arena/mainConcours.fxml"));
			VBox box = loader.load();

			Label label_date = (Label) box.lookup("#mainDate");
			Label label_title = (Label) box.lookup("#mainTitle");
			Label label_desc = (Label) box.lookup("#mainDesc");

			Date creationDate = concours.getDateDebut();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
			label_date.setText(dateFormat.format(creationDate));

			label_title.setText(concours.getNom());

			String desc = concours.getDescription();
			if (desc.length() > 120) {
				desc = desc.substring(0, 120) + "...";
			}
			label_desc.setText(desc);

			GridPane.setConstraints(box, i_index, j_index);
			container.getChildren().add(box);
			i_index++;
			if (i_index > 2) {
				i_index = 0;
				j_index++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}