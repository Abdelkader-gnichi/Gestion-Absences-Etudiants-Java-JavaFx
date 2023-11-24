package lesclassesduprojet;

public class Personne {
	 public Personne(String nom, String prenom, String login,String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.login = login;
	}
	private String nom;
	 public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	private String prenom;
	 private String password;
	 private String login;

}
