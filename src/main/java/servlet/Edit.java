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

import dao.LocationDao;
import dao.OngletsDao;
import dao.PostDao;
import dao.StatutDao;
import dao.TarifsDao;
import dao.UserDao;
import dao.VehiculeDao;
import modele.Location;
import modele.Onglets;
import modele.Post;
import modele.Statut;
import modele.Tarifs;
import modele.User;
import modele.Vehicule;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/Edit")
@MultipartConfig()
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	StatutDao statutDao = new StatutDao();
	VehiculeDao vehiDao = new VehiculeDao();
	TarifsDao tarifDao = new TarifsDao();
	OngletsDao ongDao = new OngletsDao();
	PostDao postDao = new PostDao();
	LocationDao locDao = new LocationDao();
	UserDao userDao = new UserDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("idStatut")!=null) {
		int id = Integer.parseInt(request.getParameter("idStatut"));
		System.out.println(id);
		request.setAttribute("statut", statutDao.findById(id));
		}
		else if(request.getParameter("idLocation")!=null) {
			int idLocation = Integer.parseInt(request.getParameter("idLocation"));
			request.setAttribute("location", locDao.findById(idLocation));
			request.setAttribute("users", userDao.read());
			request.setAttribute("tarifs",tarifDao.read());
			request.setAttribute("vehicules",vehiDao.read());
		}
		else if(request.getParameter("id")!=null) {
			int idPost = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("post",postDao.findById(idPost));
		}
		else if(request.getParameter("idOnglet")!=null) {
			int idOnglet = Integer.parseInt(request.getParameter("idOnglet"));
			request.setAttribute("onglet", ongDao.findById(idOnglet));
		}
		else if(request.getParameter("idVehicule")!=null) {
		int idVehi = Integer.parseInt(request.getParameter("idVehicule"));
		System.out.println(vehiDao.findById(idVehi));
		request.setAttribute("voiture", vehiDao.findById(idVehi));
		}
		else if(request.getParameter("idTariff")!=null){
			int idTariff = Integer.parseInt(request.getParameter("idTariff"));
			request.setAttribute("tarif", tarifDao.findById(idTariff));
			request.setAttribute("vehicules",vehiDao.read());
		}
		else if (request.getParameter("idUser")!=null){
			int idUser = Integer.parseInt(request.getParameter("idUser"));
			request.setAttribute("user", userDao.findById(idUser));
			request.setAttribute("statuts", statutDao.read());
		}
		request.getRequestDispatcher("admin/edit.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if (request.getParameter("idUpdated")!=null) {
		int idUpdate = Integer.parseInt(request.getParameter("idUpdated"));
		Statut editStatut = new Statut(idUpdate, request.getParameter("libelle"));
		statutDao.update(editStatut);
		response.sendRedirect("Statuts");
		}
		if(request.getParameter("idOngletUpdated")!=null) {
			int idOngletUpdated = Integer.parseInt(request.getParameter("idOngletUpdated"));
			String onglet = request.getParameter("libelle");
			Onglets onglets = new Onglets(idOngletUpdated,onglet);
			ongDao.update(onglets);
			response.sendRedirect("Onglet");
		}
		if(request.getParameter("idTariffUpdated")!=null) {
			int idTariffUpdated = Integer.parseInt(request.getParameter("idTariffUpdated"));
			int idVehicule = Integer.parseInt(request.getParameter("idVehicule"));
			Double mbela = Double.parseDouble(request.getParameter("prixJour"));
			
			Vehicule vehi = new Vehicule();
			vehi.setIdVehicule(idVehicule);
			
			Tarifs editTarif = new Tarifs(idTariffUpdated,vehi,mbela);
			
			tarifDao.update(editTarif);
			response.sendRedirect("Tarif");
		}
		if(request.getParameter("idLocation")!=null) {
			int idLocation = Integer.parseInt(request.getParameter("idLocation"));
			int idUser = Integer.parseInt(request.getParameter("users"));
			int idVehicule = Integer.parseInt(request.getParameter("vehicules"));
			int idTarif = Integer.parseInt(request.getParameter("tarifs"));
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
			
			Location location = new Location(idLocation,user,vehicule,debut,fin,nbreJour,mbela,priseEnCharge);
			
			locDao.update(location);
			response.sendRedirect("Locations");
		}
		if(request.getParameter("idVehiUpdated")!=null) {
			int idUpdate = Integer.parseInt(request.getParameter("idVehiUpdated"));
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
			Part file=request.getPart("image");
			

		
			String filename = file.getSubmittedFileName();

			System.out.println(filename);

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
			String description = request.getParameter("description");
			Boolean isPromo = Boolean.parseBoolean(request.getParameter("isPromo"));
			Boolean approved = Boolean.parseBoolean(request.getParameter("approved"));
			int partDispo = Integer.parseInt(request.getParameter("partDispo"));
			Boolean forRent = Boolean.parseBoolean(request.getParameter("forRent"));
			String available = request.getParameter("availability");
			Vehicule newVehicule = new Vehicule(idUpdate,marque, modele, prix, emplacement, siege, etat, oneOff, couleur, energy, miles, year, mechanic, interieur, filename,filename1,filename2,filename3,description,isPromo,approved,partDispo,forRent,available);
			vehiDao.update(newVehicule);
			response.sendRedirect("Auto");
		}
		if(request.getParameter("idPostUpdadted")!=null) {
			int idPostUpdated = Integer.parseInt(request.getParameter("idPostUpdated"));
		String titre = request.getParameter("titre");
		String resume = request.getParameter("resume");
		String contenu = request.getParameter("contenu");
		String auteur = request.getParameter("auteur");
		
		
		
		 
				Part fil=request.getPart("image");
				

				
				String filenam = fil.getSubmittedFileName();

				System.out.println(filenam);

				
				String uploadPat="C:\\Users\\moi\\Desktop\\eclipse-workspace\\METWA\\src\\main\\webapp\\voitures\\"+filenam;  // Destination

				
				try
				{
				
					FileOutputStream fos=new FileOutputStream(uploadPat);
					InputStream is=fil.getInputStream();
					
					byte[] data=new byte[is.available()];
					is.read(data);
					fos.write(data);
					fos.close();
				
				}
				
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
		Post newPost = new Post( idPostUpdated,titre, resume, contenu, auteur, filenam);
		postDao.update(newPost);
		}
		
		if(request.getParameter("idUser")!=null) {
			
			int idUser = Integer.parseInt(request.getParameter("idUser"));
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			int statut = Integer.parseInt(request.getParameter("statut"));
			
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

			System.out.println(filename);

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
			
			Boolean isVisible = Boolean.parseBoolean(request.getParameter("isVisible"));
			User newUser = new User( idUser,nom, prenom, statut, email,age,telephone,mdp,adresse,date1,isVisible,permis,filename4);
			
			System.out.println(newUser);
			userDao.update(newUser);
		}
	}

	}}
