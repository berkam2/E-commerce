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

import dao.VehiculeDao;
import modele.Vehicule;

/**
 * Servlet implementation class Auto
 */
@WebServlet("/Auto")
@MultipartConfig()
public class Auto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	VehiculeDao vceDao = new VehiculeDao();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Auto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setAttribute("auto", vceDao.read());
		request.getRequestDispatcher("admin/vehicule.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method 		
		
		String marque = request.getParameter("marque");
		String modele = request.getParameter("modele");
		Double prix = Double.parseDouble(request.getParameter("prix"));
		String emplacement = request.getParameter("emplacement");
		int siege = Integer.parseInt(request.getParameter("siege"));
		Boolean etat = Boolean.parseBoolean(request.getParameter("etat"));
		Boolean oneOff = Boolean.parseBoolean(request.getParameter("oneOff"));
		String couleur = request.getParameter("color");
		String energy = request.getParameter("energy");
		int miles = Integer.parseInt(request.getParameter("miles"));
		int year = Integer.parseInt(request.getParameter("year"));
		String mechanic = request.getParameter("mechanic");
		String interieur = request.getParameter("interieur");
		
		
		//Recuperation de l'image upload depuis le formulaire via le name 
		 
				Part file=request.getPart("image");
				

				//Recuperation du nom de l'image 
				String filename = file.getSubmittedFileName();

				System.out.println(filename);

				/*ICi je choisis ou je veux stocker mon image
				 * A noter que l'image est stockée physiquement soit sur le serveur ou soit dans votre machine
				 * NB: Nous ne mettons que le nom de l'image en base de donnée
				 */
				String uploadPath="C:\\Users\\moi\\Desktop\\eclipse-workspace\\METWA\\src\\main\\webapp\\voitures\\"+filename;  // Destination

				
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
Part file1=request.getPart("image1");
				

				//Recuperation du nom de l'image 
				String filename1 = file1.getSubmittedFileName();

				System.out.println(filename1);

				/*ICi je choisis ou je veux stocker mon image
				 * A noter que l'image est stockée physiquement soit sur le serveur ou soit dans votre machine
				 * NB: Nous ne mettons que le nom de l'image en base de donnée
				 */
				String uploadPath1="C:\\Users\\moi\\Desktop\\eclipse-workspace\\METWA\\src\\main\\webapp\\voitures\\"+filename1;  // Destination

				
				try
				{
				
					FileOutputStream fos=new FileOutputStream(uploadPath1);
					InputStream is=file1.getInputStream();
					
					byte[] data=new byte[is.available()];
					is.read(data);
					fos.write(data);
					fos.close();
				
				}
				
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
Part file2=request.getPart("image2");
				

				//Recuperation du nom de l'image 
				String filename2 = file2.getSubmittedFileName();

				System.out.println(filename2);

				/*ICi je choisis ou je veux stocker mon image
				 * A noter que l'image est stockée physiquement soit sur le serveur ou soit dans votre machine
				 * NB: Nous ne mettons que le nom de l'image en base de donnée
				 */
				String uploadPath2="C:\\Users\\moi\\Desktop\\eclipse-workspace\\METWA\\src\\main\\webapp\\voitures\\"+filename2;  // Destination

				
				try
				{
				
					FileOutputStream fos=new FileOutputStream(uploadPath2);
					InputStream is=file2.getInputStream();
					
					byte[] data=new byte[is.available()];
					is.read(data);
					fos.write(data);
					fos.close();
				
				}
				
				catch(Exception e)
				{
					e.printStackTrace();
				}
Part file3=request.getPart("image3");
				

				//Recuperation du nom de l'image 
				String filename3 = file3.getSubmittedFileName();

				System.out.println(filename3);

				/*ICi je choisis ou je veux stocker mon image
				 * A noter que l'image est stockée physiquement soit sur le serveur ou soit dans votre machine
				 * NB: Nous ne mettons que le nom de l'image en base de donnée
				 */
				String uploadPath3="C:\\Users\\moi\\Desktop\\eclipse-workspace\\METWA\\src\\main\\webapp\\voitures\\"+filename3;  // Destination

				
				try
				{
				
					FileOutputStream fos=new FileOutputStream(uploadPath3);
					InputStream is=file3.getInputStream();
					
					byte[] data=new byte[is.available()];
					is.read(data);
					fos.write(data);
					fos.close();
				
				}
				
				catch(Exception e)
				{
					e.printStackTrace();
				}
				String description = request.getParameter("description");
				
				Boolean approved = Boolean.parseBoolean(request.getParameter("approved"));
				int partDispo = Integer.parseInt(request.getParameter("partDispo"));
				Boolean forRent = Boolean.parseBoolean(request.getParameter("forRent"));
				String available = request.getParameter("availability");
		Vehicule newVehicule = new Vehicule(marque, modele, prix, emplacement, siege, etat, oneOff, couleur, energy, miles, year, mechanic, interieur, filename,filename1,filename2,filename3,description,approved,partDispo,forRent,available);
		vceDao.create(newVehicule);
		response.sendRedirect("Auto");
		
	}

}
