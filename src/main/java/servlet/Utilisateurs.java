package servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.StatutDao;
import dao.UserDao;
import modele.Post;
import modele.User;

/**
 * Servlet implementation class Utilisateurs
 */
@WebServlet("/Utilisateurs")
@MultipartConfig()
public class Utilisateurs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao userDao = new UserDao();
	StatutDao statutDao = new StatutDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Utilisateurs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("statuts", statutDao.read());
		request.setAttribute("users", userDao.read());
		request.getRequestDispatcher("admin/user.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		int statut = Integer.parseInt(request.getParameter("statut"));
		
		System.out.println(statut);
		System.out.println(statut);
		
		String email=request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));
		
		
		
		String date1= request.getParameter("obtentionPermis");
		
		String telephone = request.getParameter("telephone");
		String adresse = request.getParameter("adresse");
		String permis = request.getParameter("permis");
		String mdp = request.getParameter("mdp");
		
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
		
		
		User newUser = new User( nom, prenom, statut, email,age,telephone,mdp,adresse,date1,permis,filename4);
		
		System.out.println(newUser);
		userDao.create(newUser);
		doGet(request, response);
		
		
	}

}
