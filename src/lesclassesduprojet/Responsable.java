package lesclassesduprojet;

public class Responsable extends Personne {

	public Responsable(int id_responsable,String nom, String prenom,String login,String password) {
		super(nom, prenom, login, password);
		this.id_responsable=id_responsable;
	}

	public int getId_responsable() {
		return id_responsable;
	}

	public void setId_responsable(int id_responsable) {
		this.id_responsable = id_responsable;
	}

	private int id_responsable ;
}
