package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Connect.GetConnection;
import modele.Actionnariats;
import modele.Statut;
import modele.Tarifs;
import modele.User;
import modele.Vehicule;

public class TarifsDao implements IDAO<Tarifs> {
Connection connect = GetConnection.getConnection();
	
	@Override
	public boolean create(Tarifs Object) {
		// TODO Auto-generated method stub
		boolean msg = false;
		PreparedStatement sql;
		try {
			sql = connect.prepareStatement("INSERT INTO tarif (id_vehicule,mbela) VALUES (?,?)");
			
		
		sql.setInt(1, Object.getVoiture().getIdVehicule());
		sql.setDouble(2, Object.getPrixJour());
		
		
		sql.executeUpdate();
		System.out.println(Object.getPrixJour()+"a bien été ajouté à la bdd");
		msg=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("insertion ok");
		}
		return msg;
	}

	@Override
	public List<Tarifs> read() {
		// TODO Auto-generated method stub
List<Tarifs> listeTarifs = new ArrayList<>();
		
try {
	PreparedStatement req = connect.prepareStatement("SELECT * FROM tarif as assoc "
			+ "JOIN vehicule as v ON assoc.id_vehicule = v.id_vehicule ");
	//System.out.println(req);
	
	ResultSet rs = req.executeQuery();
	
	while(rs.next()) {
		
		Vehicule vehi = new Vehicule(rs.getInt("id_vehicule"),rs.getString("marque"),rs.getString("modele"),rs.getDouble("prix"),rs.getString("emplacement"),
				rs.getInt("siege"),rs.getBoolean("etat"),rs.getBoolean("oneOff"),rs.getString("color"),
				rs.getString("energy"),rs.getInt("miles"),rs.getInt("year"),rs.getString("mechanic"),
				rs.getString("interieur"),rs.getString("image"),rs.getString("image1"),rs.getString("image3"),rs.getString("image3"),rs.getString("description"),rs.getBoolean("isPromo"),
				rs.getBoolean("approved"),rs.getInt("partDispo"),rs.getBoolean("forRent"),rs.getString("availability"));
		
		Tarifs tarif = new Tarifs(rs.getInt("id_tarif"),vehi,rs.getDouble("mbela"));
		
		listeTarifs.add(tarif);
		
	}
	//System.out.println(listeUser);
}catch(Exception e) {
	e.printStackTrace();
	System.out.println("Insertion KO - KO - KO");
}

//System.out.println("la lsite" + listeAsso);
return listeTarifs;
		
	}

	public Tarifs findById(int id) {
		Tarifs tarif = null;
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM tarif as assoc "
					+ "JOIN vehicule as v ON assoc.id_vehicule = v.id_vehicule WHERE id_tarif=?");
			req.setInt(1, id);
			
			ResultSet rs = req.executeQuery();
			
			if(rs.next()) {
				
				Vehicule vehi =new Vehicule(rs.getInt("id_vehicule"),rs.getString("marque"),rs.getString("modele"),rs.getDouble("prix"),rs.getString("emplacement"),
						rs.getInt("siege"),rs.getBoolean("etat"),rs.getBoolean("oneOff"),rs.getString("color"),
						rs.getString("energy"),rs.getInt("miles"),rs.getInt("year"),rs.getString("mechanic"),
						rs.getString("interieur"),rs.getString("image"),rs.getString("image1"),rs.getString("image3"),rs.getString("image3"),rs.getString("description"),rs.getBoolean("isPromo"),
						rs.getBoolean("approved"),rs.getInt("partDispo"),rs.getBoolean("forRent"),rs.getString("availability"));
				
				tarif =  new Tarifs(rs.getInt("id_tarif"),vehi,rs.getDouble("mbela"));
						
			}
			System.out.println(tarif);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("aaaaa KO - KO - KO");
		}
		return tarif;
	}
	
	
	@Override
	public Boolean update(Tarifs Object) {
		// TODO Auto-generated method stub
			boolean msg = false;
			try {
				PreparedStatement req = connect.prepareStatement("UPDATE tarif SET id_vehicule=?, mbela=?"
						+ " WHERE id_tarif=?");
				req.setInt(1, Object.getVoiture().getIdVehicule());
				req.setDouble(2, Object.getPrixJour());
				req.setInt(3, Object.getIdTariff());
				
				
				req.executeUpdate();
				
				System.out.println( Object.getPrixJour()+ " a été bien updaté en base");
				msg = true;
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Insertion KO");
			}
			return msg;
		}

	@Override
	public Boolean delete(Tarifs Object) {
		// TODO Auto-generated method stub
		return false;
	}

	public Object CarTarif(int id) {
		// TODO Auto-generated method stub
		Tarifs tarif = null;
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM tarif as assoc "
					+ "JOIN vehicule as v ON assoc.id_vehicule = v.id_vehicule WHERE id_vehicule=?");
			req.setInt(1, id);
			
			ResultSet rs = req.executeQuery();
			
			if(rs.next()) {
				
				Vehicule vehi =new Vehicule(rs.getInt("id_vehicule"),rs.getString("marque"),rs.getString("modele"),rs.getDouble("prix"),rs.getString("emplacement"),
						rs.getInt("siege"),rs.getBoolean("etat"),rs.getBoolean("oneOff"),rs.getString("color"),
						rs.getString("energy"),rs.getInt("miles"),rs.getInt("year"),rs.getString("mechanic"),
						rs.getString("interieur"),rs.getString("image"),rs.getString("image1"),rs.getString("image3"),rs.getString("image3"),rs.getString("description"),rs.getBoolean("isPromo"),
						rs.getBoolean("approved"),rs.getInt("partDispo"),rs.getBoolean("forRent"),rs.getString("availability"));
				
				tarif =  new Tarifs(rs.getInt("id_tarif"),vehi,rs.getDouble("mbela"));
						
			}
			System.out.println(tarif);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("aaaaa KO - KO - KO");
		}
		return tarif;
	}
}
