package lesclassesduprojet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Statistiquedutauxdabsenteisme {
	private int[] niveau;
    private Set<String> filiere;
    private List<Classe> classes;
    
    public Statistiquedutauxdabsenteisme() {
        this.niveau = new int[5];
        for (int i = 1; i < 6; ++i) {
            this.niveau[i - 1] = i;
        }
        this.filiere = new HashSet<String>();
        List<Classe> list = new ArrayList<Classe>();
      //  list = new ClasseDAO().ListerClasse();
        for (final Classe c : list) {
            this.filiere.add(c.getFiliere());
        }
       /* for (final String s : this.filiere) {
            System.out.println(s);
        }
        */
    }

	public int[] getNiveau() {
		return niveau;
	}

	public void setNiveau(int[] niveau) {
		this.niveau = niveau;
	}

	public Set<String> getFiliere() {
		return filiere;
	}

	public void setFiliere(Set<String> filiere) {
		this.filiere = filiere;
	}

	public List<Classe> getClasses() {
		return classes;
	}

	public void setClasses(List<Classe> classes) {
		this.classes = classes;
	}
    
}
