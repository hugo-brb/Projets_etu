package org.example.chiefs_arena.user;

public class User
{
	private String name;
	private String prenom;
	private String username;
	private String mail;
	private String password;
	private boolean computer_notif;
	private boolean mail_notif;
	private Abonnement abonnement;

	public User()
	{
	}

	public User(String name, String username, String mail, String password, boolean computer_notif, boolean mail_notif, Abonnement abonnement)
	{
		this.name = name;
		this.username = username;
		this.mail = mail;
		setPassword(password);
		this.computer_notif = computer_notif;
		this.mail_notif = mail_notif;
		this.abonnement = abonnement;
		Handler.write_data(Handler.user_file, Handler.gson.toJson(this));
	}

	public void save()
	{
		Handler.write_data(Handler.user_file, Handler.gson.toJson(this));
	}

	public String getName()
	{
		return name;
	}
	public String getPrenom() {return prenom;}

	public String getUsername()
	{
		return username;
	}

	public String getMail()
	{
		return mail;
	}

	public String getPassword()
	{
		return password;
	}

	public boolean isComputer_notif()
	{
		return computer_notif;
	}

	public boolean isMail_notif()
	{
		return mail_notif;
	}

	public Abonnement getAbonnement()
	{
		return abonnement;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}

	public void setMail(String mail)
	{
		this.mail = mail;
	}

	public void setPassword(String password)
	{
		this.password = Handler.sha3_256(password);
	}

	public void setComputer_notif(boolean computer_notif)
	{
		this.computer_notif = computer_notif;
	}

	public void setMail_notif(boolean mail_notif)
	{
		this.mail_notif = mail_notif;
	}

	public void setAbonnement(Abonnement abonnement)
	{
		this.abonnement = abonnement;
	}
}