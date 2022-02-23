package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LocationDao;
import dao.SinistreDao;
import dao.UserDao;
import dao.VehiculeDao;
import modele.Location;
import modele.Sinistre;
import modele.Tarifs;
import modele.User;
import modele.Vehicule;

/**
 * Servlet implementation class Sinistres
 */
@WebServlet("/Sinistres")
public class Sinistres extends HttpServlet {
	private static final long serialVersionUID = 1L;
       SinistreDao sinistreDao = new SinistreDao();
       VehiculeDao vehiDao = new VehiculeDao();
       UserDao userDao = new UserDao(); 
       LocationDao locDao = new LocationDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sinistres() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setAttribute("locations", locDao.read());
		request.setAttribute("users", userDao.read());
		request.setAttribute("vehicules", vehiDao.read());
		request.setAttribute("sinistres", sinistreDao.read());
		request.getRequestDispatcher("admin/sinistre.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int idUser = Integer.parseInt(request.getParameter("users"));
		int idVehicule = Integer.parseInt(request.getParameter("vehicules"));
		int idLocation = Integer.parseInt(request.getParameter("locations"));
		String date = request.getParameter("date");
		String description = request.getParameter("description");

		User user = new User();
		Vehicule vehicule = new Vehicule();
		Location location = new Location();
		
		
		
		user.setIdUser(idUser);
		vehicule.setIdVehicule(idVehicule);
		location.setIdLocation(idLocation);
		
		Sinistre sinistre = new Sinistre(user,vehicule,location,date,description);
		
		sinistreDao.create(sinistre);
		doGet(request, response);
	}

}
