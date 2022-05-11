package Projet;

/**
 * Permet la création d'une <b> Personne </b>
 * @author Romain Chuat, Joris Marza
 * 
 */
public class Personne implements Comparable<Personne> {
	private String nom;
	private String prenom;
	private String noPermis;
	
	/**
	 * Constructeur.
	 * Créer une <code>Personne</code>.
	 * @param nom le nom de la <code>Personne</code>
	 * @param prenom le prenom de la <code>Personne</code>
	 * @param noPermis le numéro de permis de la <code>Personne</code>
	 */
	public Personne(String nom,String prenom,String noPermis){
		this.nom = nom;
		this.prenom = prenom;
		this.noPermis = noPermis;
	}
	/**
	 * Constructeur.
	 * Créer une <code>Personne</code>.
	 * @param nom le nom de la <code>Personne</code>
	 * @param prenom le prenom de la <code>Personne</code>
	 */
	Personne(String nom,String prenom){
		this.nom = nom;
		this.prenom = prenom;
	}
	/**
	 * @return le nom de la <code>Personne</code>
	 */
	public String getNom() {
		return this.nom;
	}
	/**
	 * @return le prenom de la <code>Personne</code>
	 */
	public String getPrenom() {
		return this.prenom;
	}
	/**
	 * Compare une <code>Personne p</code> à la personne courante (<code>this</code>).
	 * @param p une Personne
	 * @return 0 si les <code>Personnes</code> sont identiques(nom et prenom égaux), un entier inférieur ou supérieur à 0 sinon
	 */
	public int compareTo(Personne p) {
		int r= this.getNom().compareTo(p.getNom());
		if (r==0) r= this.getPrenom().compareTo(p.getPrenom());
		return r;
	}
	/**
	 * Test si une <code>Personne p</code> est égale à la personne courante (<code>this</code>).
	 * @param o un Objet
	 * @return true si o est égale à la personne courante (this)
	 */
	public boolean equals (Object o) {
		if (! (o instanceof Personne))
			return false;
		Personne p=(Personne) o;
		return (this.getNom().equals(p.getNom()) && this.getPrenom().equals(p.getPrenom()));
	}
	/**
	 * Construit une représentation chainée d'une <code>Personne</code>.
	 * la chaine comprend le nom,le prenom et le numéro de permis
	 */
	public String toString() {
		return " - nom : "+this.nom+"\n - prenom : "+this.prenom+"\n - NO permis : "+this.noPermis;
	}
}
