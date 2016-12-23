package com.elan.sample.app.rest.handler;

import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.stereotype.Service;

@Service
public class ResponseHandler {

	public void handleSuccessResponse(Object data, AsyncResponse asyncResponse) {
		asyncResponse.resume(Response.ok(data).build());
	}

	public void handleException(Throwable e, AsyncResponse asyncResponse) {
		if (e instanceof IllegalArgumentException) {
			asyncResponse.resume(Response.status(Status.BAD_REQUEST).build());
		} else {
			asyncResponse.resume(Response.serverError().build());
		}
	}

}
