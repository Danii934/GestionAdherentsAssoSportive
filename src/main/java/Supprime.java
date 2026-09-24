

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.Personne;

import java.io.IOException;
import java.util.List;

import com.google.protobuf.TextFormatParseInfoTree;
@WebServlet("/Supprime")
/**
 * Servlet implementation class Supprime
 */
public class Supprime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Supprime() {
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
				entityManager.remove(p);
			}
			entityManager.getTransaction().commit();
			List<Personne> pers = entityManager.createQuery("select p from Personne p", Personne.class).getResultList();
	        request.setAttribute("users", pers);
			entityManager.close();
			entityManagerFactory.close();
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/GestionUsers.jsp");
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
