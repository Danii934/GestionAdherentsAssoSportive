

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
 * Servlet implementation class AfficheGroupe
 */
public class AfficheGroupe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficheGroupe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if((String) request.getParameter("id") != null)
		{
			int id = Integer.parseInt((String) request.getParameter("id"));
			EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("devoirPWA");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			Groupe g = entityManager.find(Groupe.class, id);
			if(g == null)
			{
				System.out.println("Groupe inconnu");
			}
			else
			{
				entityManager.getTransaction().commit();
				List<Personne> pers = entityManager.createQuery("select p from Personne p where (p.groupe =:groupId )", Personne.class).setParameter("groupId", g).getResultList();
				request.setAttribute("users", pers);
				request.setAttribute("group", g);
				
				
			}
			entityManager.close();
			entityManagerFactory.close();
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AfficheGroupe.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
