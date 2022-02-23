package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StatutDao;
import modele.Statut;

/**
 * Servlet implementation class Statuts
 */
@WebServlet("/Statuts")
public class Statuts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       StatutDao statutDao = new StatutDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Statuts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		request.setAttribute("statuts", statutDao.read());
		request.getRequestDispatcher("admin/statut.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String state = request.getParameter("statut");
		
		System.out.println("ZAK : "+state);
		
		Statut newStatut = new Statut(state);
		statutDao.create(newStatut);
		
		System.out.println(newStatut);
		doGet(request, response);
	}

}
