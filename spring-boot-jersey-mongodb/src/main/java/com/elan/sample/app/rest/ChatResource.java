package com.elan.sample.app.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;

import com.elan.sample.app.api.ChatMessage;
import com.elan.sample.app.api.MessageFilterTypeEnum;
import com.elan.sample.app.rest.context.GetMessagesRequestContext;
import com.elan.sample.app.rest.handler.ResponseHandler;
import com.elan.sample.app.service.MessageService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/chat/v1")
@Component
public class ChatResource {

	private static final String FILTER_BY = "filterBy";

	@Autowired
	private MessageService messageService;

	@Autowired
	private ResponseHandler responseHandler;

	Logger log = LoggerFactory.getLogger(ChatResource.class);

	/**
	 * Sends message from one user to another
	 * 
	 * @param chatMessage
	 *            Payload containing information about the message
	 * @param asyncResponse
	 *            Jersey injected Async response
	 */
	@Path("/send-message")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void sendChat(@RequestBody ChatMessage chatMessage, @Suspended AsyncResponse asyncResponse) {
		try {
			messageService.saveMessage(chatMessage);
		} catch (Exception e) {
			log.error("Issue sending message from {} to {}", chatMessage.getSenderUserId(),
			        chatMessage.getReceiverUserId(), e);
			asyncResponse.resume(Response.serverError().build());
		}
		asyncResponse.resume(Response.accepted());
	}

	@GET
	@Path("/users/{userId}/messages")
	@Produces(MediaType.APPLICATION_JSON)
	public void getMessagesForUser(@PathParam("userId") String userId, @QueryParam(FILTER_BY) String messageFilter,
	        @Suspended AsyncResponse response) {
		try {
			GetMessagesRequestContext requestContext = buildMessagesRequestContext(userId, messageFilter);
			messageService.getMessages(requestContext, response);
		} catch (Exception e) {
			log.error("Issue fetcing messages for userId {}", userId, e);
			responseHandler.handleException(e, response);
		}

	}

	private GetMessagesRequestContext buildMessagesRequestContext(String userId, String messageFilter) {
		GetMessagesRequestContext requestContext = new GetMessagesRequestContext();
		requestContext.setUserId(userId);
		
		MessageFilterTypeEnum messageFilterTypeEnum = null;
		
		if (StringUtils.isEmpty(messageFilter)) {
			messageFilterTypeEnum = MessageFilterTypeEnum.ALL;
		} else {
			messageFilterTypeEnum = MessageFilterTypeEnum.getFilterTypeFromString(messageFilter);
		}
		requestContext.setFilterType(messageFilterTypeEnum);
		return requestContext;
	}

	@GET
	@Path("/test")
	public String test() {
		return "hi";
	}
	

}
