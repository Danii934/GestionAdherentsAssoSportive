

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
 * Servlet implementation class AfficherGroupes
 */
public class AfficherGroupes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficherGroupes() {
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
		 List<Groupe> pers = entityManager.createQuery("select g from Groupe g", Groupe.class).getResultList();
         request.setAttribute("groups", pers);
		 entityManager.close();
		 entityManagerFactory.close();
         RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/GestionGroupes.jsp");
		 dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
