package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ActionnariatDao;
import dao.CategoriesDao;
import dao.OngletsDao;
import dao.PostDao;
import dao.UserDao;
import dao.VehiculeDao;
import modele.User;

/**
 * Servlet implementation class CONTACT
 */
@WebServlet("/CONTACT")
public class CONTACT extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OngletsDao ongDao = new OngletsDao();
	CategoriesDao cteDao = new CategoriesDao();
	VehiculeDao vceDao = new VehiculeDao();
	PostDao postDao = new PostDao();
	ActionnariatDao actionDao= new ActionnariatDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CONTACT() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
request.setAttribute("categories", cteDao.read());
		
		request.setAttribute("onglets", ongDao.read());
		request.setAttribute("voitures", vceDao.read());
		request.setAttribute("cars", vceDao.read().size());
		
		UserDao userDao = new UserDao();
		
		 
		request.setAttribute("post", postDao.read().get(postDao.read().size()-1));
		request.setAttribute("carsPromo", vceDao.isPromo().get(vceDao.isPromo().size()-1));
		System.out.println(vceDao.isPromo().get(vceDao.isPromo().size()-1));
		request.setAttribute("carsPromo1", vceDao.isPromo().get(vceDao.isPromo().size()-2));
		request.setAttribute("carsPromo2", vceDao.isPromo().get(vceDao.isPromo().size()-3));
		request.getRequestDispatcher("user/contact.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		
		
		String email=request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));
		
		
		
		String date1= request.getParameter("obtentionPermis");
		
		String telephone = request.getParameter("telephone");
		String adresse = request.getParameter("adresse");
		
		String message = request.getParameter("message");
		
		response.sendRedirect("HOME");
		
		doGet(request, response);
	}

}
