package dk.thrysoee;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/api/hello")
@Singleton
public class HelloResource {

    private final Greeter greeter;

    @Inject
    public HelloResource(final Greeter greeter) {
        this.greeter = greeter;
    }

    @GET
    @Path("{name}")
    public String hello(@PathParam("name") final String name) {
        return greeter.greet(name);
    }
}
