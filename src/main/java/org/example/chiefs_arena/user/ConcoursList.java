package org.example.chiefs_arena.user;

import javafx.scene.control.Alert;
import org.example.chiefs_arena.App.Concours;
import org.example.chiefs_arena.exception.ConcoursDejaExistant;

import java.util.ArrayList;
import java.util.List;

public class ConcoursList
{
	private List<Concours> concours = new ArrayList<>();

	public ConcoursList()
	{
	}

	public ConcoursList(List<Concours> concours)
	{
		setConcours(concours);
	}

	public void addConcours(Concours concours) throws ConcoursDejaExistant
	{
		if (this.concours.stream().anyMatch(c -> c.getNom().equalsIgnoreCase(concours.getNom())))
		{
			showAlert("Erreur", "Vous ne pouvez pas ajouter deux concours ayant le même nom");
			throw new ConcoursDejaExistant();
		}

		this.concours.add(concours);
	}

	public List<Concours> getConcours() {
		return concours;
	}

	public void setConcours(List<Concours> concours) {
		concours.stream().forEach(c -> {
			if (concours.stream().anyMatch(c2 -> c.getNom().equalsIgnoreCase(c2.getNom()))) try
			{
				showAlert("Erreur", "Vous ne pouvez pas ajouter deux concours ayant le même nom");
				throw new ConcoursDejaExistant();
			}
			catch (ConcoursDejaExistant e)
			{
				throw new RuntimeException(e);
			}
		});

		this.concours = concours;
	}

	public void save()
	{
		Handler.write_data(Handler.concours_file, Handler.gson.toJson(this));
	}

	private void showAlert(String title, String message) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}
}