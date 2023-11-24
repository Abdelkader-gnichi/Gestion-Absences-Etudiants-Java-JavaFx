package lesclassesduprojet;


public class Absence {
	
	
    private Etudiant etudiant;
    private Enseignant enseignant;
    private Matiere matiere;
    
    private int numseance;
    private String date;
    private int presence;
    private String nomprof;
    private String matiereet;
    private String etat;
    private int justifiee;
    private String nometud;
    private String prenometud;
 
    

	public Absence(Etudiant etudiant, Enseignant enseignant, Matiere matiere, 
			int numseance, String date, int presence,int justifiee) {
		super();
		
		this.etudiant = etudiant;
		this.enseignant = enseignant;
		this.matiere = matiere;
		
		this.numseance = numseance;
		this.date = date;
		this.presence = presence;
		this.nomprof=enseignant.getPrenom();
		this.matiereet=matiere.getLibelle();
		this.justifiee=justifiee;
		this.nometud=etudiant.getNom();
		this.prenometud=etudiant.getPrenom();
		
		if(presence==1)
		{
			this.etat="absent";
		}
		else
		{
			this.etat="present";
		}
	}


	


	public String getMatiereet() {
		return matiereet;
	}





	public void setMatiereet(String matiereet) {
		this.matiereet = matiereet;
	}





	public String getEtat() {
		return etat;
	}





	public void setEtat(String etat) {
		this.etat = etat;
	}





	public String getNomprof() {
		return nomprof;
	}





	public void setNomprof(String nomprof) {
		this.nomprof =nomprof;
	}





	public Etudiant getEtudiant() {
		return etudiant;
	}


	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}


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


	

	public int getNumseance() {
		return numseance;
	}


	public void setNumseance(int numseance) {
		this.numseance = numseance;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public int isPresence() {
		return presence;
	}


	public void setPresence(int presence) {
		this.presence = presence;
	}
	
	public int getJustifiee() {
		return justifiee;
	}





	public void setJustifiee(int justifiee) {
		this.justifiee = justifiee;
	}
	

	public String getNometud() {
		return nometud;
	}





	public void setNometud(String nometud) {
		this.nometud = nometud;
	}





	public String getPrenometud() {
		return prenometud;
	}





	public void setPrenometud(String prenometud) {
		this.prenometud = prenometud;
	}





	







    
}
