
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
 * Servlet implementation class AjouterMembre
 */
public class AjouterMembre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterMembre() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
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
				System.out.println("Groupe inconnu");
			}
			else
			{
				request.setAttribute("group", g);
				
			}
			entityManager.getTransaction().commit();
			List<Personne> pers = entityManager.createQuery("select p from Personne p where (p.groupe IS NULL)", Personne.class).getResultList();
	        request.setAttribute("users", pers);
	        request.setAttribute("groupID", id);
			entityManager.close();
			entityManagerFactory.close();
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AjouterMembre.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if((String) request.getParameter("groupId") != null)
		{
			System.out.println((String) request.getParameter("groupId"));
			int id = Integer.parseInt((String) request.getParameter("groupId"));
			String[] checked = request.getParameterValues("selected");

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
				request.setAttribute("group", g);
				
			}
			for(String idP : checked)
			{
				Personne p = entityManager.find(Personne.class, Integer.parseInt(idP));
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
			g.setNbMembres(g.getNbMembres() + checked.length);
			entityManager.merge(g);
			entityManager.getTransaction().commit();
			List<Personne> pers = entityManager.createQuery("select p from Personne p where (p.groupe =:groupId )", Personne.class).setParameter("groupId", g).getResultList();
			request.setAttribute("users", pers);
			request.setAttribute("groupName", g.getNomGroupe());
			request.setAttribute("groupId", g.getIdGroupe());
			entityManager.close();
			entityManagerFactory.close();
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AfficheGroupe.jsp");
			dispatcher.forward(request, response);
	}
 }
}
