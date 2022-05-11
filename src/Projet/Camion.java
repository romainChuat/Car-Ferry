package Projet;

/**
 * Classe permettant la création d'un <b> Camion </b>
 * @author Romain Chuat, Joris Marza
 **/
public class Camion extends Vehicule{
	private double cargaison;
	/**
	 * Constructeur.
	 * Créer un nouveau Camion
	 * @param immatriculation l'immatriculation du <code>Camion</code>
	 * @param poids le poids (en tonnes) <code>Camion</code>
	 * @param longueur la longueur du <code>Camion</code>
	 * @param conducteur le conducteur du <code>Camion</code>
	 * @param cargaison transporté par le <code>Camion</code> (tonnes)
	 */
	public Camion(String immatriculation,double poids,double longueur,Personne conducteur, double cargaison){
		super(immatriculation,poids,longueur,conducteur);
		this.cargaison = cargaison;
	}
	/**
	 * Construit une représentation chainée d'un <code>Camion</code>.
	 *	La chaine comprend la repésentation chainée du véhicule et on y ajoute la cargaison.
	 * @return une chaine représentant le <code>Camion</code>
	 */
	public String toString() {
		return "Camion : \n"+super.toString() +"Cargaison :  "+this.cargaison+"\n";
	}
	/**
	 * Calcul le tarif associé au <code>Camion</code>.
	 * @return le tarif du <code>Camion</code>
	 */
	public double tarif() {
		return 45+0.1*(this.cargaison*1000);
	}
	/**
	 * Calcul du poids total du <code>Camion</code> (poids+cargaison)
	 * @return le poids du <code>Camion</code>
	 */
	public double getPoids() {
		return this.cargaison + super.getPoids();
	}
}
