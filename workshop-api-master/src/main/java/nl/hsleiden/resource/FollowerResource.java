package nl.hsleiden.resource;

import com.fasterxml.jackson.annotation.JsonView;
import com.google.inject.Singleton;
import io.dropwizard.auth.Auth;
import nl.hsleiden.View;
import nl.hsleiden.model.Follower;
import nl.hsleiden.model.User;
import nl.hsleiden.service.FollowerService;
import nl.hsleiden.service.UserService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;


@Singleton
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class FollowerResource {


/**
 * Meer informatie over resources:
 *  https://jersey.java.net/documentation/latest/user-guide.html#jaxrs-resources
 *
 * @author Peter van Vliet
 */


    private final FollowerService service;

    @Inject
    public FollowerResource(FollowerService service)
    {
        this.service = service;
    }


    @GET
    @Path("/{totalFollower}")
    @JsonView(View.Public.class)
    @RolesAllowed("GUEST")
    public User getTotalFollowers(@PathParam("id") int id)
    {
        return service.get(id);
    }


    @GET
    @Path("/me")
    @JsonView(View.Private.class)
    public User authenticate(@Auth User authenticator)
    {
        return authenticator;
    }
}
