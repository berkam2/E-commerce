package dao;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import dao.Connect.GetConnection;
import modele.User;


public class UserDao implements IDAO <User> {

	Connection connect = GetConnection.getConnection();
	
	ResultSet rs = null;
	public static User currentUser;
	
	public static String encode(String value) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] hash = md.digest(value.getBytes(StandardCharsets.UTF_8));
		String encoded = Base64.getEncoder().encodeToString(hash);
		return encoded;
	}
	
	public boolean mailFree(String email) {
        Boolean msg = false;
        try {
            PreparedStatement sql = connect.prepareStatement("SELECT * FROM user WHERE email = ?");

            sql.setString(1, email);

            ResultSet rs = sql.executeQuery();

            if(!rs.next()) {
                msg = true;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return msg;
    }
	
	public boolean isAdmin(String email) {
		Boolean msg = false;
		 try {
	            PreparedStatement sql = connect.prepareStatement("SELECT * FROM user WHERE email = ? and id_statut=1");

	            sql.setString(1, email);

	            ResultSet rs = sql.executeQuery();

	            if(rs.next()) {
	                msg = true;
	            }

	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	        return msg;
	}
	
	public boolean create(User Object) {
		boolean msg = false;
		PreparedStatement sql;
		try {
			sql = connect.prepareStatement("INSERT INTO user (nom,prenom,email,age,telephone,mdp,adresse, obtentionPermis, permis,id_statut,image)"
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)");
			
		sql.setString(1, Object.getNom());
		sql.setString(2, Object.getPrenom());
		sql.setString(3, Object.getEmail());
		sql.setInt(4, Object.getAge());
		sql.setString(5, Object.getTelephone());
		try {
			sql.setString(6, encode(Object.getMdp()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql.setString(7, Object.getAdresse());
		sql.setString(8,Object.getObtentionPermis());
		sql.setString(9,Object.getPermis());
		sql.setInt(10,Object.getIdStatut());
		sql.setString(11, Object.getImage());
		
		sql.executeUpdate();
		System.out.println(Object.getNom()+"a bien été ajouté à la bdd");
		msg=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("insertion ko");
		}
		return msg;
	}


	public boolean signup(User Object) {
		boolean msg = false;
		PreparedStatement sql;
		try {
			sql = connect.prepareStatement("INSERT INTO user (nom,prenom,email,age,telephone,mdp,adresse, obtentionPermis, permis,id_statut,image)"
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)");
			
		sql.setString(1, Object.getNom());
		sql.setString(2, Object.getPrenom());
		sql.setString(3, Object.getEmail());
		sql.setInt(4, Object.getAge());
		sql.setString(5, Object.getTelephone());
		try {
			sql.setString(6, encode(Object.getMdp()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql.setString(7, Object.getAdresse());
		sql.setString(8,Object.getObtentionPermis());
		sql.setString(9,Object.getPermis());
		sql.setInt(10,2);
		sql.setString(11, Object.getImage());
		sql.executeUpdate();
		System.out.println(Object.getNom()+"a bien été ajouté à la bdd");
		msg=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("insertion ok");
		}
		return msg;
	}

	
	@Override
	public List<User> read() {
		// TODO Auto-generated method stub
	List<User> listeUser = new ArrayList<>();
		
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM user");
			
			ResultSet rs = req.executeQuery();
			
			while(rs.next()) {
				User personne = new User();
				
				personne.setIdUser(rs.getInt("id_user"));
				personne.setPrenom(rs.getString("prenom"));
				personne.setNom(rs.getString("nom"));
				personne.setIdStatut(rs.getInt("id_statut"));
				personne.setEmail(rs.getString("email"));
				personne.setAge(rs.getInt("age"));
				personne.setTelephone(rs.getString("telephone"));
				personne.setMdp(rs.getString("mdp"));
				personne.setAdresse(rs.getString("adresse"));
				personne.setObtentionPermis(rs.getString("obtentionPermis"));
				personne.setInscription(rs.getDate("inscription"));
				personne.setVisible(rs.getBoolean("isVisible"));
				personne.setPermis(rs.getString("permis"));	
				personne.setImage(rs.getString("image"));
		
				
				listeUser.add(personne);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Insertion KO - KO - KO");
		}
		return listeUser;
	}

	@Override
	public Boolean update(User Object) {
		// TODO Auto-generated method stub
		boolean msg = false;
		try {
			PreparedStatement req = connect.prepareStatement("DELETE FROM user"
					+ " WHERE id_user=?");
			req.setInt(1, Object.getIdUser());
			
			
			req.executeUpdate();
			
			
			msg = true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Insertion KO");
		}
		return msg;
	}

	@Override
	public Boolean delete(User Object) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public User login(String mail, String mdp) {
        //boolean msg = false;
        try {
            PreparedStatement sql = connect.prepareStatement("SELECT * FROM user WHERE email=? AND mdp=?");
            sql.setString(1, mail);
            try {
                sql.setString(2, encode(mdp));
            } catch (NoSuchAlgorithmException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            ResultSet rs = sql.executeQuery();
            
            if(rs.next()) {
                //msg = true;
            	
            	return new User(rs.getInt("id_user"), rs.getString("nom"),rs.getString("prenom"),rs.getInt("id_statut"),
            			rs.getString("email"),rs.getInt("age"),rs.getString("telephone"),rs.getString("mdp"),
            			rs.getString("adresse"),rs.getString("obtentionPermis"),rs.getDate("inscription"),
            			rs.getBoolean("isVisible"),rs.getString("permis"),rs.getString("image"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
	
	public User findById(int id) {
		User user  =null;
		try {
			PreparedStatement req = connect.prepareStatement("SELECT * FROM user WHERE id_user=?");
			req.setInt(1, id);
			
			ResultSet rs = req.executeQuery();
			
			if(rs.next()) {
				
				user =  new User(rs.getInt("id_user"), rs.getString("nom"),rs.getString("prenom"),rs.getInt("id_statut"),
            			rs.getString("email"),rs.getInt("age"),rs.getString("telephone"),rs.getString("mdp"),
            			rs.getString("adresse"),rs.getString("obtentionPermis"),rs.getDate("inscription"),
            			rs.getBoolean("isVisible"),rs.getString("permis"),rs.getString("image"));
			}
			System.out.println(user);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("aaaaa KO - KO - KO");
		}
		return user;
	
}
}
