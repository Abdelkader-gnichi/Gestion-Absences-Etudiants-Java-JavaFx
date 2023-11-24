package lesclassesduprojet;

public class Correspondance {
	 public Correspondance(Enseignant enseignant, Matiere matiere, Classe classe) {
		super();
		this.enseignant = enseignant;
		this.matiere = matiere;
		this.classe = classe;
	}
	private Enseignant enseignant;
	 private Matiere matiere;
	 private Classe classe;
	public Enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	 

}
