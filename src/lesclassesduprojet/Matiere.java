package lesclassesduprojet;

public class Matiere {
	 private int id_matiere;
	 public Matiere(int id_matiere, String libelle) {
		super();
		this.id_matiere = id_matiere;
		this.libelle = libelle;
	}
	public int getId_matiere() {
		return id_matiere;
	}
	public void setId_matiere(int id_matiere) {
		this.id_matiere = id_matiere;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	private String libelle;
}
