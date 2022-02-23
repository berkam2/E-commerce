package modele;

import java.util.Date;

public class User {

	private int idUser;
	private String nom;
	private String prenom;
	private int idStatut;
	private String email;
	private int age;
	private String telephone;
	private String mdp;
	private String adresse;
	private String obtentionPermis;
	private Date inscription;
	private Boolean visible;
	private String permis;
	private String image;
	
	
	public User(int idUser, String nom, String prenom, int idStatut, String email, int age, String telephone,
			String mdp, String adresse, String obtentionPermis, Boolean visible, String permis, String image) {
		super();
		this.idUser = idUser;
		this.nom = nom;
		this.prenom = prenom;
		this.idStatut = idStatut;
		this.email = email;
		this.age = age;
		this.telephone = telephone;
		this.mdp = mdp;
		this.adresse = adresse;
		this.obtentionPermis = obtentionPermis;
		this.visible = visible;
		this.permis = permis;
		this.image = image;
	}
	public User(int idUser, String nom, String prenom, int idStatut, String email, int age, String telephone,
			String mdp, String adresse, String obtentionPermis, Date inscription, Boolean visible, String permis,
			String image) {
		super();
		this.idUser = idUser;
		this.nom = nom;
		this.prenom = prenom;
		this.idStatut = idStatut;
		this.email = email;
		this.age = age;
		this.telephone = telephone;
		this.mdp = mdp;
		this.adresse = adresse;
		this.obtentionPermis = obtentionPermis;
		this.inscription = inscription;
		this.visible = visible;
		this.permis = permis;
		this.image = image;
	}
	public User(String nom, String prenom, int idStatut, String email, int age, String telephone, String mdp,
			String adresse, String obtentionPermis, Date inscription, Boolean visible, String permis, String image) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.idStatut = idStatut;
		this.email = email;
		this.age = age;
		this.telephone = telephone;
		this.mdp = mdp;
		this.adresse = adresse;
		this.obtentionPermis = obtentionPermis;
		this.inscription = inscription;
		this.visible = visible;
		this.permis = permis;
		this.image = image;
	}
	public User() {
		super();
	}
	public User(String nom, String prenom, int idStatut, String email, int age, String telephone, String mdp,
			String adresse, String obtentionPermis, String permis, String image) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.idStatut = idStatut;
		this.email = email;
		this.age = age;
		this.telephone = telephone;
		this.mdp = mdp;
		this.adresse = adresse;
		this.obtentionPermis = obtentionPermis;
		this.permis = permis;
		this.image = image;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getIdStatut() {
		return idStatut;
	}
	public void setIdStatut(int idStatut) {
		this.idStatut = idStatut;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getObtentionPermis() {
		return obtentionPermis;
	}
	public void setObtentionPermis(String obtentionPermis) {
		this.obtentionPermis = obtentionPermis;
	}
	public Date getInscription() {
		return inscription;
	}
	public void setInscription(Date inscription) {
		this.inscription = inscription;
	}
	public Boolean getVisible() {
		return visible;
	}
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}
	public String getPermis() {
		return permis;
	}
	public void setPermis(String permis) {
		this.permis = permis;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", nom=" + nom + ", prenom=" + prenom + ", idStatut=" + idStatut + ", email="
				+ email + ", age=" + age + ", telephone=" + telephone + ", mdp=" + mdp + ", adresse=" + adresse
				+ ", obtentionPermis=" + obtentionPermis + ", inscription=" + inscription + ", visible=" + visible
				+ ", permis=" + permis + ", image=" + image + "]";
	}
	
	
	
}
