package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.Connect.GetConnection;
import modele.Garage;
import modele.Sinistre;
import modele.Vehicule;


public class GarageDao implements IDAO<Garage> {

Connection connect = GetConnection.getConnection();
	
	VehiculeDao vehiDao = new VehiculeDao();
	SinistreDao sinDao = new SinistreDao();
	UserDao userDao = new UserDao();
	LocationDao locDao = new LocationDao();
	

	@Override
	public boolean create(Garage Object) {
		// TODO Auto-generated method stub
		boolean msg = false;
		PreparedStatement req;
		try {
			req = connect.prepareStatement("INSERT INTO garage (intervention,date_entree,date_sortie,id_sinistre,cout)"
					+ " VALUES (?,?,?,?,?)");
			req.setString(1, Object.getIntervention());
			req.setString(2, Object.getEntree());
			req.setString(3, Object.getSortie());
			req.setInt(4, Object.getSinistre().getIdSinistre());
			req.setDouble(5, Object.getCout());
			req.executeUpdate();
			
			
			msg = true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Insertion KO");
		}
		return msg;
	}

	@Override
	public List<Garage> read() {
		// TODO Auto-generated method stub
List<Garage> listeGarage = new ArrayList<>();
		
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM garage as gar "
					+ "JOIN sinistre as s ON gar.id_sinistre = s.id_sinistre ");
			
			ResultSet rs = req.executeQuery();
			
			while(rs.next()) {
				
				Vehicule vehi = vehiDao.findById(rs.getInt("id_vehicule"));
				Sinistre sinistre = new Sinistre(rs.getInt("id_sinistre"),userDao.findById(rs.getInt("id_user")),vehi,locDao.findById(rs.getInt("id_location")),rs.getString("date"),rs.getString("description"));
				Garage garage = new Garage(rs.getInt("id_garage"),sinistre,rs.getDouble("cout"),rs.getString("intervention"),rs.getString("date_entree"),rs.getString("date_sortie"));
				listeGarage.add(garage);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Insertion KO - KO - KO");
		}
		
		;
		return listeGarage;

		
	}

	@Override
	public Boolean update(Garage Object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Garage Object) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
