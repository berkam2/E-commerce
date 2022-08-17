package modele;

public class Statut {

	private int idStatut;
	private String libelle;
	
	public int getIdStatut() {
		return idStatut;
	}
	public void setIdStatut(int idStatut) {
		this.idStatut = idStatut;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Statut(String libelle) {
		super();
		this.libelle = libelle;
	}
	public Statut() {
		super();
	}
	
	
	public Statut(int idStatut, String libelle) {
		super();
		this.idStatut = idStatut;
		this.libelle = libelle;
	}
	@Override
	public String toString() {
		return "Statut [libelle=" + libelle + "]";
	}
	
	
}
