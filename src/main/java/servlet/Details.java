package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoriesDao;
import dao.OngletsDao;
import dao.PostDao;
import dao.VehiculeDao;

/**
 * Servlet implementation class Details
 */
@WebServlet("/Details")
public class Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       VehiculeDao vceDao = new VehiculeDao();
       CategoriesDao ctgDao = new CategoriesDao();
       OngletsDao ongDao = new OngletsDao();
       PostDao postDao = new PostDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Details() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("carsPromo", vceDao.isPromo().get(vceDao.isPromo().size()-1));
		System.out.println(vceDao.isPromo().get(vceDao.isPromo().size()-1));
		request.setAttribute("carsPromo1", vceDao.isPromo().get(vceDao.isPromo().size()-2));
		request.setAttribute("carsPromo2", vceDao.isPromo().get(vceDao.isPromo().size()-3));
		request.setAttribute("cars", vceDao.read().size());
		
		 
	       
	        request.setAttribute("categories",ctgDao.read());
	        request.setAttribute("onglets",ongDao.read());
	        
	        if(request.getParameter("idVehicule")!=null) {
	        int id = Integer.parseInt(request.getParameter("idVehicule"));
	        request.setAttribute("vehicule", vceDao.findById(id));
	        }
	        else if(request.getParameter("id")!=null) {
	        	int id=Integer.parseInt(request.getParameter("id"));
	        	request.setAttribute("post", postDao.findById(id));
	        }
	        request.getRequestDispatcher("user/details.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	      doGet(request,response);
	        
	}

}
