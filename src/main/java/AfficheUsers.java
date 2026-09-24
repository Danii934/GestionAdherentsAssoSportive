import pojo.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
/**
 * Servlet implementation class AfficheUsers
 */
@WebServlet("/AfficheUsers")
public class AfficheUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficheUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 EntityManagerFactory entityManagerFactory = null;
	     EntityManager entityManager = null;
	     entityManagerFactory = Persistence.createEntityManagerFactory("devoirPWA");
	     entityManager = entityManagerFactory.createEntityManager();
		 List<Personne> pers = entityManager.createQuery("select p from Personne p", Personne.class).getResultList();
         request.setAttribute("users", pers);
		 entityManager.close();
		 entityManagerFactory.close();
         RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/GestionUsers.jsp");
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
