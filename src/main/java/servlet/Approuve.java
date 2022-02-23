package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VehiculeDao;
import modele.Vehicule;

/**
 * Servlet implementation class Approuve
 */
@WebServlet("/Approuve")
public class Approuve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       VehiculeDao vceDao = new VehiculeDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Approuve() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idVehicule = Integer.parseInt(request.getParameter("idVehicule"));
		Vehicule vehicule = new Vehicule();
		vehicule.setIdVehicule(idVehicule);
		vceDao.approuve(vehicule);
		response.sendRedirect("Auto");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}

}
