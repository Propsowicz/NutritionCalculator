package Presentation.Controllers;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/hi")
public class hello {

    @GET
    public String sayHi() {
        return "Hi!";
    }
}
