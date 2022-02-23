package modele;

public class Location {

	private int idLocation;
	private User user;
	private Vehicule voiture;
	private String debut;
	private String fin;
	private int nbreJour;
	private Tarifs mbela;
	private String priseEnCharge;
	public Location(int idLocation, User user, Vehicule voiture, String debut, String fin, int nbreJour, Tarifs mbela,
			String priseEnCharge) {
		super();
		this.idLocation = idLocation;
		this.user = user;
		this.voiture = voiture;
		this.debut = debut;
		this.fin = fin;
		this.nbreJour = nbreJour;
		this.mbela = mbela;
		this.priseEnCharge = priseEnCharge;
	}
	
	
	public Location() {
		super();
	}


	public Location(User user, Vehicule voiture, String debut, String fin, int nbreJour, Tarifs mbela,
			String priseEnCharge) {
		super();
		this.user = user;
		this.voiture = voiture;
		this.debut = debut;
		this.fin = fin;
		this.nbreJour = nbreJour;
		this.mbela = mbela;
		this.priseEnCharge = priseEnCharge;
	}
	public int getIdLocation() {
		return idLocation;
	}
	public void setIdLocation(int idLocation) {
		this.idLocation = idLocation;
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
	public String getDebut() {
		return debut;
	}
	public void setDebut(String debut) {
		this.debut = debut;
	}
	public String getFin() {
		return fin;
	}
	public void setFin(String fin) {
		this.fin = fin;
	}
	public int getNbreJour() {
		return nbreJour;
	}
	public void setNbreJour(int nbreJour) {
		this.nbreJour = nbreJour;
	}
	public Tarifs getMbela() {
		return mbela;
	}
	public void setMbela(Tarifs mbela) {
		this.mbela = mbela;
	}
	public String getPriseEnCharge() {
		return priseEnCharge;
	}
	public void setPriseEnCharge(String priseEnCharge) {
		this.priseEnCharge = priseEnCharge;
	}
	
	
	
	
}
