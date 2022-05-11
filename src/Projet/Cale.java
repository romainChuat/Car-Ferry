package Projet;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Permet la création d'une <b> Cale </b>.
 * @author Romain Chuat, Joris Marza
 */
public class Cale {
	private double chargeMax;
	private double longueur;
	private Rangee rangeDroite;
	private Rangee rangeGauche;
	private List<Ticket> listing;
	private double chargeActuelle;
	
	/**
	 * Constructeur défaut.
	 * Créer une <code>Cale</code>.
	 */
	public Cale() {
		listing = new ArrayList<Ticket>();
		this.rangeDroite = new Rangee();
		this.rangeGauche = new Rangee();
	}
	/**
	 * Constructeur.
	 * Créer une <code>Cale</code>.
	 * @param longueur la longeur de la <code>Cale</code>
	 * @param chargeMax la charge maximum acceptée dans la <code>Cale</code>
	 */
	public Cale(double longueur, double chargeMax) {
		listing = new ArrayList<Ticket>();
		this.rangeDroite = new Rangee(longueur);
		this.rangeGauche = new Rangee(longueur);
		this.chargeMax = chargeMax;
		this.chargeActuelle = 0;
		this.longueur = longueur;
	}
	public Rangee getRangeeI(int i) {
		if(i == 1) {
			return this.rangeDroite;
		}else {
			return this.rangeGauche;
		}
	}
	public List<Ticket> getListing(){
		return this.listing;
	}
	
	/**
	 * Ajoute un vehicule dans la <code>Cale</code>.
	 * Respecte l'equilibre du poids entre les 2 rangees.
	 * @param v un Vehicule
	 * @throws Exception Si le vehicule ne peut pas etre rentre dans la <code>Cale</code>
	 */
	public boolean rentrer(Vehicule v) throws EmbarquementException{		
		if(this.chargeActuelle +v.getPoids()>this.chargeMax) {
			throw new EmbarquementException("Error : le vehicule est trop lourd pour embarquer");
		}else if(checkLongueur(v,rangeDroite) && checkLongueur(v,rangeGauche)){ //rangeGauche.longueurOccupe()+v.getLongueur()>this.longueur  
			throw new EmbarquementException("Error : le vehicule est trop long pour embarquer");
			/**ici on considere que si on ne peut pas ajouter un vehicule sans espace entre les 2 vehicules alors on ne pourra
			 * pas ajouter le vehicule avec un espace, 
			 * la prise en compte de l'espace est faite au moment du calcul de la longeur occupee (fonction : longueurOccupe de la classe Rangee)
			*/
		}else if(this.conducteurIsPresent(v.getConducteur())) {
			throw new EmbarquementException("Error : le conducteur ne peut pas embarquer 2 vehicules à son nom");
		}else{ 
			/**
			 * diff1 vaut : la difference entre la rangee droite et la rangee gauche
			 * si le vehicule est ajoute sur la rangee droite
			 */
			double diff1 = Math.abs((rangeDroite.getCharge()+v.getPoids())-rangeGauche.getCharge());
			/**
			 * diff2 vaut : la difference entre la rangee droite et la rangee gauche
			 * si le vehicule est ajoute sur la rangee gauche
			 */
			double diff2 = Math.abs((rangeGauche.getCharge()+v.getPoids())-rangeDroite.getCharge());
			//on ajoute le vehicule dans la rangé pour laquel la difference est la moins importante
			if(diff1 < diff2) {
				this.rangeDroite.ajouter(v);
				ajouterTicket(new Ticket(v.getNomConducteur(),v.getPrenomConducteur(),""+rangeDroite.size()+"D",v.tarif(), v.getImmatricualtion()));
				this.chargeActuelle += v.getPoids();
			}else {
				this.rangeGauche.ajouter(v);
				ajouterTicket(new Ticket(v.getNomConducteur(),v.getPrenomConducteur(),""+rangeGauche.size()+"G",v.tarif(),v.getImmatricualtion()));
				this.chargeActuelle += v.getPoids();
			}
		}
		return true;
	}
	/**
	 * Sort les véhicules 1 à 1 de la <code>Cale</code> en gardant un équilibre entre la rangée droite et la rangée gauche.
	 * Affiche les véhicules debarqués dans l'ordre de débarquement.
	 * 
	 * @return le Vehicule sortie de la cale.
	 */
	public Vehicule sortir() {
		int i = 1;
		Vehicule v;
		if(rangeDroite.isEmpty()) {
			v = rangeGauche.sortir();
		}
		else {
			if(rangeGauche.isEmpty()) {
				v = rangeDroite.sortir();
			}else {
				double diff1 = Math.abs((rangeDroite.getCharge()-rangeDroite.peek().getPoids())-rangeGauche.getCharge());
				double diff2 = Math.abs((rangeGauche.getCharge()-rangeGauche.peek().getPoids())-rangeDroite.getCharge());
				if(diff1 > diff2){
					v = rangeGauche.sortir();
				}else {
					v = rangeDroite.sortir();
				}
			}
		}
		System.out.print("\nVehicule "+i+" debarque\n"+v);
		i++;
		return v;
	}
	/**
	 * Test si la longueur du véhicule dépasse la longueur disponible.
	 * @param v un Vehicule
	 * @param r une Rangee
	 * @return true si longueur du véhicule + longueur dejà occupée > longueur de la <code>Cale</code>, false sinon
	 */
	public boolean checkLongueur(Vehicule v, Rangee r) {
		return r.longueurOccupe()+v.getLongueur()>this.longueur;
	}
	/**
	 * Test si le conducteur à déjà un véhicule à son nom dans la <code>Cale</code>.
	 * @param p une Personne
	 * @return true si un ticket portant le nom de la Personne p existe, false sinon.
	 */
	public boolean conducteurIsPresent(Personne p) {
		for(Ticket ticket : listing) {
			Personne p1 = new Personne(ticket.getNom(),ticket.getPrenom());
			if(p.equals(p1)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Ajoute un Ticket à la liste de Tickets (<code>listing</code>).
	 * @param t un Ticket
	 */
	public void ajouterTicket(Ticket t) {
		this.listing.add(t);
		this.trierListing();
	}
	/**
	 * vide la liste de Tickets (<code>listing</code>). 
	 */
	public void viderListing() {
			listing.clear();
	}
	/**
	 * Trie la liste de Tickets (<code>listing</code>) par ordre alphabétique des nom de conducteurs.
	 */
	public void trierListing() {
		Collections.sort(listing);
	}
	/**
	 * Construit une représentation chainée de la liste de Tickets (<code>listing</code>).
	 * @return une représentation chainée de la liste de Tickets (<code>listing</code>)
	 */
	public String afficherListing() {
		String res="";
		res += "###liste des tickets###\n";
		if(this.isEmpty()) {
			return res+="Aucun véhicule a bord\n";
		}
		int i= 1;
		for(Ticket ticket : listing) {
			res+="ticket "+i+"\n"+ticket+"\n";
			i++;
		}
		return res;
	}
	/**
	 * Test si la <code>Cale</code> est vide.
	 * @return true si la <code>Cale</code> est vide, false sinon.
	 */
	public boolean isEmpty() {
		return rangeDroite.isEmpty() && rangeGauche.isEmpty();
	}
	/**
	 * Construit une représentation chainée de la <code>Cale</code>,
	 * la chaine comprend la rangée de droite, la rangée de gauche et la liste des tickets (<code>listing</code>).
	 * @return une représentation chainée de la <code>Cale</code>
	 */
	public String toString() {
		String res = "";
		res += "\n***Rangee de droite : \n\n";
		res+= rangeDroite.toString()+"\n";
		res += "\n***Rangee de gauche : \n\n";
		res+= rangeGauche.toString()+"\n";
		res+=afficherListing();
		return res;
	}

	
}
