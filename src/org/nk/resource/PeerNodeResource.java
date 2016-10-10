package org.nk.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.nk.model.PingResponse;

@Path("p2p")
public class PeerNodeResource {
	
	@GET
	@Path("ping")
	@Produces(MediaType.APPLICATION_JSON)	
	public PingResponse pingMethod(){
		PingResponse response = new PingResponse();
		response.setMessage("Request was successful");
		return response;
	}
}
