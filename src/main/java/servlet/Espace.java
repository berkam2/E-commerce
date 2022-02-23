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
import dao.RdvDao;
import dao.SinistreDao;
import dao.UserDao;
import dao.VehiculeDao;

/**
 * Servlet implementation class Espace
 */
@WebServlet("/Espace")
public class Espace extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OngletsDao ongDao = new OngletsDao();
	CategoriesDao cteDao = new CategoriesDao();
	VehiculeDao vceDao = new VehiculeDao();
	PostDao postDao = new PostDao();
	ActionnariatDao actionDao= new ActionnariatDao();
	RdvDao rdvDao = new RdvDao();
	LocationDao locDao = new LocationDao();
	SinistreDao sinDao = new SinistreDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Espace() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		request.setAttribute("onglets", ongDao.read());
		
		
		request.setAttribute("categories", cteDao.read());
		
		
		request.setAttribute("voitures", vceDao.read());
		request.setAttribute("cars", vceDao.read().size());
		
		UserDao userDao = new UserDao();
		
		 
		request.setAttribute("post", postDao.read().get(postDao.read().size()-1));
		request.setAttribute("carsPromo", vceDao.isPromo().get(vceDao.isPromo().size()-1));
		System.out.println(vceDao.isPromo().get(vceDao.isPromo().size()-1));
		request.setAttribute("carsPromo1", vceDao.isPromo().get(vceDao.isPromo().size()-2));
		request.setAttribute("carsPromo2", vceDao.isPromo().get(vceDao.isPromo().size()-3));
		request.getParameter("idUser");
		request.getRequestDispatcher("user/espace.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
