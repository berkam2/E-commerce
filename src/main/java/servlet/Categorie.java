package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoriesDao;
import dao.OngletsDao;
import modele.Categories;
import modele.Onglets;

/**
 * Servlet implementation class Categorie
 */
@WebServlet("/Categorie")
public class Categorie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       OngletsDao ongDao = new OngletsDao();
       CategoriesDao ctgDao = new CategoriesDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Categorie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("onglets", ongDao.read());
		request.setAttribute("categories", ctgDao.read());
		request.getRequestDispatcher("admin/categorie.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String categorieBrute = request.getParameter("categorie");
		
		String categorie = categorieBrute.replace(" ", "");
		
		Categories newCategorie = new Categories( categorie);
		
		System.out.println(newCategorie);
		
		
		ctgDao.create(newCategorie);
		
		doGet(request, response);
	}

}
