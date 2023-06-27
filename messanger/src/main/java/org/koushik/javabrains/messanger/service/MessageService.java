package org.koushik.javabrains.messanger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.koushik.javabrains.messanger.database.DatabaseClass;
import org.koushik.javabrains.messanger.model.Message;

public class MessageService {

	Map<Long, Message> messages = DatabaseClass.getMessages();
	
	
	public MessageService()
	{
		messages.put(1L, new Message(1, "HelloWorld-1", "Arvind"));
		messages.put(2L, new Message(2, "HelloWorld-2", "Sanjay"));
	}
	
	public List<Message> getAllMessages()
	{
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(long id)
	{
		return messages.get(id);
	}
	
	
	
	public Message addMessage(Message message)
	{
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message)
	{
		if(message.getId()<=0)
			return null;
		else
		{
			messages.put(message.getId(), message);
			return message;
		}
	}
	
	public Message removeMessage(long id)
	{
		return messages.remove(id);
	}
}
