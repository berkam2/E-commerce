
package modele;

import java.util.Date;

public class Actionnariats {

	
	private int idActionnariat;
	private User utilisateur;
	private Vehicule voiture;
	private int part;
	private int availableDay;
	private Date date;
	
	
	
	public Actionnariats() {
		super();
	}



	
	
	public Actionnariats(User utilisateur, Vehicule voiture, int part) {
		super();
		this.utilisateur = utilisateur;
		this.voiture = voiture;
		this.part = part;
	}





	public int getIdActionnariat() {
		return idActionnariat;
	}





	public void setIdActionnariat(int idActionnariat) {
		this.idActionnariat = idActionnariat;
	}





	public User getUtilisateur() {
		return utilisateur;
	}





	public void setUtilisateur(User utilisateur) {
		this.utilisateur = utilisateur;
	}





	public Vehicule getVoiture() {
		return voiture;
	}





	public void setVoiture(Vehicule voiture) {
		this.voiture = voiture;
	}





	public int getPart() {
		return part;
	}





	public void setPart(int part) {
		this.part = part;
	}





	public int getAvailableDay() {
		return availableDay;
	}





	public void setAvailableDay(int availableDay) {
		this.availableDay = availableDay;
	}





	public Date getDate() {
		return date;
	}





	public void setDate(Date date) {
		this.date = date;
	}





	public Actionnariats(User utilisateur, Vehicule voiture, int part, int availableDay, Date date) {
		super();
		this.utilisateur = utilisateur;
		this.voiture = voiture;
		this.part = part;
		this.availableDay = availableDay;
		this.date = date;
	}



	public Actionnariats(int idActionnariat, User utilisateur, Vehicule voiture, int part, int availableDay,
			Date date) {
		super();
		this.idActionnariat = idActionnariat;
		this.utilisateur = utilisateur;
		this.voiture = voiture;
		this.part = part;
		this.availableDay = availableDay;
		this.date = date;
	}



	@Override
	public String toString() {
		return "Actionnariats [idActionnariat=" + idActionnariat + ", l'utilisateur " + utilisateur + " détient "
				 + part + ", part du vehicule "+ voiture + "]";
				
	}
	
	
}
