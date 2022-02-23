package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Connect.GetConnection;
import modele.Statut;


public class StatutDao implements IDAO <Statut>{
	Connection connect = GetConnection.getConnection();
	
	@Override
	public boolean create(Statut Object) {
		// TODO Auto-generated method stub
		boolean msg = false;
		PreparedStatement sql;
		try {
			sql = connect.prepareStatement("INSERT INTO statut (titre) VALUES (?)");
			
		
		sql.setString(1, Object.getLibelle());
		
		sql.executeUpdate();
		System.out.println(Object.getLibelle()+"a bien été ajouté à la bdd");
		msg=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("insertion ok");
		}
		return msg;
	}

	@Override
	public List<Statut> read() {
		// TODO Auto-generated method stub
List<Statut> listeStatut = new ArrayList<>();
		
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM statut");
			
			ResultSet rs = req.executeQuery();
			
			while(rs.next()) {
				Statut statut = new Statut();
				
				statut.setIdStatut(rs.getInt("id_statut"));
				statut.setLibelle(rs.getString("titre"));
				
				listeStatut.add(statut);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Insertion KO - KO - KO");
		}
		return listeStatut;
		
	}

	public Statut findById(int id) {
		Statut statut =null;
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM statut WHERE id_statut=?");
			req.setInt(1, id);
			
			ResultSet rs = req.executeQuery();
			
			if(rs.next()) {
				
				statut =  new Statut(rs.getInt("id_statut"),rs.getString("titre"));
						
			}
			System.out.println(statut);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("aaaaa KO - KO - KO");
		}
		return statut;
	}
	
	
	@Override
	public Boolean update(Statut Object) {
		// TODO Auto-generated method stub
			boolean msg = false;
			try {
				PreparedStatement req = connect.prepareStatement("UPDATE statut SET titre=?"
						+ " WHERE id_statut=?");
				req.setString(1, Object.getLibelle());
				req.setInt(2, Object.getIdStatut());
				
				
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
	public Boolean delete(Statut Object) {
		// TODO Auto-generated method stub
		return false;
	}

}
