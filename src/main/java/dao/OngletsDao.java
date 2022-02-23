package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Connect.GetConnection;
import modele.Onglets;
import modele.Statut;

public class OngletsDao implements IDAO <Onglets>{

	Connection connect = GetConnection.getConnection();
	ResultSet rs = null;
	
	@Override
	public boolean create(Onglets Object) {
		// TODO Auto-generated method stub
		boolean msg = false;
		PreparedStatement sql;
		try {
			sql = connect.prepareStatement("INSERT INTO onglets (libelle) VALUE (?)");
			sql.setString(1,Object.getLibelle());
			
			sql.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return msg;
	}

	@Override
	public List<Onglets> read() {
		// TODO Auto-generated method stub
		List<Onglets> listeOnglets = new ArrayList<>();
		
		try {
		PreparedStatement req = connect.prepareStatement("SELECT*FROM onglets");
		ResultSet rs = req.executeQuery();
		while(rs.next()) {
			Onglets ogt = new Onglets();
		
				ogt.setIdOnglet(rs.getInt("id_onglet"));
			
				ogt.setLibelle(rs.getString("libelle"));
				
				listeOnglets.add(ogt);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeOnglets;
	}

	@Override
	public Boolean update(Onglets Object) {
		// TODO Auto-generated method stub
		
		boolean msg = false;
		try {
			PreparedStatement req = connect.prepareStatement("UPDATE onglets SET libelle=?"
					+ " WHERE id_onglet=?");
			req.setString(1, Object.getLibelle());
			req.setInt(2, Object.getIdOnglet());
			
			
			req.executeUpdate();
			
			System.out.println( Object.getLibelle()+ " a été bien updaté en base");
			msg = true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Insertion KO");
		}
		return msg;

	}

	@Override
	public Boolean delete(Onglets Object) {
		// TODO Auto-generated method stub
		boolean msg = false;
		try {
			PreparedStatement req = connect.prepareStatement("DELETE FROM onglets"
					+ " WHERE id_onglet=?");
			req.setInt(1, Object.getIdOnglet());
			
			
			req.executeUpdate();
			
			System.out.println( Object.getLibelle()+ " a été bien updaté en base");
			msg = true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Insertion KO");
		}
		return msg;
	}
	
	public Onglets findById(int id) {
		Onglets onglets =null;
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM onglets WHERE id_onglet=?");
			req.setInt(1, id);
			
			ResultSet rs = req.executeQuery();
			
			if(rs.next()) {
				
				onglets =  new Onglets(rs.getInt("id_onglet"),rs.getString("libelle"));
						
			}
			System.out.println(onglets);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("aaaaa KO - KO - KO");
		}
		return onglets;

}
}
