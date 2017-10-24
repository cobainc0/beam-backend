package com.cobainc0.beam.resources;

import com.cobainc0.beam.core.User;
import com.cobainc0.beam.dto.Response;
import io.dropwizard.auth.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("api")
public class BeamResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(BeamResource.class);

    @Path("stringResponse")
    @Produces(MediaType.TEXT_PLAIN)
    @GET
    public String saySomething() {
        String s = "Sshh";
        BeamResource.LOGGER.info(s);
        return s;
    }

    @Path("jsonResponse")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getPassingResponse() {
        String r = "pass";
        BeamResource.LOGGER.info(r);
        return new Response(r);
    }

    @Path("secured") //sub resource meth
    @Produces(MediaType.TEXT_PLAIN)
    @GET
    //prompt user for password
    public String getSecureGreeting(@Auth User user){
        return "Hello secured world";
    }
}
