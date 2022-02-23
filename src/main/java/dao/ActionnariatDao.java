package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.Connect.GetConnection;
import modele.Actionnariats;
import modele.User;
import modele.Vehicule;



public class ActionnariatDao implements IDAO <Actionnariats>{
	Connection connect = GetConnection.getConnection();
	UserDao usDao = new UserDao();
	VehiculeDao vehiDao = new VehiculeDao();
	@Override
	public boolean create(Actionnariats Object) {
		// TODO Auto-generated method stub
		boolean msg = false;
		try {
			PreparedStatement req = connect.prepareStatement("INSERT INTO actionnariat (id_user,id_vehicule,part)"
					+ " VALUES (?,?,?)");
			req.setInt(1, Object.getUtilisateur().getIdUser());
			req.setInt(2, Object.getVoiture().getIdVehicule());
			req.setInt(3, Object.getPart());
			
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
	public List<Actionnariats> read() {
		// TODO Auto-generated method stub
List<Actionnariats> listeAction = new ArrayList<>();
		
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM actionnariat as assoc "
					+ "JOIN vehicule as v ON assoc.id_vehicule = v.id_vehicule "
					+ "JOIN user as u ON u.id_user = assoc.id_user");
			;
			
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
				
				Actionnariats action = new Actionnariats(rs.getInt("id_actionnariat"),us,vehi,rs.getInt("part"),rs.getInt("availableDay"),rs.getDate("date"));
				
				listeAction.add(action);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Insertion KO - KO - KO");
		}
		
		
		return listeAction;
	}

	@Override
	public Boolean update(Actionnariats Object) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public Boolean delete(Actionnariats Object) {
		// TODO Auto-generated method stub
		return false;
	}

	public Object findUser(int idJoueur) {
		// TODO Auto-generated method stub
List<Actionnariats> listeAction = new ArrayList<>();
		
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM actionnariat WHERE id_user=?");
			req.setInt(1,idJoueur);		
			ResultSet rs = req.executeQuery();
			
			while(rs.next()) {
				User us = usDao.findById(rs.getInt("id_user"));
				
				Vehicule vehi = vehiDao.findById(rs.getInt("id_vehicule"));
				
				Actionnariats action = new Actionnariats(rs.getInt("id_actionnariat"),us,vehi,rs.getInt("part"),rs.getInt("availableDay"),rs.getDate("date"));
				
				listeAction.add(action);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Insertion KO - KO - KO");
		}
		
		
		return listeAction;
	}

}
