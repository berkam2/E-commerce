package servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.ActionnariatDao;
import dao.CategoriesDao;
import dao.OngletsDao;
import dao.PostDao;
import dao.UserDao;
import dao.VehiculeDao;
import modele.User;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
@MultipartConfig()
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UserDao userDao = new UserDao();
       OngletsDao ongDao = new OngletsDao();
   	CategoriesDao cteDao = new CategoriesDao();
   	VehiculeDao vceDao = new VehiculeDao();
   	PostDao postDao = new PostDao();
   	ActionnariatDao actionDao= new ActionnariatDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
request.setAttribute("onglets", ongDao.read());
		
		
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
		request.setAttribute("onglets", ongDao.read());
		request.getRequestDispatcher("user/signup.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		
		
		String email=request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));
		
		
		
		String date1= request.getParameter("obtentionPermis");
		
		String telephone = request.getParameter("telephone");
		String adresse = request.getParameter("adresse");
		String permis = request.getParameter("permis");
		String mdp = request.getParameter("mdp");
		String mdp2 = request.getParameter("mdp2");
		int statut = 2;
		
		Part file4=request.getPart("image");
		
		String filename4 = file4.getSubmittedFileName();

		

		String uploadPath4="C:\\Users\\moi\\Desktop\\eclipse-workspace\\METWA\\src\\main\\webapp\\profile\\"+filename4;  // Destination

		
		try
		{
		
			FileOutputStream fos=new FileOutputStream(uploadPath4);
			InputStream is=file4.getInputStream();
			
			byte[] data=new byte[is.available()];
			is.read(data);
			fos.write(data);
			fos.close();
		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		User newUser = new User( nom, prenom,statut, email,age,telephone,mdp,adresse,date1,permis,filename4);
		boolean exist = false;
		
		if(userDao.mailFree(email)) {
			
			userDao.create(newUser);
			System.out.println(newUser);
			exist = false;
			request.setAttribute("exist", exist);
			request.getRequestDispatcher("user/signup.jsp").forward(request, response);
			//response.sendRedirect("home");
			doGet(request, response);
			
		}else {
			exist = true;
			request.setAttribute("exist", exist);
			
			request.getRequestDispatcher("user/signup.jsp").forward(request, response);
		}
		
		System.out.println(newUser);
		//userDao.create(newUser);
		doGet(request, response);
	}

}
