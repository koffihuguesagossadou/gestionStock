package gestionStock.entities;

public class Article {
	
	private int id;
	private String Designation;
	private String Prix;
	private int Quantite;
	
	public Article(){
		super();
	}
	
	
	public Article(String designation, String prix, int quantite) {
		super();
		Designation = designation;
		Prix = prix;
		Quantite = quantite;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public String getPrix() {
		return Prix;
	}
	public void setPrix(String prix) {
		Prix = prix;
	}
	public int getQuantite() {
		return Quantite;
	}
	public void setQuantite(int quantite) {
		Quantite = quantite;
	}
	
	@Override
	public String toString() {
		return "Article [id=" + id + ", Designation=" + Designation + ", Prix=" + Prix + ", Quantite=" + Quantite + "]";
	}
	
}
