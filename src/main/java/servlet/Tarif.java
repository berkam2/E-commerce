package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TarifsDao;
import dao.VehiculeDao;
import modele.Tarifs;
import modele.Vehicule;


/**
 * Servlet implementation class Tarif
 */
@WebServlet("/Tarif")
public class Tarif extends HttpServlet {
	private static final long serialVersionUID = 1L;
       VehiculeDao vehiDao = new VehiculeDao();
       TarifsDao tarifDao = new TarifsDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tarif() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setAttribute("vehicules", vehiDao.read());
		request.setAttribute("tarifs", tarifDao.read());
		request.getRequestDispatcher("admin/tarifs.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idVehicule = Integer.parseInt(request.getParameter("vehicules"));
		Double mbela = Double.parseDouble(request.getParameter("prixJour"));
		Vehicule vehicule = new Vehicule();
		vehicule.setIdVehicule(idVehicule);
		
		Tarifs tarif = new Tarifs(vehicule,mbela);
		tarifDao.create(tarif);
		
		
		doGet(request, response);
	}

}
