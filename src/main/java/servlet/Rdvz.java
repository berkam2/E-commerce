package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RdvDao;
import dao.UserDao;
import dao.VehiculeDao;
import modele.Location;
import modele.Rdv;
import modele.Tarifs;
import modele.User;
import modele.Vehicule;

/**
 * Servlet implementation class Rdvz
 */
@WebServlet("/Rdvz")
public class Rdvz extends HttpServlet {
	private static final long serialVersionUID = 1L;
       VehiculeDao vehiDao = new VehiculeDao();
       UserDao userDao = new UserDao();
       RdvDao rdvDao = new RdvDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Rdvz() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setAttribute("vehicules", vehiDao.read());
		request.setAttribute("users", userDao.read());
		request.getRequestDispatcher("admin/rdv.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int idUser = Integer.parseInt(request.getParameter("users"));
		int idVehicule = Integer.parseInt(request.getParameter("vehicules"));
		
		String date = request.getParameter("date");
		String heure = request.getParameter("heure");
		
		User user = new User();
		Vehicule vehicule = new Vehicule();
	
		
		
		user.setIdUser(idUser);
		vehicule.setIdVehicule(idVehicule);
	
		
		Rdv rdv = new Rdv(user,vehicule,date,heure);
		
		rdvDao.create(rdv);
		doGet(request, response);
	}

}
