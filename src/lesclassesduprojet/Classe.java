package lesclassesduprojet;

public class Classe {
	
	private int id_classe;
	 private String libelle;
	 private int niveau;
	 private String filiere;
	 
	 public Classe(int id_classe, String libelle, int niveau, String filiere) {
		super();
		this.id_classe = id_classe;
		this.libelle = libelle;
		this.niveau = niveau;
		this.filiere = filiere;
	}
	
	public int getId_classe() {
		return id_classe;
	}
	public void setId_classe(int id_classe) {
		this.id_classe = id_classe;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	public String getFiliere() {
		return filiere;
	}
	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}

}
