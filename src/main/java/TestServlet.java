import pojo.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher("/Test.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println();
		String nom = (String)request.getParameter("nom");
		String prenom = (String)request.getParameter("prenom");
		String ddn = (String)request.getParameter("ddn");
		String adresse = (String)request.getParameter("adresse");
		String cp = (String)request.getParameter("cp");
		String ville = (String)request.getParameter("ville");
		String mail = (String)request.getParameter("mail");
		String tel = (String)request.getParameter("tel");
		String date_cotisation = (String)request.getParameter("date_cotisation");
		Personne p = new Personne(nom,prenom,adresse,ddn,cp,ville,mail,tel,date_cotisation);
		System.out.println(p);
		
		 EntityManagerFactory entityManagerFactory = null;
	     EntityManager entityManager = null;
	     entityManagerFactory = Persistence.createEntityManagerFactory("devoirPWA");
	     entityManager = entityManagerFactory.createEntityManager();

	    entityManager.getTransaction().begin();
		entityManager.persist(p);
		entityManager.getTransaction().commit();
		List<Personne> pers = entityManager.createQuery("select p from Personne p", Personne.class).getResultList();
        request.setAttribute("users", pers);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/GestionUsers.jsp");
		dispatcher.forward(request, response);
		/*List<Personne> pers = entityManager.createQuery("select p from Personne p", Personne.class).getResultList();
		for (Personne article : pers) {
            System.out.println( article );
        }*/
		
		
	}

}
