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
import modele.Actionnariats;
import modele.User;
import modele.Vehicule;

/**
 * Servlet implementation class Achat
 */
@WebServlet("/Achat")
public class Achat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OngletsDao ongDao = new OngletsDao();
	CategoriesDao cteDao = new CategoriesDao();
	VehiculeDao vceDao = new VehiculeDao();
	PostDao postDao = new PostDao();
	ActionnariatDao actionDao= new ActionnariatDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Achat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 int id = Integer.parseInt(request.getParameter("idVehicule"));
		 request.setAttribute("voiture", vceDao.findById(id));
		
		request.setAttribute("onglets", ongDao.read());
		
		
		request.setAttribute("actions", actionDao.read());
		
		request.setAttribute("categories", cteDao.read());
		
		
		request.setAttribute("voitures", vceDao.read());
		request.setAttribute("cars", vceDao.read().size());
		
		UserDao userDao = new UserDao();
		
		
		request.setAttribute("post", postDao.read().get(postDao.read().size()-1));
		request.setAttribute("carsPromo", vceDao.isPromo().get(vceDao.isPromo().size()-1));
		System.out.println(vceDao.isPromo().get(vceDao.isPromo().size()-1));
		request.setAttribute("carsPromo1", vceDao.isPromo().get(vceDao.isPromo().size()-2));
		request.setAttribute("carsPromo2", vceDao.isPromo().get(vceDao.isPromo().size()-3));
		request.getRequestDispatcher("user/achat.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int idUser = Integer.parseInt(request.getParameter("users"));
		int idVehicule = Integer.parseInt(request.getParameter("vehicules"));
		int parts = Integer.parseInt(request.getParameter("parts"));
		int partDispo = Integer.parseInt(request.getParameter("partDispo"));
		int vente = (partDispo - parts);
		
		
		
		User user = new User();
		Vehicule vehicule = new Vehicule();
		
		
		user.setIdUser(idUser);
		vehicule.setIdVehicule(idVehicule);
		
		Actionnariats action = new Actionnariats(user,vehicule,parts);
		
		//actionDao.create(action);
		vceDao.reducePart(vente,vehicule);
		
		response.sendRedirect("HOME");

	}

}
