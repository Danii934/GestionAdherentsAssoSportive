

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
 * Servlet implementation class SupprimeGroupe
 */
public class SupprimeGroupe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimeGroupe() {
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
			System.out.println((String) request.getParameter("id"));
			int id = Integer.parseInt((String) request.getParameter("id"));
			EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("devoirPWA");
			EntityManager entityManager = entityManagerFactory.createEntityManager();

			entityManager.getTransaction().begin();
			Groupe g = entityManager.find(Groupe.class, id);
			if(g == null)
			{
				System.out.println("Groupe introuvable");
			}
			else
			{
				List<Personne> pers = entityManager.createQuery("select p from Personne p where (p.groupe =:groupId )", Personne.class).setParameter("groupId", g).getResultList();
				for(Personne p : pers)
				{
					p.setGroupe(null);
					entityManager.merge(p);
				}
				entityManager.remove(g);

			}
			entityManager.getTransaction().commit();
			List<Groupe> pers = entityManager.createQuery("select g from Groupe g", Groupe.class).getResultList();
	        request.setAttribute("groups", pers);
			entityManager.close();
			entityManagerFactory.close();
	        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/GestionGroupes.jsp");
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
