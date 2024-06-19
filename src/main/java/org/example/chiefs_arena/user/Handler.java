package org.example.chiefs_arena.user;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.chiefs_arena.App.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Pattern;

public class Handler
{
	public static Gson gson = new Gson();
	public static final String user_file = "../data/users.json";
	public static final String concours_file = "../data/concours.json";

	public static boolean login(String username, String password)
	{
		User user = gson.fromJson(String.valueOf(fetch_data(user_file)), User.class);
		return user.getUsername() != null && user.getUsername().equals(username) && user.getPassword() != null && user.getPassword().equals(sha3_256(password));
	}

	public static boolean isPasswordValid(String password)
	{
		return Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!#?@])[A-Za-z\\d!#?@]{8,}$", password);
	}

	public static String fetch_data(String file)
	{
		StringBuilder json = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new FileReader(file)))
		{
			String line;
			while ((line = reader.readLine()) != null)
			{
				json.append(line);
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException("Erreur de lecture sur " + file, e);
		}
		return String.valueOf(json);
	}

	public static void write_data(String file, String content)
	{
		try
		{
			File newFile = new File(file);
			newFile.createNewFile();

			try (FileWriter writer = new FileWriter(file))
			{
				writer.write(content);
			}
		}
		catch (IOException e) { e.printStackTrace(); }
	}

	public static String sha3_256(String password)
	{
		try
		{
			MessageDigest digest = MessageDigest.getInstance("SHA3-256");
			byte[] hashBytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));
			StringBuilder hexString = new StringBuilder(2 * hashBytes.length);
			for (byte b : hashBytes)
			{
				String hex = Integer.toHexString(0xff & b);
				if (hex.length() == 1)
				{
					hexString.append('0');
				}
				hexString.append(hex);
			}
			return hexString.toString();
		}
		catch (NoSuchAlgorithmException e)
		{
			throw new RuntimeException("SHA3-256 algorithm not available", e);
		}
	}
}