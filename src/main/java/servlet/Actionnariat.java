package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ActionnariatDao;
import dao.UserDao;
import dao.VehiculeDao;
import modele.Actionnariats;
import modele.User;
import modele.Vehicule;

/**
 * Servlet implementation class Actionnariat
 */
@WebServlet("/Actionnariat")
public class Actionnariat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UserDao userDao = new UserDao();
       VehiculeDao vehiDao = new VehiculeDao();
       ActionnariatDao actionDao = new ActionnariatDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Actionnariat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("users", userDao.read());	
	
		
		request.setAttribute("vehicules", vehiDao.read());
		
		
		request.setAttribute("listeAction", actionDao.read());
		
		
		request.getRequestDispatcher("admin/actionnariat.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int idUser = Integer.parseInt(request.getParameter("users"));
		int idVehicule = Integer.parseInt(request.getParameter("vehicules"));
		int parts = Integer.parseInt(request.getParameter("parts"));
		
		User user = new User();
		Vehicule vehicule = new Vehicule();
		
		
		user.setIdUser(idUser);
		vehicule.setIdVehicule(idVehicule);
		
		Actionnariats action = new Actionnariats(user,vehicule,parts);
		
		actionDao.create(action);
		doGet(request, response);
	
	}

}
