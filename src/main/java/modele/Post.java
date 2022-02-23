package modele;

public class Post {
	private int id;
	private String titre;
	private String resume;
	private String contenu;
	private String created_at;
	private String auteur;
	private String image;
	
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Post(int id, String titre, String resume, String contenu, String auteur, String image) {
		super();
		this.id = id;
		this.titre = titre;
		this.resume = resume;
		this.contenu = contenu;
		this.auteur = auteur;
		this.image = image;
	}



	public Post(int id, String titre, String resume, String contenu, String auteur) {
		super();
		this.id = id;
		this.titre = titre;
		this.resume = resume;
		this.contenu = contenu;
		this.auteur = auteur;
	}

	public Post(String titre, String resume, String contenu, String auteur) {
		super();
		this.titre = titre;
		this.resume = resume;
		this.contenu = contenu;
		this.auteur = auteur;
	}
	
	public Post(String titre, String resume, String contenu, String auteur, String image) {
		super();
		this.titre = titre;
		this.resume = resume;
		this.contenu = contenu;
		this.auteur = auteur;
		this.image = image;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String string) {
		this.created_at = string;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
