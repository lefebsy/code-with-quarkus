package org.acme;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.ricksbrown.cowsay.Cowsay;

@Path("/cowsay")
public class MyCow {

    /**
     * PATH /cowsay
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String cowsay() {
        // Use the little class next to this one
        return MakeCowSay.cowsay("Give a message to the cow !");
    }

    /**
     * PATH /cowsay/mon message
     */
    @GET
    @Path("{msg}")
    public String cowsay(@PathParam("msg") String txt) {
        // Use the little class next to this one
        return MakeCowSay.cowsay(txt);
    }

    /**
     * PATH /cowsay/otherCow
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("otherCow")
    public String otherCowsay() {
        // Use the external lib 'com.github.ricksbrown.cowsay.Cowsay'
        // Is ok when compiled in JVM but ko in native
        String[] args = new String[] { "-f", "cow",
                "Hoho ! \n\n I am an happy cow. Give me fresh grass please !" };
        return Cowsay.say(args);
    }

}
