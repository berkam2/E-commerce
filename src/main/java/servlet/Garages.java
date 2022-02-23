package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GarageDao;
import dao.SinistreDao;
import dao.VehiculeDao;
import modele.Garage;
import modele.Location;
import modele.Sinistre;
import modele.User;
import modele.Vehicule;

/**
 * Servlet implementation class Garages
 */
@WebServlet("/Garages")
public class Garages extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
       SinistreDao sinDao = new SinistreDao();
       GarageDao garageDao = new GarageDao();
       VehiculeDao vehiDao = new VehiculeDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Garages() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("vehicules", vehiDao.read());
		request.setAttribute("garages", garageDao.read());
		request.setAttribute("sinistres", sinDao.read());
		request.getRequestDispatcher("admin/garage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idSinistre = Integer.parseInt(request.getParameter("sinistres"));
		String entree = request.getParameter("entree");
		String sortie = request.getParameter("sortie");
		String description = request.getParameter("description");
		Double cout = Double.parseDouble(request.getParameter("cout"));
		
		
		
		
		Sinistre sinistre = new Sinistre();
		
		
		sinistre.setIdSinistre(idSinistre);
		
		Garage garage = new Garage(sinistre,cout,description,entree,sortie);
		System.out.println(garage);
		garageDao.create(garage);
		
		
		doGet(request, response);
	}

}
