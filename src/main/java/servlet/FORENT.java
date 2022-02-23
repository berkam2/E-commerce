package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ActionnariatDao;
import dao.CategoriesDao;
import dao.LocationDao;
import dao.OngletsDao;
import dao.PostDao;
import dao.TarifsDao;
import dao.UserDao;
import dao.VehiculeDao;
import modele.Location;
import modele.Tarifs;
import modele.User;
import modele.Vehicule;

/**
 * Servlet implementation class FORENT
 */
@WebServlet("/FORENT")
public class FORENT extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OngletsDao ongDao = new OngletsDao();
	CategoriesDao cteDao = new CategoriesDao();
	VehiculeDao vceDao = new VehiculeDao();
	PostDao postDao = new PostDao();
	ActionnariatDao actionDao= new ActionnariatDao();
	TarifsDao tfDao = new TarifsDao();
	LocationDao locDao = new LocationDao();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FORENT() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("onglets", ongDao.read());
		System.out.println(ongDao.read());
		
		request.setAttribute("actions", actionDao.read());
		
		request.setAttribute("categories", cteDao.read());
		
		
		request.setAttribute("voitures", vceDao.forRent());
		request.setAttribute("cars", vceDao.read().size());
		
		UserDao userDao = new UserDao();
		
		int id = Integer.parseInt(request.getParameter("idVehicule"));
		request.setAttribute("post", postDao.read().get(postDao.read().size()-1));
		request.setAttribute("carsPromo", vceDao.isPromo().get(vceDao.isPromo().size()-1));
		System.out.println(vceDao.isPromo().get(vceDao.isPromo().size()-1));
		request.setAttribute("carsPromo1", vceDao.isPromo().get(vceDao.isPromo().size()-2));
		request.setAttribute("carsPromo2", vceDao.isPromo().get(vceDao.isPromo().size()-3));
		request.setAttribute("tariff", tfDao.CarTarif(id));
		request.getRequestDispatcher("user/forent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int idUser = Integer.parseInt(request.getParameter("users"));
		int idVehicule = Integer.parseInt(request.getParameter("vehicules"));
		int idTarif = Integer.parseInt(request.getParameter("tariff"));
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
