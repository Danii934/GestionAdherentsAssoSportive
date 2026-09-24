package webservices;

import java.util.Collection;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import pojo.Groupe;
import pojo.Personne;
@Path("/test")
public class TestWebservice {
	@GET
	@Path("/hello")
	public String Hello() {
		return "Hello World!!!!";
	}
	@GET
	@Path("/getUsers")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Collection<Personne> getUsers() {
		EntityManagerFactory entityManagerFactory = null;
	     EntityManager entityManager = null;
	     entityManagerFactory = Persistence.createEntityManagerFactory("devoirPWA");
	     entityManager = entityManagerFactory.createEntityManager();
		 List<Personne> pers = entityManager.createQuery("select p from Personne p", Personne.class).getResultList();
		 return pers;
	}
	
	@GET
	@Path("/getGroups")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Collection<Groupe> getGroupes() {
		EntityManagerFactory entityManagerFactory = null;
	     EntityManager entityManager = null;
	     entityManagerFactory = Persistence.createEntityManagerFactory("devoirPWA");
	     entityManager = entityManagerFactory.createEntityManager();
		 List<Groupe> pers = entityManager.createQuery("select g from Groupe g", Groupe.class).getResultList();
		 return pers;
	}
	@DELETE
	@Path("/users/remove/{id}")
	public Response deleteBook(@PathParam("id") String id) {
		EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("devoirPWA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		Personne p = entityManager.find(Personne.class, Integer.parseInt(id));
		if(p == null)
		{
			System.out.println("Personne non existante");
		}
		else
		{
			entityManager.remove(p);
		}
		entityManager.getTransaction().commit();
		return Response.ok().build();
	}
	@PUT
	@Path("/users/add/{nom}/{prenom}/{ddn}/{adresse}/{cp}/{ville}/{mail}/{tel}/{date_cotisation}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response addBook(@PathParam("nom") String nom,
			@PathParam("prenom") String prenom,
			@PathParam("ddn") String ddn,
			@PathParam("adresse") String adresse,
			@PathParam("cp") String cp,
			@PathParam("ville") String ville,
			@PathParam("mail") String mail,
			@PathParam("tel") String tel,
			@PathParam("date_cotisation") String date_cotisation) {
		Personne p = new Personne(nom,prenom,adresse,ddn,cp,ville,mail,tel,date_cotisation);
		EntityManagerFactory entityManagerFactory = null;
	    EntityManager entityManager = null;
	    entityManagerFactory = Persistence.createEntityManagerFactory("devoirPWA");
	    entityManager = entityManagerFactory.createEntityManager();

	    entityManager.getTransaction().begin();
		entityManager.persist(p);
		entityManager.getTransaction().commit();
		return Response.ok(p).build();
	}
	
}
