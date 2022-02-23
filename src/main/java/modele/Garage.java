package modele;

public class Garage {

	private int idGarage;
	private Sinistre sinistre;
	private Double cout;
	private String intervention;
	private String entree;
	private String sortie;
	public int getIdGarage() {
		return idGarage;
	}
	public void setIdGarage(int idGarage) {
		this.idGarage = idGarage;
	}
	public Sinistre getSinistre() {
		return sinistre;
	}
	public void setSinistre(Sinistre sinistre) {
		this.sinistre = sinistre;
	}
	public Double getCout() {
		return cout;
	}
	public void setCout(Double cout) {
		this.cout = cout;
	}
	public String getIntervention() {
		return intervention;
	}
	public void setIntervention(String intervention) {
		this.intervention = intervention;
	}
	public String getEntree() {
		return entree;
	}
	public void setEntree(String entree) {
		this.entree = entree;
	}
	public String getSortie() {
		return sortie;
	}
	public void setSortie(String sortie) {
		this.sortie = sortie;
	}
	public Garage(int idGarage, Sinistre sinistre, Double cout, String intervention, String entree, String sortie) {
		super();
		this.idGarage = idGarage;
		this.sinistre = sinistre;
		this.cout = cout;
		this.intervention = intervention;
		this.entree = entree;
		this.sortie = sortie;
	}
	public Garage(Sinistre sinistre, Double cout, String intervention, String entree, String sortie) {
		super();
		this.sinistre = sinistre;
		this.cout = cout;
		this.intervention = intervention;
		this.entree = entree;
		this.sortie = sortie;
	}
	public Garage() {
		super();
	}
	@Override
	public String toString() {
		return "Garage [idGarage=" + idGarage + ", sinistre=" + sinistre + ", cout=" + cout + ", intervention="
				+ intervention + ", entree=" + entree + ", sortie=" + sortie + "]";
	}
	
	
	
}
