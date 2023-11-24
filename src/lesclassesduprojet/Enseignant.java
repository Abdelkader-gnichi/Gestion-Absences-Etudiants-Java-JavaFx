package lesclassesduprojet;

public class Enseignant extends Personne {
	

	private int id_enseignant;
	private int is_responsable;
	
	

	public Enseignant(int id_enseignant,String nom, String prenom, String login,String password,int is_responsable) {
		super(nom, prenom,login, password);
		this.id_enseignant=id_enseignant;
		this.is_responsable=is_responsable;
	}

	public int getId_enseignant() {
		return id_enseignant;
	}

	public void setId_enseignant(int id_enseignant) {
		this.id_enseignant = id_enseignant;
	}
	public int getIs_responsable() {
		return is_responsable;
	}

	public void setIs_responsable(int is_responsable) {
		this.is_responsable = is_responsable;
	}

}
