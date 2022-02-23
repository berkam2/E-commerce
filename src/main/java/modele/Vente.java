package modele;

public class Vente {

	private int idVente;
	private Vehicule vehicule;
	private User user;
	public Vente(int idVente, Vehicule vehicule, User user) {
		super();
		this.idVente = idVente;
		this.vehicule = vehicule;
		this.user = user;
	}
	public Vente(Vehicule vehicule, User user) {
		super();
		this.vehicule = vehicule;
		this.user = user;
	}
	public Vente() {
		super();
	}
	public int getIdVente() {
		return idVente;
	}
	public void setIdVente(int idVente) {
		this.idVente = idVente;
	}
	public Vehicule getVehicule() {
		return vehicule;
	}
	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
