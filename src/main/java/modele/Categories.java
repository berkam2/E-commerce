package modele;

public class Categories {

	private int idCategories;
	private String libelle;
	public int getIdCategories() {
		return idCategories;
	}
	public Categories(int idCategories, String libelle) {
		super();
		this.idCategories = idCategories;
		this.libelle = libelle;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public void setIdCategories(int idCategories) {
		this.idCategories = idCategories;
	}
	public Categories() {
		super();
	}
	public Categories(String libelle) {
		super();
		this.libelle = libelle;
	}
	
	
	
	
}
