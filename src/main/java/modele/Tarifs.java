package modele;

public class Tarifs {
	
private int idTariff;
private Vehicule voiture;
private Double prixJour;


public int getIdTariff() {
	return idTariff;
}
public void setIdTariff(int idTariff) {
	this.idTariff = idTariff;
}
public Vehicule getVoiture() {
	return voiture;
}
public void setVoiture(Vehicule voiture) {
	this.voiture = voiture;
}
public Double getPrixJour() {
	return prixJour;
}
public void setPrixJour(Double prixJour) {
	this.prixJour = prixJour;
}
public Tarifs(int idTariff, Vehicule voiture, Double prixJour) {
	super();
	this.idTariff = idTariff;
	this.voiture = voiture;
	this.prixJour = prixJour;
}
public Tarifs(Vehicule voiture, Double prixJour) {
	super();
	this.voiture = voiture;
	this.prixJour = prixJour;
}
public Tarifs() {
	super();
}



}
