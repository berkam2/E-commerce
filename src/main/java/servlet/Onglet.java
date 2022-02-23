package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OngletsDao;
import modele.Onglets;
import modele.User;

/**
 * Servlet implementation class Onglet
 */
@WebServlet("/Onglet")
public class Onglet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       OngletsDao ongDao = new OngletsDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Onglet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public Onglet(String onglet) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("onglets", ongDao.read());
		request.getRequestDispatcher("admin/onglets.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String onglet = request.getParameter("onglet");
		
		
		
		Onglets newOnglet = new Onglets( onglet);
		
		System.out.println(newOnglet);
		
		ongDao = new OngletsDao();
		ongDao.create(newOnglet);
		doGet(request, response);
	}

}
