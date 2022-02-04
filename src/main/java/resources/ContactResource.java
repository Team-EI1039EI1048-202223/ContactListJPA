package resources;

import data.Contact;
import services.ContactDAOJPA;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;

@Path("/contacts")
public class
ContactResource {
    @Inject
    ContactDAOJPA dao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getData() {
        return Response.ok(dao.getContacts()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/retrieve/{nif}")
    public Response getContact(@PathParam("nif") final String nif) {
        if (dao.retrieve(nif) == Contact.NOT_FOUND) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(dao.retrieve(nif)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/create")
    public Response createContact(Contact contact) throws URISyntaxException {
        Contact response = dao.create(contact);
        if(response == Contact.NOT_FOUND) return Response.status(Response.Status.CONFLICT).build();
        URI uri = new URI("/contacts/" + contact.getNIF());
        return Response.created(uri).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/update")
    public Response updateContact(final Contact contact) {
        Contact result = dao.update(contact);
        if(result == Contact.NOT_FOUND) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.noContent().build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete/{nif}")
    public Response deleteContact(@PathParam("nif") final String nif) {
        Contact result = dao.delete(nif);
        if(result == Contact.NOT_FOUND) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.noContent().build();
    }
}