package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Connect.GetConnection;
import modele.Categories;

public class CategoriesDao implements IDAO<Categories> {

	Connection connect = GetConnection.getConnection();
	ResultSet rs = null;
	
	@Override
	public boolean create(Categories Object) {
		// TODO Auto-generated method stub
		boolean msg = false;
		PreparedStatement sql;
		try {
			sql = connect.prepareStatement("INSERT INTO categories (libelle) VALUE (?)");
			sql.setString(1,Object.getLibelle());
			
			sql.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return msg;
	}

	@Override
	public List<Categories> read() {
		// TODO Auto-generated method stub
List<Categories> listeCategories = new ArrayList<>();
		
		try {
		PreparedStatement req = connect.prepareStatement("SELECT*FROM categories");
		ResultSet rs = req.executeQuery();
		while(rs.next()) {
			Categories cte = new Categories();
		
				cte.setIdCategories(rs.getInt("idCategorie"));
			
				cte.setLibelle(rs.getString("libelle"));
				
				listeCategories.add(cte);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeCategories;
	}

	@Override
	public Boolean update(Categories Object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Boolean delete(Categories Object) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
