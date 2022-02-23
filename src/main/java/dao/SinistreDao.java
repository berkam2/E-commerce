package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.Connect.GetConnection;
import modele.Location;
import modele.Sinistre;
import modele.User;
import modele.Vehicule;

public class SinistreDao implements IDAO<Sinistre> {
Connection connect = GetConnection.getConnection();
	
	VehiculeDao vehiDao = new VehiculeDao();
	TarifsDao tarifDao = new TarifsDao();
	UserDao usDao = new UserDao();

	@Override
	public boolean create(Sinistre Object) {
		// TODO Auto-generated method stub
		boolean msg = false;
		PreparedStatement req;
		try {
			req = connect.prepareStatement("INSERT INTO sinistre (id_user,id_vehicule,description,date,id_location)"
					+ " VALUES (?,?,?,?,?)");
			req.setInt(1, Object.getUser().getIdUser());
			req.setInt(2, Object.getVoiture().getIdVehicule());
			req.setString(3, Object.getDescription());
			req.setString(4, Object.getDate());
			req.setInt(5, Object.getLocation().getIdLocation());
			
			
			
			
			req.executeUpdate();
			
			
			msg = true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Insertion KO");
		}
		return msg;
	}

	@Override
	public List<Sinistre> read() {
		// TODO Auto-generated method stub
List<Sinistre> listeSinistre = new ArrayList<>();
		
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM sinistre as loc "
					+ "JOIN vehicule as vehi ON loc.id_vehicule = vehi.id_vehicule "
					+ "JOIN user as us ON loc.id_user=us.id_user JOIN location as tf ON tf.id_location=loc.id_location");
			
			ResultSet rs = req.executeQuery();
			
			while(rs.next()) {
				User us = new User(rs.getInt("id_user"), rs.getString("nom"),rs.getString("prenom"),rs.getInt("id_statut"),
            			rs.getString("email"),rs.getInt("age"),rs.getString("telephone"),rs.getString("mdp"),
            			rs.getString("adresse"),rs.getString("obtentionPermis"),rs.getDate("inscription"),
            			rs.getBoolean("isVisible"),rs.getString("permis"),rs.getString("image"));
		
				Location location = new Location(rs.getInt("id_location"),usDao.findById(rs.getInt("id_user")),vehiDao.findById(rs.getInt("id_vehicule")),rs.getString("depart"),rs.getString("retour"),rs.getInt("nbreJour"),tarifDao.findById(rs.getInt("id_tarif")),rs.getString("lieuLivraison"));
				
				Sinistre sinistre = new Sinistre(rs.getInt("id_sinistre"),us,vehiDao.findById(rs.getInt("id_vehicule")),location,rs.getString("date"),rs.getString("description"));
				
				listeSinistre.add(sinistre);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Insertion KO - KO - KO");
		}
		
		return listeSinistre;

		
	}

	@Override
	public Boolean update(Sinistre Object) {
		// TODO Auto-generated method stub
		boolean msg = false;
		try {
			PreparedStatement req = connect.prepareStatement("UPDATE sinistre SET id_user=?,id_vehicule=?, "
					+ "description=?,date=?,id_location=?"
					+ " WHERE id_sinistre=?");
			req.setInt(1, Object.getUser().getIdUser());
			req.setInt(2, Object.getVoiture().getIdVehicule());
			req.setString(3, Object.getDescription());
			req.setString(4, Object.getDate());
			req.setInt(5, Object.getLocation().getIdLocation());
			req.setInt(6, Object.getIdSinistre());
			
			
			req.executeUpdate();
			
			System.out.println( "Le sinistre" + Object.getIdSinistre()+"de l'utilisateur"+Object.getUser().getNom()+ " a été bien été updaté en base");
			msg = true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Insertion KO");
		}
		return msg;
	}

	
	public Sinistre findById(int id) {
		Sinistre sinistre = null;
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM sinistre as sin"
					+ "JOIN vehicule as vehi ON sin.id_vehicule = vehi.id_vehicule "
					+ "JOIN user as us ON sin.id_user = us.id_user JOIN location as loc ON loc.id_location=sin.id_location"
					+ "WHERE id_sinistre=?");
			req.setInt(1, id);
			
			ResultSet rs = req.executeQuery();
			
			if(rs.next()) {
				
				User us = usDao.findById(rs.getInt("id_user"));
				
				Vehicule vehi = vehiDao.findById(rs.getInt("id_vehicule"));
		
				Location location = new Location(rs.getInt("id_location"),usDao.findById(rs.getInt("id_user")),vehiDao.findById(rs.getInt("id_vehicule")),rs.getString("depart"),rs.getString("retour"),rs.getInt("nbreJour"),tarifDao.findById(rs.getInt("id_tarif")),rs.getString("lieuLivraison"));
				
				sinistre = new Sinistre(rs.getInt("id_sinistre"),us,vehi,location,rs.getString("date"),rs.getString("description"));
						
			}
			System.out.println(sinistre);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("aaaaa KO - KO - KO");
		}
		return sinistre;
	}
	@Override
	public Boolean delete(Sinistre Object) {
		// TODO Auto-generated method stub
		return false;
	}

	public Object findUser(int idJoueur) {
		// TODO Auto-generated method stub
List<Sinistre> listeSinistre = new ArrayList<>();
		
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM sinistre WHERE id_user=?");
			
			req.setInt(1, idJoueur);
			ResultSet rs = req.executeQuery();
			
			while(rs.next()) {
				User us = usDao.findById(idJoueur);
		
				Location location = new Location(rs.getInt("id_location"),usDao.findById(rs.getInt("id_user")),vehiDao.findById(rs.getInt("id_vehicule")),rs.getString("depart"),rs.getString("retour"),rs.getInt("nbreJour"),tarifDao.findById(rs.getInt("id_tarif")),rs.getString("lieuLivraison"));
				
				Sinistre sinistre = new Sinistre(rs.getInt("id_sinistre"),us,vehiDao.findById(rs.getInt("id_vehicule")),location,rs.getString("date"),rs.getString("description"));
				
				listeSinistre.add(sinistre);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Insertion KO - KO - KO");
		}
		
		return listeSinistre;
	}

}
