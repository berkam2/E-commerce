package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.Connect.GetConnection;

import modele.Rdv;

import modele.User;
import modele.Vehicule;

public class RdvDao implements IDAO<Rdv> {

	Connection connect = GetConnection.getConnection();
	UserDao userDao = new UserDao();
	VehiculeDao vehiDao = new VehiculeDao();
	UserDao usDao = new UserDao();
	
	@Override
	public boolean create(Rdv Object) {
		// TODO Auto-generated method stub
		boolean msg = false;
		PreparedStatement req;
		try {
			req = connect.prepareStatement("INSERT INTO calendrier (id_user,id_vehicule,date,heure,)"
					+ " VALUES (?,?,?,?)");
			req.setInt(1, Object.getUser().getIdUser());
			req.setInt(2, Object.getVoiture().getIdVehicule());
			req.setString(3, Object.getDate());
			req.setString(4, Object.getHeure());
			
			
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
	public List<Rdv> read() {
		// TODO Auto-generated method stub
List<Rdv> listeRdv = new ArrayList<>();
		
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM calendrier as cal"
					+ "JOIN vehicule as vehi ON cal.id_vehicule = vehi.id_vehicule "
					+ "JOIN user as us ON cal.id_user = us.id_user");
			
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
		
				Rdv rdv = new Rdv(us,vehi,rs.getString("date"),rs.getString("heure"));
				listeRdv.add(rdv);
				
			}
			;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Insertion KO - KO - KO");
		}
		
		return listeRdv;

	}

	@Override
	public Boolean update(Rdv Object) {
		// TODO Auto-generated method stub
		boolean msg = false;
		try {
			PreparedStatement req = connect.prepareStatement("UPDATE calendrier SET id_user=?,id_vehicule=?, "
					+ "date=?,heure=?"
					+ " WHERE id_rdv=?");
			req.setInt(1, Object.getUser().getIdUser());
			req.setInt(2, Object.getVoiture().getIdVehicule());
			req.setString(3, Object.getDate());
			req.setString(4, Object.getHeure());
			req.setInt(5, Object.getIdRdv());
			
			
			req.executeUpdate();
			
			System.out.println( "Le sinistre" + Object.getIdRdv()+"de l'utilisateur"+Object.getUser().getNom()+ " a bien été updaté en base");
			msg = true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Insertion KO");
		}
		return msg;
	}

	@Override
	public Boolean delete(Rdv Object) {
		// TODO Auto-generated method stub
		return false;
	}

	public Object findUser(int idJoueur) {
		// TODO Auto-generated method stub
List<Rdv> listeRdv = new ArrayList<>();
		
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM calendrier  WHERE id_user=?");
			req.setInt(1, idJoueur);
			//System.out.println(req);
			
			ResultSet rs = req.executeQuery();
			
			while(rs.next()) {
				User us = usDao.findById(rs.getInt("id_user"));
				
				Vehicule vehi = vehiDao.findById(rs.getInt("id_vehicule"));
		
				Rdv rdv = new Rdv(us,vehi,rs.getString("date"),rs.getString("heure"));
				listeRdv.add(rdv);
				
			}
			;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Insertion KO - KO - KO");
		}
		
		return listeRdv;
	}

}
