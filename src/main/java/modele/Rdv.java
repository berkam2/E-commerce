package modele;

public class Rdv {

	private int idRdv;
	private User user;
	private Vehicule voiture;
	private String date;
	private String heure;
	public Rdv(int idRdv, User user, Vehicule voiture, String date, String heure) {
		super();
		this.idRdv = idRdv;
		this.user = user;
		this.voiture = voiture;
		this.date = date;
		this.heure = heure;
	}
	public Rdv(User user, Vehicule voiture, String date, String heure) {
		super();
		this.user = user;
		this.voiture = voiture;
		this.date = date;
		this.heure = heure;
	}
	public Rdv() {
		super();
	}
	public int getIdRdv() {
		return idRdv;
	}
	public void setIdRdv(int idRdv) {
		this.idRdv = idRdv;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Vehicule getVoiture() {
		return voiture;
	}
	public void setVoiture(Vehicule voiture) {
		this.voiture = voiture;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHeure() {
		return heure;
	}
	public void setHeure(String heure) {
		this.heure = heure;
	}
	
	
}
