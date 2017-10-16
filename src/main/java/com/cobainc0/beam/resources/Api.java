package com.cobainc0.beam.resources;

import com.cobainc0.beam.dto.Response;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("api")
public class Api {

    public Api(){
    }

    @Path("/stringResponse")
    @Produces(MediaType.TEXT_PLAIN)
    @GET
    public String saySomething(){
        return "Sshh";
    }

    @Path("jsonResponse")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getPassingResponse() {
        return new Response("pass");
    }
}
