package Projet;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Permet la création d'une <b> Rangee </b>
 * @author Romain Chuat, Joris Marza
 */
public class Rangee {
	private Queue<Vehicule> rangee;
	Iterator<Vehicule> iter;
	private double chargeActuelle;
	private double longueur;
	
	/**
	 * Constructeur défaut.
	 * Créer une <code>Rangee</code>.
	 */
	public Rangee() {
		this.longueur = 10;
		this.rangee = new LinkedList<Vehicule>();
		this.chargeActuelle = 0;
	}
	/**
	 * Constructeur défaut.
	 * Créer une <code>Rangee</code>.
	 * @param longueur la longeur de la <code>Rangee</code>
	 */
	public Rangee(double longueur) {
		this.longueur = longueur;
		this.rangee = new LinkedList<Vehicule>();
		this.chargeActuelle = 0;
	}	
	/**
	 * Ajoute (embarque) un vehicule à la <code>rangee</code>.
	 * @param v un Vehicule
	 */
	public void ajouter(Vehicule v) {
		this.rangee.add(v);
		this.chargeActuelle+=v.getPoids();
	}
	/**
	 * Supprime (débarque) le véhicule en tête dans la <code>rangee</code>
	 * @return le véhicule supprimer(débrqué) de la <code>rangee</code>
	 */
	public Vehicule sortir() {
		if(!this.isEmpty()) {
			//System.out.print("\nVehicule debarque :\n"+this.rangee.poll());
			return this.rangee.poll();
		}
		return null;
	}
	/**
	 * Calcul la longueur occupée par les vehicules dans la <code>rangee</code> (espace de 0.5m compris).
	 * On considère qu'il n'y a pas d'espace de 0.5 m au extremités de la rangée.
	 * @return la longueur occupée par les vehicules dans la <code>rangee</code> (espace de 0.5m compris)
	 */
	public double longueurOccupe() {
		iter = rangee.iterator();
		double somme = 0;
		while(iter.hasNext()) {
			Vehicule v = iter.next();
			somme += v.getLongueur();
			if(somme+0.5<this.longueur) {
				somme+=0.5;
			}
		}
		return somme;
	}
	/**
	 * @return la charge Actuelle dans la <code>Rangee</code>
	 */
	public double getCharge() {
		return this.chargeActuelle;
	}
	public Queue<Vehicule> getRangee() {
		return this.rangee;
	}
	/**
	 * Calcul nombre d'élement dans la <code>rangee</code> (la taille de <code>rangee</code>).
	 * @return le nombre d'élement dans la <code>rangee</code>
	 */
	public int size() {
		if(!this.isEmpty()) {
			return rangee.size();
		}
		return 0;
	}
	/**
	 * Supprime l'élement(le Vehicule) en tete de <code>rangee</code>.
	 * @return l'élement(Vehicule) supprimé
	 */
	public Vehicule poll() {
		return rangee.poll();
	}
	/**
	 * @return l'élément(Vehicule) en tête de la <code>rangee</code>
	 */
	public Vehicule peek() {
		return rangee.peek();
	}
	/**
	 * Test si la <code>rangee</code> est vide.
	 * @return true si la range est vide, false sinon
	 */
	public boolean isEmpty() {
		return rangee.isEmpty();
	}
	/**
	 * Construit une représentation chainée de la <code>rangee</code>.
	 * La chaine comprends tous le véhicules contenue dans la <code>rangee</code>.
	 */
	public String toString() {
		if(rangee.isEmpty()) {
			return "la rangee est vide\n";
		}
		String res = "";
		iter = rangee.iterator();
		int i = 1;
		while(iter.hasNext()) {
			Vehicule v = iter.next();
			res += "\t### Vehicule "+i+" ###\n"+v.toString()+"\n";
			i++;
		}
		return res;
	}
}
