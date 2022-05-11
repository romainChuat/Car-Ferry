package Projet;

/**
 * Classe permettant la création d'un <b> Vehicule </b>
 * @author Romain Chuat, Joris Marza
 *
 */
public abstract class Vehicule  implements Comparable<Vehicule>{
	private String immatriculation;
	private double chargeAVide;
	private double longueur;
	private Personne conducteur;
	
	/**
	 * Calcul le tarif associé au <code>Vehicule</code>.
	 * @return le tarif associé au <code>Vehicule</code>
	 */
	public abstract double tarif();
	
	/**
	 * Constructeur.
	 * Créer un nouveau <code>Vehicule</code>.
	 * @param immatriculation l'immatriculation du <code>Vehicule</code>
	 * @param chargeAVide la charge à vide <code>Vehicule</code>
	 * @param longueur la longueur<code>Vehicule</code>
	 * @param conducteur le conducteur<code>Vehicule</code>
	 */
	Vehicule(String immatriculation,double chargeAVide,double longueur,Personne conducteur){
		this.immatriculation = immatriculation;
		this.chargeAVide = chargeAVide;
		this.longueur = longueur;
		this.conducteur = conducteur;
	}
	/**
	 * @return la <b>longueur</b> du <code>Vehicule</code>
	 */
	public double getLongueur() {
		return this.longueur;
	}
	/**
	 * @return le <code>Conducteur</code> du <code>Vehicule</code>
	 */
	public Personne getConducteur() {
		return this.conducteur;
	}
	/**
 	 * @return le nom du Conducteur du <code>Vehicule</code>
	 */
	public String getNomConducteur() {
		return this.conducteur.getNom();
	}
	/**
 	 * @return le prenom du Conducteur du <code>Vehicule</code>
	 */
	public String getPrenomConducteur() {
		return this.conducteur.getPrenom();
	}
	/**
	 * @return la charge à vide du <code>Vehicule</code>
	 */
	public double getPoids() {
		return this.chargeAVide;
	}
	public String getImmatricualtion() {
		return this.immatriculation;
	}
	/**
	 * Construit une représentation chainée du <code>Vehicule</code>.
	 * La chaine comprend l'immatriculation, le poids du vehicule, sa longueur et son conducteur.
	 * @return un représentation chainée du <code>Vehicule</code>
	 */
	public String toString() {
		String res = "";
		res+= "immatriculation : "+this.immatriculation+"\n";
		res+= "poids a vide : "+this.chargeAVide+"\n";
		res+= "Longueur : "+this.longueur+"\n";
		res+= "Conducteur : \n"+this.conducteur+"\n";
		return res;
	}
	/**
	 * Construit une représentation chainée du <code>Vehicule</code>.
	 * Utile pour l'affichage d'un ticket dans la <code>FenetreCale</code>.
	 * La chaine comprend l'immatriculation, le poids du vehicule, sa longueur et son conducteur.
	 * @return un représentation chainée du <code>Vehicule</code>.
	 */
	public String convertToString() {
		return this.conducteur.getNom()+" "+this.conducteur.getPrenom()+" "+this.getImmatricualtion();
	}
	/**
	 * Compare un <code>Vehicule v</code> au Vehicule courant (<code>this</code>).
	 * @param v un Vehicule
	 * @return 0 si l'immatriculation du <code>Vehicule v</code> et du Vehicule courant (<code>this</code>) sont identiques, 
	 * un entier inférieur ou supérieur à 0 sinon
	 */
	public int compareTo(Vehicule v) {
		return this.getImmatricualtion().compareTo(v.getImmatricualtion());
	}
	/**
	 * Test si Object o est égal au <code>Vehicule</code> courant (<code>this</code>).
	 * @param o un Objet
	 * @return true, si Object o est égal au <code>Vehicule</code> courant (<code>this</code>)
	 */
	public boolean equals (Object o) {
		if (! (o instanceof Vehicule))
			return false;
		Vehicule v = (Vehicule) o;
		return (this.getImmatricualtion().equals(v.getImmatricualtion()));
	}
	
}
