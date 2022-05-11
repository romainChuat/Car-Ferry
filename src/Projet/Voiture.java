package Projet;

/**
 * Permet la création d'une <b> Voiture </b>
 * @author Romain Chuat, Joris Marza
 */
public class Voiture extends Vehicule{
	private int nbPassager;
	
	/**
	 * Constructeur.
	 * Créer une <code>Voiture</code>.
	 * @param immatriculation l'immatricualtion de la <code>Voiture</code>
	 * @param poids le poids de la <code>Voiture</code>
	 * @param longueur la longueur de la <code>Voiture</code>
	 * @param conducteur le conducteur de la <code>Voiture</code>
	 * @param nbPassager le nombre de passager de la <code>Voiture</code>
	 */
	public Voiture(String immatriculation,double poids,double longueur,Personne conducteur, int nbPassager){
		super(immatriculation,poids,longueur,conducteur);
		this.nbPassager = nbPassager;
	}
	/**
	 * Calcul le tarif associé à la <code>Voiture</code>.
	 * On ne prends pas en compte le conducteur dans le nombre de passagers.
	 * @return le tarif de la voiture
	 */
	public double tarif() {
		return 35 + 3*this.nbPassager;
	}
	/**
	 * @return le nombre de passagers de la <code>Voiture</code>
	 */
	public int getNbPassager() {
		return this.nbPassager;
	}
	/**
	 * Construit une représentation chainée de la <code>Voiture</code>.
	 * La chaine comprend la repésentation chainée du Vehicule et on y ajoute le nombre de passagers.
	 */
	public String toString() {
		return "Voiture :\n"+super.toString() +"Nombre de passagers :  "+this.nbPassager+"\n";
	}
}