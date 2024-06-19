package org.example.chiefs_arena.user;

import org.example.chiefs_arena.App.Concours;

import java.util.List;

public class ConcoursList
{
	private List<Concours> concours;

	public ConcoursList()
	{
	}

	public ConcoursList(List<Concours> concours)
	{
		this.concours = concours;
	}

	public void addConcours(Concours concours)
	{
		this.concours.add(concours);
	}

	public List<Concours> getConcours() {
		return concours;
	}

	public void setConcours(List<Concours> concours) {
		this.concours = concours;
	}

	public void save()
	{
		Handler.write_data(Handler.concours_file, Handler.gson.toJson(this));
	}
}