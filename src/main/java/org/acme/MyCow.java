package org.acme;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.github.ricksbrown.cowsay.Cowsay;



@Path("/cowsay")
public class MyCow {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String cowsay() {
        String[] args = new String[]{"-f", "daemon", "Hoho ! \n\n Give a './message' to the cow please ! \n\n Thank you"};
        return Cowsay.say(args);
    }

    @GET
    @Path("{msg}")
    public String loginPath(@PathParam("msg") String txt) {
             String[] args = new String[]{"-f", "cow", txt};
       return Cowsay.say(args);
    }

    
}
