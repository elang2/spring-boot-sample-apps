package com.elan.sample.app.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.elan.sample.app.api.ChatMessage;
import com.elan.sample.app.service.MessageService;

@Path("/chat/v1")
@Component
public class ChatResource {

	@Autowired
	private MessageService messageService;

	Logger log = LoggerFactory.getLogger(ChatResource.class);

	
	/**
	 * Sends message from one user to another
	 * 
	 * @param chatMessage Payload containing information about the message
	 * @param asyncResponse Jersey injected Async response
	 */
	@Path("/send-message")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void sendChat(@RequestBody ChatMessage chatMessage, @Suspended AsyncResponse asyncResponse) {
		try {
			messageService.saveMessage(chatMessage);
		} catch (Exception e) {
			log.error("Issue sending message from {} to {}", chatMessage.getSenderEmailId(),
			        chatMessage.getReceiverEmailId(), e);
			asyncResponse.resume(Response.serverError().build());
		}
		asyncResponse.resume(Response.accepted());
	}
	
	
	@GET
	@Path("/test")
	public String test()
	{
		return "hi";
	}
	
	
}
