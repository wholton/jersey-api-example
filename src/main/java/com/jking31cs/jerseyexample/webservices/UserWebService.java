package com.jking31cs.jerseyexample.webservices;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.jking31cs.jerseyexample.objects.User;
import com.jking31cs.jerseyexample.stores.UserStore;
import java.util.List;

@Path("api/users")
public class UserWebService {
	private final UserStore store;
	@Inject 
	public UserWebService(UserStore store) {
		this.store = store;
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAll() {
		return store.getAll();
	}
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User get(@PathParam("id") Long id) {
		return store.get(id);
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User create(User user) {
		return store.save(user);
	}
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User update(@PathParam("id") Long id, User user) {
		return store.save(user);
	}
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User delete(@PathParam("id") Long id) {
		return store.delete(store.get(id));
	}
}