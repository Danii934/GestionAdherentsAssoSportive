

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
 * Servlet implementation class SupprimerMembre
 */
public class SupprimerMembre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerMembre() {
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
			Personne p = entityManager.find(Personne.class, id);
			if(p == null)
			{
				System.out.println("Personne non existante");
			}
			else
			{
				Groupe g = p.getGroupe();
				p.setGroupe(null);
				g.setNbMembres(g.getNbMembres() - 1);
				entityManager.merge(p);
				List<Personne> pers = entityManager.createQuery("select p from Personne p where (p.groupe =:groupId )", Personne.class).setParameter("groupId", g).getResultList();
				request.setAttribute("users", pers);
				request.setAttribute("group", g);
			}
			entityManager.getTransaction().commit();
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
