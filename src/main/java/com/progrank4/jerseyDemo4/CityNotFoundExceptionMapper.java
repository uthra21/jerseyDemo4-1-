package com.progrank4.jerseyDemo4;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import jakarta.json.Json;
import jakarta.json.JsonObject;

@Provider
public class CityNotFoundExceptionMapper implements ExceptionMapper<CityNotFoundException>{
	@Override
	public Response toResponse(CityNotFoundException exception) {
		JsonObject json = Json.createObjectBuilder()
				.add("error",exception.getMessage())
				.build();
		return Response.status(Response.Status.NOT_FOUND)
				.entity(json.toString())
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
}
