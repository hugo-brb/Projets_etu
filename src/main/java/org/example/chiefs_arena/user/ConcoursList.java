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

	public List<Concours> getConcours() {
		return concours;
	}

	public void setConcours(List<Concours> concours) {
		this.concours = concours;
	}
}