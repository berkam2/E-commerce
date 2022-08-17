package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LocationDao;
import dao.TarifsDao;
import dao.UserDao;
import dao.VehiculeDao;
import modele.Actionnariats;
import modele.Location;
import modele.Tarifs;
import modele.User;
import modele.Vehicule;

/**
 * Servlet implementation class Locations
 */
@WebServlet("/Locations")
public class Locations extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserDao userDao = new UserDao();
    VehiculeDao vehiDao = new VehiculeDao();
    LocationDao locDao = new LocationDao();
    TarifsDao tarifDao = new TarifsDao();
    LivreDao livDao = new LivreDao();
  
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Locations() {
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
		
		request.setAttribute("tarifs", tarifDao.read());
		request.setAttribute("locations", locDao.read());
		request.getRequestDispatcher("admin/location.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int idUser = Integer.parseInt(request.getParameter("users"));
		int idVehicule = Integer.parseInt(request.getParameter("vehicules"));
		int idTarif = Integer.parseInt(request.getParameter("tarifs"));
		String debut = request.getParameter("debut");
		String fin = request.getParameter("fin");
		System.out.println(request.getParameter("duree"));
		int nbreJour = Integer.parseInt(request.getParameter("duree"));
		String priseEnCharge = request.getParameter("priseEnCharge");

		User user = new User();
		Vehicule vehicule = new Vehicule();
		Tarifs mbela = new Tarifs();
		
		
		
		user.setIdUser(idUser);
		vehicule.setIdVehicule(idVehicule);
		mbela.setIdTariff(idTarif);
		
		Location location = new Location(user,vehicule,debut,fin,nbreJour,mbela,priseEnCharge);
		
		locDao.create(location);
		doGet(request, response);
	}

}
