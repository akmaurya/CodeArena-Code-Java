package org.koushik.javabrains.messanger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.koushik.javabrains.messanger.model.Message;
import org.koushik.javabrains.messanger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService messageService = new MessageService();
	@GET
	public List<Message> getMessages() {
		return messageService.getAllMessages(); 
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long id)
	{
		return messageService.getMessage(id);
	}
	
	@POST
	public Message addMessage(Message message){
		return messageService.addMessage(message);
	}
	
	
	@PUT
	@Path("/{messageId}")
	public void updateMessage(@PathParam("messageId") long id, Message message){
		message.setId(id);
		messageService.addMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public Message removeMessage(@PathParam("messageId") long id){
		return messageService.removeMessage(id);
	}
}
