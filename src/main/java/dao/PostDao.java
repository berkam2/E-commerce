package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.Connect.GetConnection;
import modele.Post;

public class PostDao implements IDAO<Post> {

	Connection connect = GetConnection.getConnection();
	
	
	public Post findById(int id) {
		Post post =null;
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM article WHERE id=?");
			req.setInt(1, id);
			
			ResultSet rs = req.executeQuery();
			
			if(rs.next()) {
				
				post =  new Post(rs.getInt("id"),rs.getString("titre"),rs.getString("resume"),rs.getString("contenu"),rs.getString("auteur"),rs.getString("image"));
			}
			System.out.println(post);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("aaaaa KO - KO - KO");
		}
		return post;
	}
	


	@Override
	public boolean create(Post Object) {
		// TODO Auto-generated method stub
		boolean message = false;
		try {
			
			PreparedStatement req = connect.prepareStatement("INSERT INTO article"
					+ "(titre, resume, contenu, created_at, auteur,image) VALUES (?,?,?,now(),?,?) ");
			
			req.setString(1, Object.getTitre());
			req.setString(2, Object.getResume());
			req.setString(3, Object.getContenu());
			req.setObject(4, Object.getAuteur());
			req.setObject(5, Object.getImage());
			
			req.executeUpdate();
			message = true;
			System.out.println("Article - Insertion OK");
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Article Insertion KO - KO - KO");
			
		}
		return message;
	}

	@Override
	public List<Post> read() {
		// TODO Auto-generated method stub
List<Post> listearticle = new ArrayList<>();
		
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM article");
			
			ResultSet rs = req.executeQuery();
			
			while(rs.next()) {
				Post article = new Post();
				
				article.setId(rs.getInt("id"));
				article.setTitre(rs.getString("titre"));
				article.setResume(rs.getString("resume"));
				article.setContenu(rs.getString("contenu"));
				article.setCreated_at(rs.getString("created_at"));
				article.setAuteur(rs.getString("auteur"));
				article.setImage(rs.getString("image"));
				
				listearticle.add(article);
			}
			//System.out.println(listearticle);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Insertion KO - KO - KO");
		}
		return listearticle;
	}

	@Override
	public Boolean update(Post Object) {
		// TODO Auto-generated method stub
		boolean msg = false;
		try {
			PreparedStatement req = connect.prepareStatement("UPDATE article SET titre=?, resume=?, contenu=?, auteur=?"
					+ " WHERE id=?");
			req.setString(1, Object.getTitre());
			req.setString(2, Object.getResume());
			req.setString(3, Object.getContenu());
			req.setString(4, Object.getAuteur());
			req.setInt(5, Object.getId());
			
			req.executeUpdate();
			System.out.println(req);
			msg = true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Update KO");
		}
		return msg;
		
	}

	@Override
	public Boolean delete(Post Object) {
		// TODO Auto-generated method stub
		return false;
	}

}
