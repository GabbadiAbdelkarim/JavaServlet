package Model;

public class Produit {

	private Long code;
	private String nom;
	private String description;
	private double prix;
	private Client client;
	
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Produit(Long code, String nom, String description, double prix, Client client) {
		super();
		this.code = code;
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.client = client;
	}

	public Produit(String nom, String description, double prix, Client client) {
		super();
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.client = client;
	}

	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Produit [code=" + code + ", nom=" + nom + ", description=" + description + ", prix=" + prix
				+ ", client=" + client + "]";
	}
	
	
}
