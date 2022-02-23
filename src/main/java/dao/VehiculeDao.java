package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.Connect.GetConnection;
import modele.Post;
import modele.Vehicule;

public class VehiculeDao implements IDAO<Vehicule>{

	Connection connect = GetConnection.getConnection();
	
	public Vehicule findById(int id) {
		Vehicule vehicule =null;
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM vehicule WHERE id_vehicule=?");
			req.setInt(1, id);
			
			ResultSet rs = req.executeQuery();
			
			if(rs.next()) {
				
				vehicule =  new Vehicule(rs.getInt("id_vehicule"),rs.getString("marque"),rs.getString("modele"),rs.getDouble("prix"),rs.getString("emplacement"),
						rs.getInt("siege"),rs.getBoolean("etat"),rs.getBoolean("oneOff"),rs.getString("color"),
						rs.getString("energy"),rs.getInt("miles"),rs.getInt("year"),rs.getString("mechanic"),
						rs.getString("interieur"),rs.getString("image"),rs.getString("image1"),rs.getString("image2"),rs.getString("image3"),rs.getString("description"),rs.getBoolean("isPromo"),
						rs.getBoolean("approved"),rs.getInt("partDispo"),rs.getBoolean("forRent"),rs.getString("availability"));
			}
			System.out.println(vehicule);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("aaaaa KO - KO - KO");
		}
		return vehicule;
	}
	@Override
	public boolean create(Vehicule Object) {
		// TODO Auto-generated method stub
			boolean message = false;
			try {
				
				PreparedStatement req = connect.prepareStatement("INSERT INTO vehicule"
						+ "(marque, modele, prix, emplacement, siege, etat, oneOff, color, energy, miles, year,"
						+ " mechanic, interieur, image, image1, image2, image3, description,approved,partDispo,forRent,availability) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
				
				req.setString(1, Object.getMarque());
				req.setString(2, Object.getModele());
				req.setDouble(3, Object.getPrice());
				req.setString(4, Object.getEmplacement());
				req.setInt(5, Object.getSiege());
				req.setBoolean(6, Object.isEtat());
				req.setBoolean(7, Object.isOneOff());
				req.setString(8,  Object.getColor());
				req.setString(9,  Object.getEnergy());
				req.setInt(10, Object.getMiles());
				req.setInt(11, Object.getYear());
				req.setString(12, Object.getMechanic());
				req.setString(13,  Object.getInterieur());
				req.setObject(14, Object.getImage());
				req.setObject(15, Object.getImage1());
				req.setObject(16, Object.getImage2());
				req.setObject(17, Object.getImage3());
				req.setString(18, Object.getDescription());
				req.setBoolean(19, Object.isApproved());
				req.setInt(20, Object.getPartDispo());
				req.setBoolean(21, Object.isForRent());
				req.setString(22, Object.getAvailability());
				
				req.executeUpdate();
				message = true;
				System.out.println("Le véhicule "+Object.getMarque()+ " " + Object.getModele()+" a été ajouté");
				
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("Vehicule Insertion KO - KO - KO");
				
			}
			return message;
		
	}

	@Override
	public List<Vehicule> read() {
		// TODO Auto-generated method stub
List<Vehicule> listeVehicule = new ArrayList<>();
		
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM vehicule");
			
			
			ResultSet rs = req.executeQuery();
			
			while(rs.next()) {
				Vehicule vehicule = new Vehicule();
				
				vehicule.setIdVehicule(rs.getInt("id_vehicule"));
				vehicule.setMarque(rs.getString("marque"));
				vehicule.setModele(rs.getString("modele"));
				vehicule.setPrice(rs.getDouble("prix"));
				vehicule.setEmplacement(rs.getString("emplacement"));
				vehicule.setSiege(rs.getInt("siege"));
				vehicule.setEtat(rs.getBoolean("etat"));
				vehicule.setOneOff(rs.getBoolean("oneOff"));
				vehicule.setColor(rs.getString("color"));
				vehicule.setEnergy(rs.getString("energy"));
				vehicule.setMiles(rs.getInt("miles"));
				vehicule.setYear(rs.getInt("year"));
				vehicule.setMechanic(rs.getString("mechanic"));
				vehicule.setInterieur(rs.getString("interieur"));
				vehicule.setImage(rs.getString("image"));
				vehicule.setImage1(rs.getString("image1"));
				vehicule.setImage2(rs.getString("image2"));
				vehicule.setImage3(rs.getString("image3"));
				vehicule.setDescription(rs.getString("description"));
				vehicule.setPromo(rs.getBoolean("isPromo"));
				vehicule.setApproved(rs.getBoolean("approved"));
				vehicule.setPartDispo(rs.getInt("partDispo"));
				vehicule.setForRent(rs.getBoolean("forRent"));
				vehicule.setAvailability(rs.getString("availability"));
				
				listeVehicule.add(vehicule);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Insertion KO - KO - KO");
		}
		return listeVehicule;
	}
	
	public List<Vehicule> approuved() {
		// TODO Auto-generated method stub
List<Vehicule> listeVehicule = new ArrayList<>();
		
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM vehicule WHERE approved=?");
			req.setInt(1, 1);
			
			ResultSet rs = req.executeQuery();
			
			while(rs.next()) {
				Vehicule vehicule = new Vehicule();
				
				vehicule.setIdVehicule(rs.getInt("id_vehicule"));
				vehicule.setMarque(rs.getString("marque"));
				vehicule.setModele(rs.getString("modele"));
				vehicule.setPrice(rs.getDouble("prix"));
				vehicule.setEmplacement(rs.getString("emplacement"));
				vehicule.setSiege(rs.getInt("siege"));
				vehicule.setEtat(rs.getBoolean("etat"));
				vehicule.setOneOff(rs.getBoolean("oneOff"));
				vehicule.setColor(rs.getString("color"));
				vehicule.setEnergy(rs.getString("energy"));
				vehicule.setMiles(rs.getInt("miles"));
				vehicule.setYear(rs.getInt("year"));
				vehicule.setMechanic(rs.getString("mechanic"));
				vehicule.setInterieur(rs.getString("interieur"));
				vehicule.setImage(rs.getString("image"));
				vehicule.setImage1(rs.getString("image1"));
				vehicule.setImage2(rs.getString("image2"));
				vehicule.setImage3(rs.getString("image3"));
				vehicule.setDescription(rs.getString("description"));
				vehicule.setPromo(rs.getBoolean("isPromo"));
				vehicule.setApproved(rs.getBoolean("approved"));
				vehicule.setPartDispo(rs.getInt("partDispo"));
				vehicule.setForRent(rs.getBoolean("forRent"));
				vehicule.setAvailability(rs.getString("availability"));
				
				listeVehicule.add(vehicule);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Insertion KO - KO - KO");
		}
		return listeVehicule;
	}

	@Override
	public Boolean update(Vehicule Object) {
		// TODO Auto-generated method stub

		boolean msg = false;
		try {
			PreparedStatement req = connect.prepareStatement("UPDATE vehicule SET marque=?,"
					+ "modele=?, prix=?, emplacement=?, "
					+ "siege=?, etat=?, oneOff=?, color=?, energy=?, miles=?, year=?,"
					+ "	 mechanic=?, interieur=?, image=?, image1=?, image2=?, image3=?, description=?,isPromo=?, approved=?,"
					+ "partDispo=?,forRent=?, availability=?"
					+ " WHERE id_vehicule=?");
			req.setString(1, Object.getMarque());
			req.setString(2, Object.getModele());
			req.setDouble(3, Object.getPrice());
			req.setString(4, Object.getEmplacement());
			req.setInt(5, Object.getSiege());
			req.setBoolean(6, Object.isEtat());
			req.setBoolean(7, Object.isOneOff());
			req.setString(8,  Object.getColor());
			req.setString(9,  Object.getEnergy());
			req.setInt(10, Object.getMiles());
			req.setInt(11, Object.getYear());
			req.setString(12, Object.getMechanic());
			req.setString(13,  Object.getInterieur());
			req.setObject(14,Object.getImage());
			req.setObject(15,Object.getImage1());
			req.setObject(16,Object.getImage2());
			req.setObject(17,Object.getImage3());
			req.setString(18, Object.getDescription());
			req.setBoolean(19, Object.isPromo());
			req.setBoolean(20, Object.isApproved());
			req.setInt(21, Object.getPartDispo());
			req.setBoolean(22, Object.isForRent());
			
			req.setString(23, Object.getAvailability());
			req.setInt(24, Object.getIdVehicule());
			
			req.executeUpdate();
			
			System.out.println( Object.getMarque()+ " a été bien updaté en base");
			msg = true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Insertion KO");
		}
		return msg;
	}

	public List<Vehicule> isPromo() {
		// TODO Auto-generated method stub
List<Vehicule> listePromo = new ArrayList<>();
		
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM vehicule WHERE isPromo=1");
			
			ResultSet rs = req.executeQuery();
			
			while(rs.next()) {
				Vehicule vehicule = new Vehicule();
				
				vehicule.setIdVehicule(rs.getInt("id_vehicule"));
				vehicule.setMarque(rs.getString("marque"));
				vehicule.setModele(rs.getString("modele"));
				vehicule.setPrice(rs.getDouble("prix"));
				vehicule.setEmplacement(rs.getString("emplacement"));
				vehicule.setSiege(rs.getInt("siege"));
				vehicule.setEtat(rs.getBoolean("etat"));
				vehicule.setOneOff(rs.getBoolean("oneOff"));
				vehicule.setColor(rs.getString("color"));
				vehicule.setEnergy(rs.getString("energy"));
				vehicule.setMiles(rs.getInt("miles"));
				vehicule.setYear(rs.getInt("year"));
				vehicule.setMechanic(rs.getString("mechanic"));
				vehicule.setInterieur(rs.getString("interieur"));
				vehicule.setImage(rs.getString("image"));
				vehicule.setImage1(rs.getString("image1"));
				vehicule.setImage2(rs.getString("image2"));
				vehicule.setImage3(rs.getString("image3"));
				vehicule.setDescription(rs.getString("description"));
				vehicule.setPromo(rs.getBoolean("isPromo"));
				vehicule.setAvailability(rs.getString("availability"));
				listePromo.add(vehicule);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Insertion KO - KO - KO");
		}
		return listePromo;
	}

	@Override
	public Boolean delete(Vehicule Object) {
		// TODO Auto-generated method stub
		boolean msg = false;
		try {
			PreparedStatement req = connect.prepareStatement("DELETE FROM vehicule"
					+ " WHERE id_vehicule=?");
			req.setInt(1, Object.getIdVehicule());
			
			
			req.executeUpdate();
			
			
			msg = true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Insertion KO");
		}
		return msg;
	}
	public Object forSale() {
		// TODO Auto-generated method stub
List<Vehicule> listeForSale = new ArrayList<>();
		
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM vehicule WHERE partDispo>0 AND approved=1");
			
			ResultSet rs = req.executeQuery();
			
			while(rs.next()) {
				Vehicule vehicule = new Vehicule();
				
				vehicule.setIdVehicule(rs.getInt("id_vehicule"));
				vehicule.setMarque(rs.getString("marque"));
				vehicule.setModele(rs.getString("modele"));
				vehicule.setPrice(rs.getDouble("prix"));
				vehicule.setEmplacement(rs.getString("emplacement"));
				vehicule.setSiege(rs.getInt("siege"));
				vehicule.setEtat(rs.getBoolean("etat"));
				vehicule.setOneOff(rs.getBoolean("oneOff"));
				vehicule.setColor(rs.getString("color"));
				vehicule.setEnergy(rs.getString("energy"));
				vehicule.setMiles(rs.getInt("miles"));
				vehicule.setYear(rs.getInt("year"));
				vehicule.setMechanic(rs.getString("mechanic"));
				vehicule.setInterieur(rs.getString("interieur"));
				vehicule.setImage(rs.getString("image"));
				vehicule.setImage1(rs.getString("image1"));
				vehicule.setImage2(rs.getString("image2"));
				vehicule.setImage3(rs.getString("image3"));
				vehicule.setDescription(rs.getString("description"));
				vehicule.setPromo(rs.getBoolean("isPromo"));
				vehicule.setAvailability(rs.getString("availability"));
				listeForSale.add(vehicule);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Insertion KO - KO - KO");
		}
		return listeForSale;
	}
	public Object forRent() {
		// TODO Auto-generated method stub
List<Vehicule> listeForRent = new ArrayList<>();
		
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM vehicule WHERE forRent=1 AND approved=1");
			
			ResultSet rs = req.executeQuery();
			
			while(rs.next()) {
				Vehicule vehicule = new Vehicule();
				
				vehicule.setIdVehicule(rs.getInt("id_vehicule"));
				vehicule.setMarque(rs.getString("marque"));
				vehicule.setModele(rs.getString("modele"));
				vehicule.setPrice(rs.getDouble("prix"));
				vehicule.setEmplacement(rs.getString("emplacement"));
				vehicule.setSiege(rs.getInt("siege"));
				vehicule.setEtat(rs.getBoolean("etat"));
				vehicule.setOneOff(rs.getBoolean("oneOff"));
				vehicule.setColor(rs.getString("color"));
				vehicule.setEnergy(rs.getString("energy"));
				vehicule.setMiles(rs.getInt("miles"));
				vehicule.setYear(rs.getInt("year"));
				vehicule.setMechanic(rs.getString("mechanic"));
				vehicule.setInterieur(rs.getString("interieur"));
				vehicule.setImage(rs.getString("image"));
				vehicule.setImage1(rs.getString("image1"));
				vehicule.setImage2(rs.getString("image2"));
				vehicule.setImage3(rs.getString("image3"));
				vehicule.setDescription(rs.getString("description"));
				vehicule.setPromo(rs.getBoolean("isPromo"));
				vehicule.setAvailability(rs.getString("availability"));
				listeForRent.add(vehicule);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Insertion KO - KO - KO");
		}
		return listeForRent;
	}
	public Boolean reducePart(int parts,Vehicule Object) {
		// TODO Auto-generated method stub
		boolean msg = false;
		try {
			PreparedStatement req = connect.prepareStatement("UPDATE vehicule SET partDispo=? WHERE id_vehicule=?");
			req.setInt(1, parts);
			
			req.setInt(2, Object.getIdVehicule());
			
			req.executeUpdate();
			
			System.out.println( Object.getMarque()+ " a été bien updaté en base");
			msg = true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Insertion KO");
		}
		return msg;
	}
	public Boolean approuve(Vehicule Object) {
		// TODO Auto-generated method stub
		boolean msg = false;
		try {
			PreparedStatement req = connect.prepareStatement("UPDATE vehicule SET approved=? WHERE id_vehicule=?");
			req.setInt(1, 1);
			
			req.setInt(2, Object.getIdVehicule());
			
			req.executeUpdate();
			
			System.out.println( Object.getMarque()+ " a été bien updaté en base");
			msg = true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Insertion KO");
		}
		return msg;
	}
	

}
