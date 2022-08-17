package modele;

public class Onglets {

	private int idOnglet;
	private String libelle;
	
	public int getIdOnglet() {
		return idOnglet;
	}
	public void setIdOnglet(int idOnglet) {
		this.idOnglet = idOnglet;
		
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Onglets(String libelle) {
		super();
		this.libelle = libelle;
	}
	public Onglets(int idOnglet, String libelle) {
		super();
		this.idOnglet = idOnglet;
		this.libelle = libelle;
	}
	public Onglets() {
		super();
	}
	@Override
	public String toString() {
		return "Onglet [idOnglet=" + idOnglet + ", libelle=" + libelle + "]";
	}
	
	
	
}
