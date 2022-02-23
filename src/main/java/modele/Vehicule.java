package modele;

public class Vehicule {

	private int idVehicule;
	private String marque;
	private String modele;
	private Double price;
	private String emplacement;
	private int siege;
	private boolean etat;
	private boolean oneOff;
	private String color;
	private String energy;
	private int miles;
	private int year;
	private String mechanic;
	private String interieur;
	private String image;
	private String image1;
	private String image2;
	private String image3;
	private String description;
	private boolean promo;
	private boolean approved;
	private int partDispo;
	private boolean forRent;
	private String availability;
	public int getIdVehicule() {
		return idVehicule;
	}
	public void setIdVehicule(int idVehicule) {
		this.idVehicule = idVehicule;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getEmplacement() {
		return emplacement;
	}
	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}
	public int getSiege() {
		return siege;
	}
	public void setSiege(int siege) {
		this.siege = siege;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public boolean isOneOff() {
		return oneOff;
	}
	public void setOneOff(boolean oneOff) {
		this.oneOff = oneOff;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getEnergy() {
		return energy;
	}
	public void setEnergy(String energy) {
		this.energy = energy;
	}
	public int getMiles() {
		return miles;
	}
	public void setMiles(int miles) {
		this.miles = miles;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getMechanic() {
		return mechanic;
	}
	public void setMechanic(String mechanic) {
		this.mechanic = mechanic;
	}
	public String getInterieur() {
		return interieur;
	}
	public void setInterieur(String interieur) {
		this.interieur = interieur;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getImage1() {
		return image1;
	}
	public void setImage1(String image1) {
		this.image1 = image1;
	}
	public String getImage2() {
		return image2;
	}
	public void setImage2(String image2) {
		this.image2 = image2;
	}
	public String getImage3() {
		return image3;
	}
	public void setImage3(String image3) {
		this.image3 = image3;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isPromo() {
		return promo;
	}
	public void setPromo(boolean promo) {
		this.promo = promo;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	public int getPartDispo() {
		return partDispo;
	}
	public void setPartDispo(int partDispo) {
		this.partDispo = partDispo;
	}
	public boolean isForRent() {
		return forRent;
	}
	public void setForRent(boolean forRent) {
		this.forRent = forRent;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	
	
	
	
	public Vehicule(String marque, String modele, Double price, String emplacement, int siege, boolean etat,
			boolean oneOff, String color, String energy, int miles, int year, String mechanic, String interieur,
			String image, String image1, String image2, String image3, String description, boolean approved,
			int partDispo, boolean forRent, String availability) {
		super();
		this.marque = marque;
		this.modele = modele;
		this.price = price;
		this.emplacement = emplacement;
		this.siege = siege;
		this.etat = etat;
		this.oneOff = oneOff;
		this.color = color;
		this.energy = energy;
		this.miles = miles;
		this.year = year;
		this.mechanic = mechanic;
		this.interieur = interieur;
		this.image = image;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.description = description;
		this.approved = approved;
		this.partDispo = partDispo;
		this.forRent = forRent;
		this.availability = availability;
	}
	public Vehicule() {
		super();
	}
	public Vehicule(int idVehicule, String marque, String modele, Double price, String emplacement, int siege,
			boolean etat, boolean oneOff, String color, String energy, int miles, int year, String mechanic,
			String interieur, String image, String image1, String image2, String image3, String description,
			boolean promo, boolean approved, int partDispo, boolean forRent, String availability) {
		super();
		this.idVehicule = idVehicule;
		this.marque = marque;
		this.modele = modele;
		this.price = price;
		this.emplacement = emplacement;
		this.siege = siege;
		this.etat = etat;
		this.oneOff = oneOff;
		this.color = color;
		this.energy = energy;
		this.miles = miles;
		this.year = year;
		this.mechanic = mechanic;
		this.interieur = interieur;
		this.image = image;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.description = description;
		this.promo = promo;
		this.approved = approved;
		this.partDispo = partDispo;
		this.forRent = forRent;
		this.availability = availability;
	}
	public Vehicule(String marque, String modele, Double price, String emplacement, int siege, boolean etat,
			boolean oneOff, String color, String energy, int miles, int year, String mechanic, String interieur,
			String image, String image1, String image2, String image3, String description, boolean promo,
			boolean approved, int partDispo, boolean forRent, String availability) {
		super();
		this.marque = marque;
		this.modele = modele;
		this.price = price;
		this.emplacement = emplacement;
		this.siege = siege;
		this.etat = etat;
		this.oneOff = oneOff;
		this.color = color;
		this.energy = energy;
		this.miles = miles;
		this.year = year;
		this.mechanic = mechanic;
		this.interieur = interieur;
		this.image = image;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.description = description;
		this.promo = promo;
		this.approved = approved;
		this.partDispo = partDispo;
		this.forRent = forRent;
		this.availability = availability;
	}
	
	
}
