package org.koushik.javabrains.messanger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/employee")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_JSON)
public class Employee {

	@GET
	@Path("/hello{<id>}")
	public Response getMessage()
	{
		String employee = "["
							+ "{"
								+ "\"id\": 1,"
								+ "\"name\": \"Arvind\","
								+ "\"gender\": \"Male\","
								+ "\"salary\": \"22k\""
							+ "},"
							+ "{"
								+ "\"id\": 2,"
								+ "\"name\": \"Sanjay\","
								+ "\"gender\": \"Male\","
								+ "\"salary\": \"60k\""
							+ "},"
							+ "{"
								+ "\"id\": 3,"
								+ "\"name\": \"Pooja\","
								+ "\"gender\": \"Female\","
								+ "\"salary\": \"60k\""
							+ "},"
							+ "{"
								+ "\"id\": 4,"
								+ "\"name\": \"Pragati\","
								+ "\"gender\": \"Female\","
								+ "\"salary\": \"22k\""
							+ "},"
							+ "{"
								+ "\"id\": 5,"
								+ "\"name\": \"Alok\","
								+ "\"gender\": \"Male\","
								+ "\"salary\": \"30k\""
							+ "},"
							+ "{"
								+ "\"id\": 6,"
								+ "\"name\": \"Harvansh\","
								+ "\"gender\": \"Male\","
								+ "\"salary\": \"12k\""
							+ "},"
							+ "{"
								+ "\"id\": 7,"
								+ "\"name\": \"Pramod\","
								+ "\"gender\": \"Male\","
								+ "\"salary\": \"98k\""
							+ "}"
						+ "]";
		return Response.status(201).header("Access-Control-Allow-Origin", "*").entity(employee).build();
	}
	
	/*MessageService messageService = new MessageService();
	@GET
	public List<Message> getMessages() {
		return messageService.getAllMessages(); 
	}*/
}