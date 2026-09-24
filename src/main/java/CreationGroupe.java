

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.Groupe;
import pojo.Personne;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class CreationGroupe
 */
public class CreationGroupe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreationGroupe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 EntityManagerFactory entityManagerFactory = null;
	     EntityManager entityManager = null;
	     entityManagerFactory = Persistence.createEntityManagerFactory("devoirPWA");
	     entityManager = entityManagerFactory.createEntityManager();
		 List<Personne> pers = entityManager.createQuery("select p from Personne p where (p.groupe IS NULL)", Personne.class).getResultList();
         request.setAttribute("users", pers);
		 entityManager.close();
		 entityManagerFactory.close();
         RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CreationGroupe.jsp");
		 dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] checked = request.getParameterValues("selected");
		for(String zone : checked)
			System.out.println(zone);
		System.out.println((String) request.getParameter("nomgroupe"));
		Groupe g = new Groupe((String) request.getParameter("nomgroupe"));
		EntityManagerFactory entityManagerFactory = null;
	     EntityManager entityManager = null;
	     entityManagerFactory = Persistence.createEntityManagerFactory("devoirPWA");
	     entityManager = entityManagerFactory.createEntityManager();

	    entityManager.getTransaction().begin();
		for(String id : checked)
		{
			Personne p = entityManager.find(Personne.class, Integer.parseInt(id));
			if(p == null)
			{
				System.out.println("Personne non existante");
			}
			else
			{
				p.setGroupe(g);
				entityManager.merge(p);
			}
		}
		g.setNbMembres(checked.length);
		entityManager.persist(g);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		doGet(request, response);
	}

}
