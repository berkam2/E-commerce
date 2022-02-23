package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
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
    public Login() {
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
		
		
		request.setAttribute("voitures", vceDao.read());
		request.setAttribute("cars", vceDao.read().size());
		
		UserDao userDao = new UserDao();
		
		 
		request.setAttribute("post", postDao.read().get(postDao.read().size()-1));
		request.setAttribute("carsPromo", vceDao.isPromo().get(vceDao.isPromo().size()-1));
		System.out.println(vceDao.isPromo().get(vceDao.isPromo().size()-1));
		request.setAttribute("carsPromo1", vceDao.isPromo().get(vceDao.isPromo().size()-2));
		request.setAttribute("carsPromo2", vceDao.isPromo().get(vceDao.isPromo().size()-3));
		request.getRequestDispatcher("user/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		
		UserDao ud = new UserDao();
		boolean exist=false;
		if(ud.login(email, pwd) != null ) {
			
			exist=false;
			request.setAttribute("exist",exist);
			HttpSession session = request.getSession();
			
			session.setAttribute("joueur", ud.login(email, pwd));
		
			session.setAttribute("rdvse", rdvDao.findUser(ud.login(email, pwd).getIdUser()));
			session.setAttribute("jointure", actionDao.findUser(ud.login(email, pwd).getIdUser()));
			session.setAttribute("loc", locDao.findUser(ud.login(email, pwd).getIdUser()));
			session.setAttribute("sinistrees", sinDao.findUser(ud.login(email, pwd).getIdUser()));
		
			
			System.out.println(ud.login(email, pwd));
			if(ud.isAdmin(email)) {
				session.setAttribute("pro", ud.isAdmin(email));
				response.sendRedirect("Auto");
			}
			else {
			response.sendRedirect("HOME");
			}
		}else {
			exist=true;
			request.setAttribute("exist",exist);
			System.out.println("Oups: Vos identifiants de connexion sont incorrects");
			
			doGet(request, response);
		}
	}
	}


