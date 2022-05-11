package Projet;

import javax.swing.*;

/**
 * Permet la création d'une <b> Car-Ferry </b>.
 * @author Romain Chuat, Joris Marza
 */
public class CarFerry extends JFrame /*implements ActionListener*/{
	private int nbPassager;
	private Cale cale;
	private FenetreCarFerry fenetreCF;
	
	/**
	 * Constructeur défaut.
	 * Créer un <code>CarFerry</code>.
	 */
	public CarFerry() {
		cale = new Cale();
		this.nbPassager = 0;
	}
	/**
	 * Constructeur.
	 * Créer un <b>CarFerry</b>.
	 * @param longueur la longueur de la cale du <code>CarFerry</code>
	 * @param chargeMax la charge maximum acceptée sur le <code>CarFerry</code>
	 */
	public CarFerry(double longueur, double chargeMax) {
		cale = new Cale(longueur,chargeMax);
		this.nbPassager = 0;
		fenetreCF = new FenetreCarFerry(this);
	}
	public boolean ajouterVehicule(Vehicule v) throws EmbarquementException{
			try{
				this.cale.rentrer(v);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
				return false;
			}
			if(v instanceof Voiture) {
				Voiture voiture = (Voiture)v;
				this.nbPassager += voiture.getNbPassager();
			}
		return true;
	}
	/**
	 * Debarque les vehicules de la cale du <code>CarFerry</code>.
	 * @return le Vehicule sortie
	 */
	public Vehicule retirerVehicule(){
		System.out.print("\n#### Debarquement ####\n");
		Vehicule v = cale.sortir();
		if(v instanceof Voiture) {
			Voiture voiture = (Voiture)v;
			this.nbPassager -= voiture.getNbPassager();
		}
		return v;
		
	}
	/**
	 * Test si la <code> cale </code> est vide
	 * @return true si la cale est vide, false sinon
	 */
	public boolean isEmpyt() {
		return this.cale.isEmpty();
	}
	/**
	 * Creer un representation chainée du <code>CarFerry</code>.
	 * La chaine comprend la représentation chainée de la cale et le nombre de passagers sur le <code>CarFerry</code>.
	 */
	public String toString() {
		String str = "\n\t\t******Cale du CarFerry******\n\n";
		str += this.cale.toString();
		str += this.nbPassager>0 ? "Nombre de Passager sur le Ferry : "+this.nbPassager+"\n\n" : "Aucun Passager a bord du Ferry\n";
		return str;
	}
	/**
	 * @return la <code>cale </code>.
	 */
	public Cale getCale() {
		return this.cale;
	}
}
