package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.Connect.GetConnection;
import modele.Location;
import modele.Tarifs;
import modele.User;
import modele.Vehicule;


public class LocationDao implements IDAO<Location>{
	Connection connect = GetConnection.getConnection();
	VehiculeDao vehiDao = new VehiculeDao();
	TarifsDao tarifDao = new TarifsDao();
	UserDao usDao = new UserDao();
	@Override
	public boolean create(Location Object) {
		// TODO Auto-generated method stub
		boolean msg = false;
		PreparedStatement req;
		try {
			req = connect.prepareStatement("INSERT INTO location (depart,retour,lieuLivraison,id_user,id_vehicule,id_tarif,nbreJour)"
					+ " VALUES (?,?,?,?,?,?,?)");
			req.setString(1, Object.getDebut());
			req.setInt(4, Object.getUser().getIdUser());
			req.setInt(5, Object.getVoiture().getIdVehicule());
			req.setString(2, Object.getFin());
			req.setInt(6, Object.getMbela().getIdTariff());
			req.setString(3, Object.getPriseEnCharge());
			req.setInt(7, Object.getNbreJour());
			
			
			
			req.executeUpdate();
			
			System.out.println(Object);
			msg = true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Insertion KO");
		}
		return msg;
		
		
	}

	@Override
	public List<Location> read() {
		// TODO Auto-generated method stub
List<Location> listeLocation = new ArrayList<>();
		
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM location as loc "
					+ "JOIN vehicule as vehi ON loc.id_vehicule = vehi.id_vehicule "
					+ "JOIN user as us ON loc.id_user=us.id_user JOIN tarif as tf ON tf.id_tarif=loc.id_tarif");
			//System.out.println(req);
			
			ResultSet rs = req.executeQuery();
			
			while(rs.next()) {
				User us = new User(rs.getInt("id_user"), rs.getString("nom"),rs.getString("prenom"),rs.getInt("id_statut"),
            			rs.getString("email"),rs.getInt("age"),rs.getString("telephone"),rs.getString("mdp"),
            			rs.getString("adresse"),rs.getString("obtentionPermis"),rs.getDate("inscription"),
            			rs.getBoolean("isVisible"),rs.getString("permis"),rs.getString("image"));
				
				Vehicule vehi = new Vehicule(rs.getInt("id_vehicule"),rs.getString("marque"),rs.getString("modele"),rs.getDouble("prix"),rs.getString("emplacement"),
						rs.getInt("siege"),rs.getBoolean("etat"),rs.getBoolean("oneOff"),rs.getString("color"),
						rs.getString("energy"),rs.getInt("miles"),rs.getInt("year"),rs.getString("mechanic"),
						rs.getString("interieur"),rs.getString("image"),rs.getString("image1"),rs.getString("image3"),rs.getString("image3"),rs.getString("description"),rs.getBoolean("isPromo"),
						rs.getBoolean("approved"),rs.getInt("partDispo"),rs.getBoolean("forRent"),rs.getString("availability"));
				
				Tarifs tf = new Tarifs(rs.getInt("id_tarif"),vehiDao.findById(rs.getInt("id_vehicule")),rs.getDouble("mbela"));
				
				Location location = new Location(rs.getInt("id_location"),us,vehi,rs.getString("depart"),rs.getString("retour"),rs.getInt("nbreJour"),tf,rs.getString("lieuLivraison"));
				
				listeLocation.add(location);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Insertion KO - KO - KO");
		}
		
		;
		return listeLocation;
		
	}

	@Override
	public Boolean update(Location Object) {
		// TODO Auto-generated method stub
				boolean msg = false;
				try {
					PreparedStatement req = connect.prepareStatement("UPDATE location SET depart=?,retour=?, "
							+ "id_user=?,id_vehicule=?,id_tarif=?,nbreJour=?,lieuLivraison=?"
							+ " WHERE id_location=?");
					req.setString(1, Object.getDebut());
					req.setString(2, Object.getFin());
					req.setInt(3, Object.getUser().getIdUser());
					req.setInt(4, Object.getVoiture().getIdVehicule());
					req.setInt(5, Object.getMbela().getIdTariff());
					req.setInt(6, Object.getNbreJour());
					req.setString(7, Object.getPriseEnCharge());
					req.setInt(8, Object.getIdLocation());
					
					
					req.executeUpdate();
					
					System.out.println( "La location" + Object.getIdLocation()+"de l'utilisateur"+Object.getUser().getNom()+ " a été bien été updaté en base");
					msg = true;
					
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Insertion KO");
				}
				return msg;
			}
		

	@Override
	public Boolean delete(Location Object) {
		// TODO Auto-generated method stub
		return false;
	}

	public Location findById(int id) {
		Location location = null;
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM location as loc "
					+ "JOIN vehicule as vehi ON loc.id_vehicule = vehi.id_vehicule "
					+ "JOIN user as us ON loc.id_user=us.id_user JOIN tarif as tf ON tf.id_tarif=loc.id_tarif WHERE id_location=?");
			req.setInt(1, id);
			
			ResultSet rs = req.executeQuery();
			
			if(rs.next()) {
				
				User us = new User(rs.getInt("id_user"), rs.getString("nom"),rs.getString("prenom"),rs.getInt("id_statut"),
            			rs.getString("email"),rs.getInt("age"),rs.getString("telephone"),rs.getString("mdp"),
            			rs.getString("adresse"),rs.getString("obtentionPermis"),rs.getDate("inscription"),
            			rs.getBoolean("isVisible"),rs.getString("permis"),rs.getString("image"));
				
				Vehicule vehi = new Vehicule(rs.getInt("id_vehicule"),rs.getString("marque"),rs.getString("modele"),rs.getDouble("prix"),rs.getString("emplacement"),
						rs.getInt("siege"),rs.getBoolean("etat"),rs.getBoolean("oneOff"),rs.getString("color"),
						rs.getString("energy"),rs.getInt("miles"),rs.getInt("year"),rs.getString("mechanic"),
						rs.getString("interieur"),rs.getString("image"),rs.getString("image1"),rs.getString("image3"),rs.getString("image3"),rs.getString("description"),rs.getBoolean("isPromo"),
						rs.getBoolean("approved"),rs.getInt("partDispo"),rs.getBoolean("forRent"),rs.getString("availability"));
		
				location = new Location(rs.getInt("id_location"),us,vehi,rs.getString("depart"),rs.getString("retour"),rs.getInt("nbreJour"),tarifDao.findById(rs.getInt("id_tarif")),rs.getString("lieuLivraison"));

						
			}
			System.out.println(location);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("aaaaa KO - KO - KO");
		}
		return location;

}

	public Object findUser(int idJoueur) {
		// TODO Auto-generated method stub
List<Location> listeLocation = new ArrayList<>();
		
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM location WHERE id_user=?");
			//System.out.println(req);
			
			req.setInt(1, idJoueur);
			ResultSet rs = req.executeQuery();
			
			while(rs.next()) {
				User us = usDao.findById(rs.getInt("id_user"));
				
				Vehicule vehi = vehiDao.findById(rs.getInt("id_vehicule"));
				
				Tarifs tf = tarifDao.findById(rs.getInt("id_tariff"));
				
				Location location = new Location(rs.getInt("id_location"),us,vehi,rs.getString("depart"),rs.getString("retour"),rs.getInt("nbreJour"),tf,rs.getString("lieuLivraison"));
				
				listeLocation.add(location);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Insertion KO - KO - KO");
		}
		
		;
		return listeLocation;
	}
}
