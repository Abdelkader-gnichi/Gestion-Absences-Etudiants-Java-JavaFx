package lesclassesduprojet;

import java.util.regex.Pattern;


public class Etudiant extends Personne {
private int id_etudiant;
	
	private Classe classe;
	private String mail;
	private String nset;	
	
	
	public Etudiant(int id_etudiant,String nom, String prenom,String login,String password,String mail,Classe classe) {
		super(nom, prenom,login, password);
		this.id_etudiant=id_etudiant;
		this.classe=classe;
		this.mail=mail;
		nset=login;
	}
	
	


	public String getNset() {
		return nset;
	}


	public void setNset(String nset) {
		this.nset = nset;
	}



	public int getId_etudiant() {
		return id_etudiant;
	}
	public void setId_etudiant(int id_etudiant) {
		this.id_etudiant = id_etudiant;
	}
	
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

	public static boolean testmail(String mail) 
    { 
        String mailconditions= "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(mailconditions); 
        if (mail == null) 
            return false; 
        return pat.matcher(mail).matches(); 
    } 
	
	
	
}
