package modele;

public class Sinistre {

	private int idSinistre;
	private User user;
	private Vehicule voiture;
	private Location location;
	private String date;
	private String description;
	public Sinistre(int idSinistre, User user, Vehicule voiture, Location location, String date, String description) {
		super();
		this.idSinistre = idSinistre;
		this.user = user;
		this.voiture = voiture;
		this.location = location;
		this.date = date;
		this.description = description;
	}
	public Sinistre(User user, Vehicule voiture, Location location, String date, String description) {
		super();
		this.user = user;
		this.voiture = voiture;
		this.location = location;
		this.date = date;
		this.description = description;
	}
	public Sinistre() {
		super();
	}
	public int getIdSinistre() {
		return idSinistre;
	}
	public void setIdSinistre(int idSinistre) {
		this.idSinistre = idSinistre;
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
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
