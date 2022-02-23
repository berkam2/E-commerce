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

import dao.PostDao;
import modele.Post;

/**
 * Servlet implementation class Blog
 */
@WebServlet("/Blog")
@MultipartConfig()
public class Blog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	PostDao postDao = new PostDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Blog() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("posts", postDao.read());
		request.getRequestDispatcher("admin/post.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String titre = request.getParameter("titre");
		String resume = request.getParameter("resume");
		String contenu = request.getParameter("contenu");
		String auteur = request.getParameter("auteur");
		
		
		
		 
				Part file=request.getPart("image");
				

				
				String filename = file.getSubmittedFileName();

				System.out.println(filename);

				
				String uploadPath="C:\\Users\\moi\\Desktop\\eclipse-workspace\\METWA\\src\\main\\webapp\\actualite\\"+filename;  // Destination

				
				try
				{
				
					FileOutputStream fos=new FileOutputStream(uploadPath);
					InputStream is=file.getInputStream();
					
					byte[] data=new byte[is.available()];
					is.read(data);
					fos.write(data);
					fos.close();
				
				}
				
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
		Post newPost = new Post( titre, resume, contenu, auteur, filename);
		postDao.create(newPost);
		doGet(request, response);
	}

}
