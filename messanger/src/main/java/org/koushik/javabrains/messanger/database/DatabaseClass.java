package org.koushik.javabrains.messanger.database;

import java.util.HashMap;
import java.util.Map;

import org.koushik.javabrains.messanger.model.Message;
import org.koushik.javabrains.messanger.model.Profile;

public class DatabaseClass {

	private static Map<Long, Message> messages = new HashMap<>();  
	private static Map<Long, Profile> profiles = new HashMap<>();

	
	public static Map<Long, Message> getMessages()
	{
		return messages;
	}
	
	public static Map<Long, Profile> getProfile()
	{
		return profiles;
	}
}
